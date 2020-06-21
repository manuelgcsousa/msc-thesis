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
	Set<String> grammar_members;
	List<String> grammar_error_conditions;
	
	/* Data structure to store mandatory components. */
	Map<String, Integer> required_components;
}


processor 
@init {
	/* Main data structure. */
	List<RoseTree> struct = new ArrayList<>();

	grammar_members = new LinkedHashSet<>();
	grammar_error_conditions = new ArrayList<>();

	required_components = new HashMap<>();
}
	: structure[struct] 
	  errors[struct] 
	  input[struct] 
	{
        /* Class that handles the generation of the specific grammar. */
		Generator.generateGrammar(
			struct,
			grammar_error_conditions
		);
	}
;



/* *********************************************************** */
/* ************************ STRUCTURE ************************ */
/* *********************************************************** */

structure[List<RoseTree> struct]
	: 'STRUCTURE:' ( part[struct] )+ { Utils.getRequiredComponents(struct, required_components); }
;

part[List<RoseTree> struct]
@init {
	String path = "";
}
	: 'part' element[path, struct]
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
		
		// Creation of a new node.
		child = new RoseTree($c.text);
		child.setPath(path);

		// Add component to total 'path'.
		path += ($c.text + "__");
		
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
			
			grammar_members.add(path + $a1.text.toUpperCase());
		} 
		( ',' a2=WORD {
			child_attributes.put($a2.text, "");			

			grammar_members.add(path + $a2.text.toUpperCase());
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
	: ( 'ERRORS:' ( c=condition[struct] { grammar_error_conditions.add($c.logical_condition); } ';' )+ )?
;


condition[List<RoseTree> struct]
returns[String logical_condition]
@init {
    List<String> exp = new ArrayList<>();
}
    : a1=assignment[struct] { exp.add($a1.logical_expression); }
    ( op=('AND'|'OR') { if ($op.text.equals("AND")) exp.add("&&"); else exp.add("||"); }
      a2=assignment[struct] { exp.add($a2.logical_expression); } )*
    {
        $logical_condition = "if (";
		
        for (String e : exp)
            $logical_condition += (" " + e);
		
        $logical_condition += " ) { System.out.println(\"ERROR!\"); }"; // Rever erro da condição!
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
						"- O atributo '%s' correspondente ao componente '%s' não foi declarado em STRUCTURE.\n",
						$attribute,
						last_eval_comp
					);
				
				Utils.print_msg(0, "STRUCTURE", err);
			}
		} else {
			String err = String
				.format(
					"- O padrão de componentes %s não é válido.\n",
					$components
				);
			
			Utils.print_msg(0, "STRUCTURE", err);
		}
	}
;


/*
errors[List<RoseTree> struct]
	: ( 'ERRORS:' ( e=expression[struct] { grammar_error_conditions.add($e.logical_expression); } ';' )+ )?
;

expression[List<RoseTree> struct]
returns[String logical_expression]
@init {
	List<String> exp = new ArrayList<>();
}
	: c1=condition[struct] { exp.add($c1.logical_condition); }  
	( op=('AND'|'OR') { if ($op.text.equals("AND")) exp.add("&&"); else exp.add("||"); } 
	  c2=condition[struct] { exp.add($c2.logical_condition); } )* 
	{
        $logical_expression = "if (";

		for (String e : exp) {
			$logical_expression += (" " + e);
		}
		$logical_expression += " ) { System.out.println(\"ERROR!\"); }";
	}
;

condition[List<RoseTree> struct]
returns[String logical_condition]
@init {
	List<String> components = new ArrayList<>();
	List<RoseTree> children;
}
	: c1=WORD { components.add($c1.text); } ('.' c2=WORD { components.add($c2.text); })* '->' a=WORD op=('='|'!=') '"' v=WORD '"'
	{
		boolean path = true;
		String last_eval_comp = null;

		List<RoseTree> aux_children = $struct;
		RoseTree aux_node = null;
		
		for (int i = 0; i < components.size() && path != false; i++) {
			last_eval_comp = components.get(i);

			aux_node = containsValue(aux_children, last_eval_comp, null);

			if (aux_node != null) {
				aux_children = aux_node.getChildren();
			} else {
				path = false;
			}
		}
		

		// If 'path' still has value of 'true' then the path is valid.
		if (path) {
			// Search within the mapping of the last node of the path and check if the attribute '$a.text' is valid.
			String value = aux_node.hasAttribute($a.text);
			
			if (value != null) {
				// Build string that corresponds to the condition.
				$logical_condition = "";
				String comp = "";

				int i = 0;
				for (i = 0; i < components.size(); i++) {
					comp = components.get(i);
					$logical_condition += (comp + "__");
				}
				$logical_condition += ($a.text.toUpperCase());
				
				if ($op.text.equals("!=")) {
					$logical_condition = ("!" + $logical_condition);
				}

				$logical_condition += (".equals(\"" + $v.text + "\")");
			} else {
				String err = String
					.format(
						"- O atributo '%s' correspondente ao componente '%s' não foi declarado em STRUCTURE.\n",
						$a.text,
						last_eval_comp
					);
				
				print_msg(0, "STRUCTURE", err);
			}
		} else {
			String err = String
				.format(
					"- O padrão de componentes %s não é válido.\n",
					components
				);
			
			print_msg(0, "STRUCTURE", err);
		}
	}
;
*/


