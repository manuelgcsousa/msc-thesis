grammar MetaGrammar;


@header {
	import java.util.Arrays;
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Set;
	import java.util.LinkedHashSet;
	import java.util.Map;
	import java.util.HashMap;
	import java.util.LinkedHashMap;
	
	// FILES
	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Paths;
	import java.nio.charset.StandardCharsets;
}

@members {
	/* Data structures that support the grammar creation. */
	Set<String> grammarMembers;
	List<String> grammarErrorConditions;
		
	/* Data structure to store mandatory components. */
	List<Map<String, Integer>> requiredComponents;
}


processor 
@init {
	/* Main data structure. */
	List<RoseTree> struct = new ArrayList<>();
	
	grammarMembers         = new LinkedHashSet<>();
	grammarErrorConditions = new ArrayList<>();
    
	requiredComponents = new ArrayList<>();
}
	: structure[struct] 
	  errors[struct] 
	  input[struct] 
	{
		/* Class that handles the generation of the specific grammar. */
		Generator.generateGrammar(
			struct,
			grammarErrorConditions
		);
	}
;



/* *********************************************************** */
/* ************************ STRUCTURE ************************ */
/* *********************************************************** */

structure[List<RoseTree> struct]
@init { int pointer = 0; }
	: 'STRUCTURE:' ( part[struct] )+
;

part[List<RoseTree> struct]
@init {
	String path = "";
}
	: 'part' '[' element[path, struct] ']'
;

element[String path, List<RoseTree> struct]
returns[String comp, boolean state]
@init {
	RoseTree child;
	boolean required = true;
}
	: '(' c=WORD {
		// Assigs return values.
		$comp = $c.text;
		$state = true;
		
		child = new RoseTree();
		child.addValue($c.text);

		path += $c.text;
	} ( '|' w=WORD { 
		child.addValue($w.text);
		path += "__c__" + $w.text;
	})*
	{
		path += "__";
		child.setPath(path);
		
		$struct.add(child);	
	}
	( ',' a=attributes[path, child] )? ( ',' subparts[$c.text, path, child.getChildren()] )? ')'
	( '?' { child.setRequiredState(false); $state = false; } )?
;

attributes[String path, RoseTree child]
@init {
	Map<String, String> child_attributes = child.getAttributes();
}
	: 'attributes' '{' 
		a1=WORD {
			child_attributes.put($a1.text, "");
			
			grammarMembers.add(path + $a1.text.toUpperCase());
		} 
		( ',' a2=WORD {
			child_attributes.put($a2.text, "");			

			grammarMembers.add(path + $a2.text.toUpperCase());
		} )* 
	'}'
;

subparts[String parent_comp, String path, List<RoseTree> children]
	: 'subparts' '[' e1=element[path, children] ( ',' e2=element[path, children] )* ']'
;



/* ******************************************************** */
/* ************************ ERRORS ************************ */
/* ******************************************************** */

errors[List<RoseTree> struct]
	: ( blk=('RULES'|'ERRORS') ':' ( 
		c=condition[struct] {
			if ($blk.text.equals("RULES"))
				$c.logical_condition = ("if ( !(" + $c.logical_condition + ")");
			else
				$c.logical_condition = ("if (" + $c.logical_condition);

			$c.logical_condition += 
				" ) { System.out.println(\"ERROR: Excepted - " + $c.text.replace('\"', '\'') + "\"); System.exit(0); }"
			;
			
			grammarErrorConditions.add($c.logical_condition);
		} ';' )+ 
	)?
;

/*
errors[List<RoseTree> struct]
	: ( 'ERRORS:' ( c=condition[struct] { grammarErrorConditions.add($c.logical_condition); } ';' )+ )?
;
*/

condition[List<RoseTree> struct]
returns[String logical_condition]
@init {
    List<String> exp = new ArrayList<>();
}
    : a1=assignment[struct] { exp.add($a1.logical_expression); }
    ( op=('AND'|'OR') { if ($op.text.equals("AND")) exp.add("&&"); else exp.add("||"); }
      a2=assignment[struct] { exp.add($a2.logical_expression); } )*
    {
		// $logical_condition = "if (";
		$logical_condition = "";
	
        for (String e : exp)
            $logical_condition += (" " + e);
		
        // $logical_condition += " ) { System.out.println(\"ERROR!\"); }"; /* Rever erro da condição! */
    }
;

assignment[List<RoseTree> struct] 
returns[String logical_expression]
    : exp1=expression[struct] op=('='|'!=') exp2=expression[struct]
    {
		String exp1_var = Utils.convertLogical($exp1.components, $exp1.attribute);
		String exp2_var = Utils.convertLogical($exp2.components, $exp2.attribute);        

		if ($op.text.equals("!="))
            $logical_expression = ("!" + exp1_var);

        $logical_expression += (".equals(" + exp2_var + ")");
    }
    | exp=expression[struct] op=('='|'!=') '"' val=WORD '"'
    {
		$logical_expression = Utils.convertLogical($exp.components, $exp.attribute);

        if ($op.text.equals("!="))
            $logical_expression = ("!" + $logical_expression);

        $logical_expression += (".equals(\"" + $val.text + "\")");
    }
;

expression[List<RoseTree> struct]
returns[List<String> components, String attribute]
@init {
    $components = new ArrayList<>();
    $attribute = "";
}
    : c1=WORD { $components.add($c1.text); } 
    ( '.' c2=WORD { $components.add($c2.text); } )* '->' ( attr=WORD { $attribute = $attr.text; } ) 
    {
        boolean path = true;
		String last_eval_comp = null;

		List<RoseTree> aux_children = $struct;
		RoseTree aux_node = null;
		
		for (int i = 0; i < $components.size() && path != false; i++) {
			last_eval_comp = $components.get(i);

			aux_node = Utils.containsValue(aux_children, last_eval_comp, null);

			if (aux_node != null) {
				aux_children = aux_node.getChildren();
			} else {
				path = false;
			}
		}

		// If 'path' still has value of 'true' then the path is valid.
		if (path) {
			// Search within the mapping of the last node of the path and check if '$attribute' is valid.
			String value = aux_node.hasAttribute($attribute);
			
			if (value == null) {
				String err = String
					.format(
                        "- The attribute '%s' related to the component '%s' was not declared in the STRUCTURE.\n",
						$attribute,
						last_eval_comp
					);
				
				Utils.print_msg(0, "STRUCTURE", err);
			}

			System.out.println(aux_node);
			// Enviar 'aux_node.path' para cima????
		} else {
			String err = String
				.format(
                    "- The pattern of components %s is not valid.\n",
					$components
				);
			
			Utils.print_msg(0, "STRUCTURE", err);
		}
	}
;



/* ******************************************************* */
/* ************************ INPUT ************************ */
/* ******************************************************* */

input[List<RoseTree> struct]
	: 'INPUT:' phrase[struct]
;

phrase[List<RoseTree> struct]
@init {
	String path = "";
    int pointer = 0;
	RoseTree child;
}
	: ( '-' parts[path, pointer, struct] {
		// get all the required components.	
		Map<String, Integer> component = new HashMap<>();
		Utils.getRequiredComponents(struct.get(pointer), component);
		requiredComponents.add(component);

		// calculate all the times required components appear.	
		Utils.calculateRequiredComponents(struct.get(pointer), requiredComponents.get(pointer));

		for (Map.Entry<String, Integer> entry : requiredComponents.get(pointer).entrySet()) {
            if (entry.getValue() != 0) {
				String err = String
					.format(
                        "- The mandatory component '%s' has not been defined.\n",
                        entry.getKey()
					);
					
				Utils.print_msg(0, "INPUT", err);
			}
        }

        pointer++;
    } )+
;

parts[String path, int pointer, List<RoseTree> struct]
	: '(' b1=block[path, pointer, struct] ( ',' b2=block[path, pointer, struct] )* ')' 
;

block[String path, int pointer, List<RoseTree> struct]
@init {
	RoseTree child;
}
	: c=WORD {
		child = Utils.containsValue($struct, $c.text, true);
		if (child == null) {
			String err = String
				.format(
                    "- The component '%s' is not allowed within the STRUCTURE rules.\n",
					$c.text
				);
			
			Utils.print_msg(0, "INPUT", err);
		} else {
			// depois de obter child, é necessário atualizar o atributo 'chosenValue' na RoseTree correspondente.		
			child.setChosenValue($c.text);
		}
	} content[$c.text, path, pointer, child]