/* ******************************************************* */
/* ************************ INPUT ************************ */
/* ******************************************************* */

input[List<RoseTree> struct]
	: 'INPUT:' phrase[struct]
	// 'INPUT:' ( 'phrase' '(' phrase[struct] ')' )+
;

phrase[List<RoseTree> struct]
@init {
	String path = "";
}
	: ( '-' parts[path, struct] )+
	{
		for (Map.Entry<String, Integer> entry : required_components.entrySet()) {
			if (entry.getValue() != 0) {
				String err = String
					.format(
						"- Existem componentes obrigatórios que não foram definidos.\n"
					);
					
				Utils.print_msg(0, "INPUT", err);
			}
		}
		
		// Reset 'required_components' values to 1.
		required_components.replaceAll( (k, v) -> 1 );
	}
;

parts[String path, List<RoseTree> struct] 
	: '(' block[path, struct] ( ',' block[path, struct] )* ')'
;

block[String path, List<RoseTree> struct]
@init {
	RoseTree child;
}
	: c=WORD {
		child = Utils.containsValue($struct, $c.text, true);

		if (child == null) {
			String err = String
				.format(
					"- O componente '%s' não é permitido nas regras definidas em STRUCTURE.\n",
					$c.text
				);
			
			Utils.print_msg(0, "INPUT", err);
		} else {
			// If the element is mandatory \
			// then remove the first occurence of the component in the global list.
			if (child.getRequiredState()) {
				required_components.replace($c.text, 0);
			}

			path += ($c.text + "__");
		}
	} content[$c.text, path, child]
;

content[String parent_comp, String path, RoseTree node]
@init {
	boolean hasAttrs = false;
	boolean hasSubparts = false;
}
	: (s=slice)? ( attrs[parent_comp, path, node] { hasAttrs = true; } )? ( parts[path, node.getChildren()] { hasSubparts = true; } )?
	{
		if (!hasAttrs) {
			// If the node attributes are not empty, then an error should come up.
			if (!node.getAttributes().isEmpty()) { 
				String err = String
					.format(
						"- Existem atributos relativos ao componente '%s' que não foram definidos.\n",
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
						"- O atributo '%s' pertencente ao componente '%s' não foi definido.\n",
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
					"- O atributo '%s' pertencente ao componente '%s' não é válido.\n",
					$e1.attribute,
					value
				);
			
			Utils.print_msg(0, "INPUT", err);
		}

		if ( $attr_value.containsKey($e1.attribute) ) {
			String warn = String
				.format(
					"- O atributo '%s' já foi declarado! Assume-se o último valor encontrado.\n",
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
					"- O atributo '%s' pertencente ao componente '%s' não é válido.\n",
					$e2.attribute,
					value
				);
			
			Utils.print_msg(0, "INPUT", err);
		}

		if ( $attr_value.containsKey($e2.attribute) ) {
			String warn = String
				.format(
					"- O atributo '%s' já foi declarado! Assume-se o último valor encontrado.\n",
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