;

content[String parent_comp, String path, int pointer, RoseTree node]
@init {
	boolean hasAttrs = false;
	boolean hasSubparts = false;
}
	: (s=slice)? ( attrs[parent_comp, path, node] { hasAttrs = true; } )? ( parts[path, pointer, node.getChildren()] { hasSubparts = true; } )?
	{
		if (!hasAttrs) {
			// If the node attributes are not empty, then an error should come up.
			if (!node.getAttributes().isEmpty()) { 
				String err = String
					.format(
                        "- There are attributes related to the component '%s' that were not defined.\n",
						node.getValue()
					);
				
				Utils.print_msg(0, "INPUT", err);
			}
		}

		if (!hasSubparts) {
			// Add lexical part to the respective node.
			node.getLexicalPart().add($s.str);

			// Reset string path.
			path = "";
		}
	}
;

slice returns[String str]
@init {
	$str = ""; 
}
	: ':' '"' w1=WORD { $str += $w1.text; } ( w2=WORD { $str += (" " + $w2.text); } )* '"'
;

attrs[String parent_comp, String path, RoseTree node]
@init {
	boolean hasEval = false;

	String value = $node.getValue();
	Map<String, String> attributes = $node.getAttributes();
}
	: '[' e=evaluations[path, node] ']'
	{
		for (String attr : attributes.keySet()) {
			if ($e.attr_value.containsKey(attr)) {
				String val = $e.attr_value.get(attr);

				attributes.put(attr, val);
			} else {
				String err = String
					.format(
                        "- The attribute '%s' related to the component '%s' was not defined.\n",
						attr,
						value
					);
				
				Utils.print_msg(0, "INPUT", err);
			}
		}
	}		
;

evaluations[String path, RoseTree node]
returns[Map<String, String> attr_value]
@init {
	String value = $node.getValue();
	Map<String, String> attributes = $node.getAttributes();

	$attr_value = new HashMap<>();
} 
	: e1=eval {
		if ( !attributes.containsKey($e1.attribute) ) {
			String err = String
				.format(
                    "- The attribute '%s' related to the component '%s' is not valid.\n",
					$e1.attribute,
					value
				);
			
			Utils.print_msg(0, "INPUT", err);
		}

		if ( $attr_value.containsKey($e1.attribute) ) {
			String warn = String
				.format(
                    "- The attribute '%s' has already been declared! Using the last value found.\n",
					$e1.attribute
				);
			
			Utils.print_msg(1, "INPUT", warn);
		}
		
		$attr_value.put($e1.attribute, $e1.value);
	}
	( ',' e2=eval {
		if ( !attributes.containsKey($e2.attribute) ) {
			String err = String
				.format(
                    "- The attribute '%s' related to the component '%s' is not valid.\n",
					$e2.attribute,
					value
				);
			
			Utils.print_msg(0, "INPUT", err);
		}

		if ( $attr_value.containsKey($e2.attribute) ) {
			String warn = String
				.format(
                    "- The attribute '%s' has already been declared! Using the last value found.\n",
					$e2.attribute
				);
			
			Utils.print_msg(1, "INPUT", warn);
		}
		
		$attr_value.put($e2.attribute, $e2.value);
	} )*
;

eval returns[String attribute, String value] 
	: a=WORD { $attribute = $a.text; } '=' '"' v=WORD { $value = $v.text; } '"'
;




/* LEXER */

WORD : (CHAR)+
;

WS : ([ \t\r\n]|COMMENT) -> skip
;

fragment CHAR : [a-zA-ZáéíóúÁÉÍÓÚâêîôûÂÊÎÔÛãõÃÕàèìòùÀÈÌÒÙçÇ_] 
;

fragment COMMENT
	: '/*'.*?'*/'               /* Multiple line comments. */
	| '//'~('\r'|'\n')*         /* Single line comment.    */
;
