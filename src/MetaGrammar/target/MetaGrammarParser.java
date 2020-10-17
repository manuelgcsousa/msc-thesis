// Generated from antlr4/MetaGrammar.g4 by ANTLR 4.8

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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MetaGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, WORD=26, WS=27;
	public static final int
		RULE_processor = 0, RULE_structure = 1, RULE_part = 2, RULE_element = 3, 
		RULE_attributes = 4, RULE_subparts = 5, RULE_errors = 6, RULE_condition = 7, 
		RULE_assignment = 8, RULE_expression = 9, RULE_input = 10, RULE_phrase = 11, 
		RULE_parts = 12, RULE_block = 13, RULE_content = 14, RULE_slice = 15, 
		RULE_attrs = 16, RULE_evaluations = 17, RULE_eval = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"processor", "structure", "part", "element", "attributes", "subparts", 
			"errors", "condition", "assignment", "expression", "input", "phrase", 
			"parts", "block", "content", "slice", "attrs", "evaluations", "eval"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'STRUCTURE:'", "'part'", "'('", "','", "')'", "'?'", "'attributes'", 
			"'{'", "'}'", "'subparts'", "'['", "']'", "'RULES'", "'ERRORS'", "':'", 
			"';'", "'AND'", "'OR'", "'='", "'!='", "'\"'", "'.'", "'->'", "'INPUT:'", 
			"'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "WORD", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MetaGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		/* Data structures that support the grammar creation. */
		Set<String> grammar_members;
		List<String> grammar_error_conditions;
		
		/* Data structure to store mandatory components. */
		List<Map<String, Integer>> required_components;

	public MetaGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProcessorContext extends ParserRuleContext {
		public StructureContext structure() {
			return getRuleContext(StructureContext.class,0);
		}
		public ErrorsContext errors() {
			return getRuleContext(ErrorsContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public ProcessorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_processor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterProcessor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitProcessor(this);
		}
	}

	public final ProcessorContext processor() throws RecognitionException {
		ProcessorContext _localctx = new ProcessorContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_processor);

			/* Main data structure. */
			List<RoseTree> struct = new ArrayList<>();

			grammar_members = new LinkedHashSet<>();
			grammar_error_conditions = new ArrayList<>();
		    
		    required_components = new ArrayList<>();

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			structure(struct);
			setState(39);
			errors(struct);
			setState(40);
			input(struct);

			        /* Class that handles the generation of the specific grammar. */
					Generator.generateGrammar(
						struct,
						grammar_error_conditions
					);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructureContext extends ParserRuleContext {
		public List<RoseTree> struct;
		public List<PartContext> part() {
			return getRuleContexts(PartContext.class);
		}
		public PartContext part(int i) {
			return getRuleContext(PartContext.class,i);
		}
		public StructureContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StructureContext(ParserRuleContext parent, int invokingState, List<RoseTree> struct) {
			super(parent, invokingState);
			this.struct = struct;
		}
		@Override public int getRuleIndex() { return RULE_structure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitStructure(this);
		}
	}

	public final StructureContext structure(List<RoseTree> struct) throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState(), struct);
		enterRule(_localctx, 2, RULE_structure);
		 int pointer = 0; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T__0);
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				part(struct);

				            Map<String, Integer> part = new HashMap<>();
				            Utils.getRequiredComponents(struct.get(pointer++), part);
				            required_components.add(part);
				        
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartContext extends ParserRuleContext {
		public List<RoseTree> struct;
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public PartContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PartContext(ParserRuleContext parent, int invokingState, List<RoseTree> struct) {
			super(parent, invokingState);
			this.struct = struct;
		}
		@Override public int getRuleIndex() { return RULE_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitPart(this);
		}
	}

	public final PartContext part(List<RoseTree> struct) throws RecognitionException {
		PartContext _localctx = new PartContext(_ctx, getState(), struct);
		enterRule(_localctx, 4, RULE_part);

			String path = "";

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__1);
			setState(52);
			element(path, struct);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementContext extends ParserRuleContext {
		public String path;
		public List<RoseTree> struct;
		public String comp;
		public boolean state;
		public Token c;
		public AttributesContext a;
		public TerminalNode WORD() { return getToken(MetaGrammarParser.WORD, 0); }
		public SubpartsContext subparts() {
			return getRuleContext(SubpartsContext.class,0);
		}
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ElementContext(ParserRuleContext parent, int invokingState, String path, List<RoseTree> struct) {
			super(parent, invokingState);
			this.path = path;
			this.struct = struct;
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitElement(this);
		}
	}

	public final ElementContext element(String path,List<RoseTree> struct) throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState(), path, struct);
		enterRule(_localctx, 6, RULE_element);

			RoseTree child;
			boolean required = true;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__2);
			setState(55);
			((ElementContext)_localctx).c = match(WORD);

					// Assigs return values.
					((ElementContext)_localctx).comp =  (((ElementContext)_localctx).c!=null?((ElementContext)_localctx).c.getText():null);
					((ElementContext)_localctx).state =  true;
					
					// Creation of a new node.
					child = new RoseTree((((ElementContext)_localctx).c!=null?((ElementContext)_localctx).c.getText():null));
					child.setPath(path);

					// Add component to total 'path'.
					path += ((((ElementContext)_localctx).c!=null?((ElementContext)_localctx).c.getText():null) + "__");
					
					_localctx.struct.add(child);
				
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(57);
				match(T__3);
				setState(58);
				((ElementContext)_localctx).a = attributes(path, child);
				}
				break;
			}
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(61);
				match(T__3);
				setState(62);
				subparts((((ElementContext)_localctx).c!=null?((ElementContext)_localctx).c.getText():null), path, child.getChildren());
				}
			}

			setState(65);
			match(T__4);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(66);
				match(T__5);
				 child.setRequiredState(false); ((ElementContext)_localctx).state =  false; 
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributesContext extends ParserRuleContext {
		public String path;
		public RoseTree child;
		public Token a1;
		public Token a2;
		public List<TerminalNode> WORD() { return getTokens(MetaGrammarParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MetaGrammarParser.WORD, i);
		}
		public AttributesContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AttributesContext(ParserRuleContext parent, int invokingState, String path, RoseTree child) {
			super(parent, invokingState);
			this.path = path;
			this.child = child;
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitAttributes(this);
		}
	}

	public final AttributesContext attributes(String path,RoseTree child) throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState(), path, child);
		enterRule(_localctx, 8, RULE_attributes);

			Map<String, String> child_attributes = child.getAttributes();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__6);
			setState(71);
			match(T__7);
			setState(72);
			((AttributesContext)_localctx).a1 = match(WORD);

						child_attributes.put((((AttributesContext)_localctx).a1!=null?((AttributesContext)_localctx).a1.getText():null), "");
						
						grammar_members.add(path + (((AttributesContext)_localctx).a1!=null?((AttributesContext)_localctx).a1.getText():null).toUpperCase());
					
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(74);
				match(T__3);
				setState(75);
				((AttributesContext)_localctx).a2 = match(WORD);

							child_attributes.put((((AttributesContext)_localctx).a2!=null?((AttributesContext)_localctx).a2.getText():null), "");			

							grammar_members.add(path + (((AttributesContext)_localctx).a2!=null?((AttributesContext)_localctx).a2.getText():null).toUpperCase());
						
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubpartsContext extends ParserRuleContext {
		public String parent_comp;
		public String path;
		public List<RoseTree> children;
		public ElementContext e1;
		public ElementContext e2;
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public SubpartsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SubpartsContext(ParserRuleContext parent, int invokingState, String parent_comp, String path, List<RoseTree> children) {
			super(parent, invokingState);
			this.parent_comp = parent_comp;
			this.path = path;
			this.children = children;
		}
		@Override public int getRuleIndex() { return RULE_subparts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterSubparts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitSubparts(this);
		}
	}

	public final SubpartsContext subparts(String parent_comp,String path,List<RoseTree> children) throws RecognitionException {
		SubpartsContext _localctx = new SubpartsContext(_ctx, getState(), parent_comp, path, children);
		enterRule(_localctx, 10, RULE_subparts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__9);
			setState(85);
			match(T__10);
			setState(86);
			((SubpartsContext)_localctx).e1 = element(path, children);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(87);
				match(T__3);
				setState(88);
				((SubpartsContext)_localctx).e2 = element(path, children);
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ErrorsContext extends ParserRuleContext {
		public List<RoseTree> struct;
		public Token blk;
		public ConditionContext c;
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public ErrorsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ErrorsContext(ParserRuleContext parent, int invokingState, List<RoseTree> struct) {
			super(parent, invokingState);
			this.struct = struct;
		}
		@Override public int getRuleIndex() { return RULE_errors; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterErrors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitErrors(this);
		}
	}

	public final ErrorsContext errors(List<RoseTree> struct) throws RecognitionException {
		ErrorsContext _localctx = new ErrorsContext(_ctx, getState(), struct);
		enterRule(_localctx, 12, RULE_errors);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12 || _la==T__13) {
				{
				setState(96);
				((ErrorsContext)_localctx).blk = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
					((ErrorsContext)_localctx).blk = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(97);
				match(T__14);
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(98);
					((ErrorsContext)_localctx).c = condition(struct);

								if ((((ErrorsContext)_localctx).blk!=null?((ErrorsContext)_localctx).blk.getText():null).equals("RULES"))
									((ErrorsContext)_localctx).c.logical_condition = ("if ( !(" + ((ErrorsContext)_localctx).c.logical_condition);
								else
									((ErrorsContext)_localctx).c.logical_condition = ("if (" + ((ErrorsContext)_localctx).c.logical_condition);

								((ErrorsContext)_localctx).c.logical_condition += " ) ) { System.out.println(\"ERROR!\"); }"; /* Rever erro da condição! */
								
								grammar_error_conditions.add(((ErrorsContext)_localctx).c.logical_condition);
							
					setState(100);
					match(T__15);
					}
					}
					setState(104); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WORD );
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public List<RoseTree> struct;
		public String logical_condition;
		public AssignmentContext a1;
		public Token op;
		public AssignmentContext a2;
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ConditionContext(ParserRuleContext parent, int invokingState, List<RoseTree> struct) {
			super(parent, invokingState);
			this.struct = struct;
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition(List<RoseTree> struct) throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState(), struct);
		enterRule(_localctx, 14, RULE_condition);

		    List<String> exp = new ArrayList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			((ConditionContext)_localctx).a1 = assignment(struct);
			 exp.add(((ConditionContext)_localctx).a1.logical_expression); 
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16 || _la==T__17) {
				{
				{
				setState(110);
				((ConditionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__17) ) {
					((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				 if ((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null).equals("AND")) exp.add("&&"); else exp.add("||"); 
				setState(112);
				((ConditionContext)_localctx).a2 = assignment(struct);
				 exp.add(((ConditionContext)_localctx).a2.logical_expression); 
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

					// ((ConditionContext)_localctx).logical_condition =  "if (";
					((ConditionContext)_localctx).logical_condition =  "";
				
			        for (String e : exp)
			            _localctx.logical_condition += (" " + e);
					
			        // _localctx.logical_condition += " ) { System.out.println(\"ERROR!\"); }"; /* Rever erro da condição! */
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public List<RoseTree> struct;
		public String logical_expression;
		public ExpressionContext exp1;
		public Token op;
		public ExpressionContext exp2;
		public ExpressionContext exp;
		public Token val;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode WORD() { return getToken(MetaGrammarParser.WORD, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AssignmentContext(ParserRuleContext parent, int invokingState, List<RoseTree> struct) {
			super(parent, invokingState);
			this.struct = struct;
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment(List<RoseTree> struct) throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState(), struct);
		enterRule(_localctx, 16, RULE_assignment);
		int _la;
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				((AssignmentContext)_localctx).exp1 = expression(struct);
				setState(123);
				((AssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__18 || _la==T__19) ) {
					((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(124);
				((AssignmentContext)_localctx).exp2 = expression(struct);

				        String exp1_var = Utils.convertLogical(((AssignmentContext)_localctx).exp1.components, ((AssignmentContext)_localctx).exp1.attribute);
				        String exp2_var = Utils.convertLogical(((AssignmentContext)_localctx).exp2.components, ((AssignmentContext)_localctx).exp2.attribute);
				        
				        if ((((AssignmentContext)_localctx).op!=null?((AssignmentContext)_localctx).op.getText():null).equals("!="))
				            ((AssignmentContext)_localctx).logical_expression =  ("!" + exp1_var);

				        _localctx.logical_expression += (".equals(" + exp2_var + ")");
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				((AssignmentContext)_localctx).exp = expression(struct);
				setState(128);
				((AssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__18 || _la==T__19) ) {
					((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(129);
				match(T__20);
				setState(130);
				((AssignmentContext)_localctx).val = match(WORD);
				setState(131);
				match(T__20);

				        ((AssignmentContext)_localctx).logical_expression =  Utils.convertLogical(((AssignmentContext)_localctx).exp.components, ((AssignmentContext)_localctx).exp.attribute);

				        if ((((AssignmentContext)_localctx).op!=null?((AssignmentContext)_localctx).op.getText():null).equals("!="))
				            ((AssignmentContext)_localctx).logical_expression =  ("!" + _localctx.logical_expression);

				        _localctx.logical_expression += (".equals(\"" + (((AssignmentContext)_localctx).val!=null?((AssignmentContext)_localctx).val.getText():null) + "\")");
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public List<RoseTree> struct;
		public List<String> components;
		public String attribute;
		public Token c1;
		public Token c2;
		public Token attr;
		public List<TerminalNode> WORD() { return getTokens(MetaGrammarParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MetaGrammarParser.WORD, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, List<RoseTree> struct) {
			super(parent, invokingState);
			this.struct = struct;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression(List<RoseTree> struct) throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState(), struct);
		enterRule(_localctx, 18, RULE_expression);

		    ((ExpressionContext)_localctx).components =  new ArrayList<>();
		    ((ExpressionContext)_localctx).attribute =  "";

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			((ExpressionContext)_localctx).c1 = match(WORD);
			 _localctx.components.add((((ExpressionContext)_localctx).c1!=null?((ExpressionContext)_localctx).c1.getText():null)); 
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(138);
				match(T__21);
				setState(139);
				((ExpressionContext)_localctx).c2 = match(WORD);
				 _localctx.components.add((((ExpressionContext)_localctx).c2!=null?((ExpressionContext)_localctx).c2.getText():null)); 
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
			match(T__22);
			{
			setState(147);
			((ExpressionContext)_localctx).attr = match(WORD);
			 ((ExpressionContext)_localctx).attribute =  (((ExpressionContext)_localctx).attr!=null?((ExpressionContext)_localctx).attr.getText():null); 
			}

			        boolean path = true;
					String last_eval_comp = null;

					List<RoseTree> aux_children = _localctx.struct;
					RoseTree aux_node = null;
					
					for (int i = 0; i < _localctx.components.size() && path != false; i++) {
						last_eval_comp = _localctx.components.get(i);

						aux_node = Utils.containsValue(aux_children, last_eval_comp, null);

						if (aux_node != null) {
							aux_children = aux_node.getChildren();
						} else {
							path = false;
						}
					}

					// If 'path' still has value of 'true' then the path is valid.
					if (path) {
						// Search within the mapping of the last node of the path and check if '_localctx.attribute' is valid.
						String value = aux_node.hasAttribute(_localctx.attribute);
						
						if (value == null) {
							String err = String
								.format(
			                        "- The attribute '%s' related to the component '%s' was not declared in the STRUCTURE.\n",
									_localctx.attribute,
									last_eval_comp
								);
							
							Utils.print_msg(0, "STRUCTURE", err);
						}
					} else {
						String err = String
							.format(
			                    "- The pattern of components %s is not valid.\n",
								_localctx.components
							);
						
						Utils.print_msg(0, "STRUCTURE", err);
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputContext extends ParserRuleContext {
		public List<RoseTree> struct;
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public InputContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InputContext(ParserRuleContext parent, int invokingState, List<RoseTree> struct) {
			super(parent, invokingState);
			this.struct = struct;
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitInput(this);
		}
	}

	public final InputContext input(List<RoseTree> struct) throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState(), struct);
		enterRule(_localctx, 20, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__23);
			setState(153);
			phrase(struct);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PhraseContext extends ParserRuleContext {
		public List<RoseTree> struct;
		public List<PartsContext> parts() {
			return getRuleContexts(PartsContext.class);
		}
		public PartsContext parts(int i) {
			return getRuleContext(PartsContext.class,i);
		}
		public PhraseContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PhraseContext(ParserRuleContext parent, int invokingState, List<RoseTree> struct) {
			super(parent, invokingState);
			this.struct = struct;
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitPhrase(this);
		}
	}

	public final PhraseContext phrase(List<RoseTree> struct) throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState(), struct);
		enterRule(_localctx, 22, RULE_phrase);

			String path = "";
		    int pointer = 0;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(155);
				match(T__24);
				setState(156);
				parts(path, pointer, struct);

				        for (Map.Entry<String, Integer> entry : required_components.get(pointer).entrySet()) {
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
				    
				}
				}
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__24 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartsContext extends ParserRuleContext {
		public String path;
		public int pointer;
		public List<RoseTree> struct;
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public PartsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PartsContext(ParserRuleContext parent, int invokingState, String path, int pointer, List<RoseTree> struct) {
			super(parent, invokingState);
			this.path = path;
			this.pointer = pointer;
			this.struct = struct;
		}
		@Override public int getRuleIndex() { return RULE_parts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterParts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitParts(this);
		}
	}

	public final PartsContext parts(String path,int pointer,List<RoseTree> struct) throws RecognitionException {
		PartsContext _localctx = new PartsContext(_ctx, getState(), path, pointer, struct);
		enterRule(_localctx, 24, RULE_parts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__2);
			setState(164);
			block(path, pointer, struct);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(165);
				match(T__3);
				setState(166);
				block(path, pointer, struct);
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public String path;
		public int pointer;
		public List<RoseTree> struct;
		public Token c;
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public TerminalNode WORD() { return getToken(MetaGrammarParser.WORD, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BlockContext(ParserRuleContext parent, int invokingState, String path, int pointer, List<RoseTree> struct) {
			super(parent, invokingState);
			this.path = path;
			this.pointer = pointer;
			this.struct = struct;
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block(String path,int pointer,List<RoseTree> struct) throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState(), path, pointer, struct);
		enterRule(_localctx, 26, RULE_block);

			RoseTree child;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			((BlockContext)_localctx).c = match(WORD);

					child = Utils.containsValue(_localctx.struct, (((BlockContext)_localctx).c!=null?((BlockContext)_localctx).c.getText():null), true);

					if (child == null) {
						String err = String
							.format(
			                    "- The component '%s' is not allowed within the STRUCTURE rules.\n",
								(((BlockContext)_localctx).c!=null?((BlockContext)_localctx).c.getText():null)
							);
						
						Utils.print_msg(0, "INPUT", err);
					} else {
						// If the element is mandatory \
						// then remove the first occurence of the component in the global list.
						if (child.getRequiredState()) {
			                required_components.get(pointer).computeIfPresent((((BlockContext)_localctx).c!=null?((BlockContext)_localctx).c.getText():null), (k, v) -> v - 1);
						}

						path += ((((BlockContext)_localctx).c!=null?((BlockContext)_localctx).c.getText():null) + "__");
					}
				
			setState(176);
			content((((BlockContext)_localctx).c!=null?((BlockContext)_localctx).c.getText():null), path, pointer, child);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContentContext extends ParserRuleContext {
		public String parent_comp;
		public String path;
		public int pointer;
		public RoseTree node;
		public SliceContext s;
		public AttrsContext attrs() {
			return getRuleContext(AttrsContext.class,0);
		}
		public PartsContext parts() {
			return getRuleContext(PartsContext.class,0);
		}
		public SliceContext slice() {
			return getRuleContext(SliceContext.class,0);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ContentContext(ParserRuleContext parent, int invokingState, String parent_comp, String path, int pointer, RoseTree node) {
			super(parent, invokingState);
			this.parent_comp = parent_comp;
			this.path = path;
			this.pointer = pointer;
			this.node = node;
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitContent(this);
		}
	}

	public final ContentContext content(String parent_comp,String path,int pointer,RoseTree node) throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState(), parent_comp, path, pointer, node);
		enterRule(_localctx, 28, RULE_content);

			boolean hasAttrs = false;
			boolean hasSubparts = false;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(178);
				((ContentContext)_localctx).s = slice();
				}
			}

			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(181);
				attrs(parent_comp, path, node);
				 hasAttrs = true; 
				}
			}

			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(186);
				parts(path, pointer, node.getChildren());
				 hasSubparts = true; 
				}
			}


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
						node.getLexicalPart().add(((ContentContext)_localctx).s.str);

						// Reset string path.
						path = "";
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SliceContext extends ParserRuleContext {
		public String str;
		public Token w1;
		public Token w2;
		public List<TerminalNode> WORD() { return getTokens(MetaGrammarParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MetaGrammarParser.WORD, i);
		}
		public SliceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterSlice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitSlice(this);
		}
	}

	public final SliceContext slice() throws RecognitionException {
		SliceContext _localctx = new SliceContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_slice);

			((SliceContext)_localctx).str =  ""; 

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(T__14);
			setState(194);
			match(T__20);
			setState(195);
			((SliceContext)_localctx).w1 = match(WORD);
			 _localctx.str += (((SliceContext)_localctx).w1!=null?((SliceContext)_localctx).w1.getText():null); 
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD) {
				{
				{
				setState(197);
				((SliceContext)_localctx).w2 = match(WORD);
				 _localctx.str += (" " + (((SliceContext)_localctx).w2!=null?((SliceContext)_localctx).w2.getText():null)); 
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
			match(T__20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttrsContext extends ParserRuleContext {
		public String parent_comp;
		public String path;
		public RoseTree node;
		public EvaluationsContext e;
		public EvaluationsContext evaluations() {
			return getRuleContext(EvaluationsContext.class,0);
		}
		public AttrsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AttrsContext(ParserRuleContext parent, int invokingState, String parent_comp, String path, RoseTree node) {
			super(parent, invokingState);
			this.parent_comp = parent_comp;
			this.path = path;
			this.node = node;
		}
		@Override public int getRuleIndex() { return RULE_attrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterAttrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitAttrs(this);
		}
	}

	public final AttrsContext attrs(String parent_comp,String path,RoseTree node) throws RecognitionException {
		AttrsContext _localctx = new AttrsContext(_ctx, getState(), parent_comp, path, node);
		enterRule(_localctx, 32, RULE_attrs);

			boolean hasEval = false;

			String value = _localctx.node.getValue();
			Map<String, String> attributes = _localctx.node.getAttributes();

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__10);
			setState(207);
			((AttrsContext)_localctx).e = evaluations(path, node);
			setState(208);
			match(T__11);

					for (String attr : attributes.keySet()) {
						if (((AttrsContext)_localctx).e.attr_value.containsKey(attr)) {
							String val = ((AttrsContext)_localctx).e.attr_value.get(attr);

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
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EvaluationsContext extends ParserRuleContext {
		public String path;
		public RoseTree node;
		public Map<String, String> attr_value;
		public EvalContext e1;
		public EvalContext e2;
		public List<EvalContext> eval() {
			return getRuleContexts(EvalContext.class);
		}
		public EvalContext eval(int i) {
			return getRuleContext(EvalContext.class,i);
		}
		public EvaluationsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EvaluationsContext(ParserRuleContext parent, int invokingState, String path, RoseTree node) {
			super(parent, invokingState);
			this.path = path;
			this.node = node;
		}
		@Override public int getRuleIndex() { return RULE_evaluations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterEvaluations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitEvaluations(this);
		}
	}

	public final EvaluationsContext evaluations(String path,RoseTree node) throws RecognitionException {
		EvaluationsContext _localctx = new EvaluationsContext(_ctx, getState(), path, node);
		enterRule(_localctx, 34, RULE_evaluations);

			String value = _localctx.node.getValue();
			Map<String, String> attributes = _localctx.node.getAttributes();

			((EvaluationsContext)_localctx).attr_value =  new HashMap<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			((EvaluationsContext)_localctx).e1 = eval();

					if ( !attributes.containsKey(((EvaluationsContext)_localctx).e1.attribute) ) {
						String err = String
							.format(
			                    "- The attribute '%s' related to the component '%s' is not valid.\n",
								((EvaluationsContext)_localctx).e1.attribute,
								value
							);
						
						Utils.print_msg(0, "INPUT", err);
					}

					if ( _localctx.attr_value.containsKey(((EvaluationsContext)_localctx).e1.attribute) ) {
						String warn = String
							.format(
			                    "- The attribute '%s' has already been declared! Using the last value found.\n",
								((EvaluationsContext)_localctx).e1.attribute
							);
						
						Utils.print_msg(1, "INPUT", warn);
					}
					
					_localctx.attr_value.put(((EvaluationsContext)_localctx).e1.attribute, ((EvaluationsContext)_localctx).e1.value);
				
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(213);
				match(T__3);
				setState(214);
				((EvaluationsContext)_localctx).e2 = eval();

						if ( !attributes.containsKey(((EvaluationsContext)_localctx).e2.attribute) ) {
							String err = String
								.format(
				                    "- The attribute '%s' related to the component '%s' is not valid.\n",
									((EvaluationsContext)_localctx).e2.attribute,
									value
								);
							
							Utils.print_msg(0, "INPUT", err);
						}

						if ( _localctx.attr_value.containsKey(((EvaluationsContext)_localctx).e2.attribute) ) {
							String warn = String
								.format(
				                    "- The attribute '%s' has already been declared! Using the last value found.\n",
									((EvaluationsContext)_localctx).e2.attribute
								);
							
							Utils.print_msg(1, "INPUT", warn);
						}
						
						_localctx.attr_value.put(((EvaluationsContext)_localctx).e2.attribute, ((EvaluationsContext)_localctx).e2.value);
					
				}
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EvalContext extends ParserRuleContext {
		public String attribute;
		public String value;
		public Token a;
		public Token v;
		public List<TerminalNode> WORD() { return getTokens(MetaGrammarParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MetaGrammarParser.WORD, i);
		}
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitEval(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_eval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			((EvalContext)_localctx).a = match(WORD);
			 ((EvalContext)_localctx).attribute =  (((EvalContext)_localctx).a!=null?((EvalContext)_localctx).a.getText():null); 
			setState(224);
			match(T__18);
			setState(225);
			match(T__20);
			setState(226);
			((EvalContext)_localctx).v = match(WORD);
			 ((EvalContext)_localctx).value =  (((EvalContext)_localctx).v!=null?((EvalContext)_localctx).v.getText():null); 
			setState(228);
			match(T__20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00e9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\6\3\62\n\3\r"+
		"\3\16\3\63\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5>\n\5\3\5\3\5\5\5B\n\5\3"+
		"\5\3\5\3\5\5\5G\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6P\n\6\f\6\16\6S\13"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7\\\n\7\f\7\16\7_\13\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\6\bi\n\b\r\b\16\bj\5\bm\n\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\7\tv\n\t\f\t\16\ty\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\n\u0089\n\n\3\13\3\13\3\13\3\13\3\13\7\13\u0090\n\13"+
		"\f\13\16\13\u0093\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\6\r\u00a2\n\r\r\r\16\r\u00a3\3\16\3\16\3\16\3\16\7\16\u00aa"+
		"\n\16\f\16\16\16\u00ad\13\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\5\20\u00b6"+
		"\n\20\3\20\3\20\3\20\5\20\u00bb\n\20\3\20\3\20\3\20\5\20\u00c0\n\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00ca\n\21\f\21\16\21\u00cd"+
		"\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\7\23\u00dc\n\23\f\23\16\23\u00df\13\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\5"+
		"\3\2\17\20\3\2\23\24\3\2\25\26\2\u00e7\2(\3\2\2\2\4-\3\2\2\2\6\65\3\2"+
		"\2\2\b8\3\2\2\2\nH\3\2\2\2\fV\3\2\2\2\16l\3\2\2\2\20n\3\2\2\2\22\u0088"+
		"\3\2\2\2\24\u008a\3\2\2\2\26\u009a\3\2\2\2\30\u00a1\3\2\2\2\32\u00a5\3"+
		"\2\2\2\34\u00b0\3\2\2\2\36\u00b5\3\2\2\2 \u00c3\3\2\2\2\"\u00d0\3\2\2"+
		"\2$\u00d5\3\2\2\2&\u00e0\3\2\2\2()\5\4\3\2)*\5\16\b\2*+\5\26\f\2+,\b\2"+
		"\1\2,\3\3\2\2\2-\61\7\3\2\2./\5\6\4\2/\60\b\3\1\2\60\62\3\2\2\2\61.\3"+
		"\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\5\3\2\2\2\65\66\7"+
		"\4\2\2\66\67\5\b\5\2\67\7\3\2\2\289\7\5\2\29:\7\34\2\2:=\b\5\1\2;<\7\6"+
		"\2\2<>\5\n\6\2=;\3\2\2\2=>\3\2\2\2>A\3\2\2\2?@\7\6\2\2@B\5\f\7\2A?\3\2"+
		"\2\2AB\3\2\2\2BC\3\2\2\2CF\7\7\2\2DE\7\b\2\2EG\b\5\1\2FD\3\2\2\2FG\3\2"+
		"\2\2G\t\3\2\2\2HI\7\t\2\2IJ\7\n\2\2JK\7\34\2\2KQ\b\6\1\2LM\7\6\2\2MN\7"+
		"\34\2\2NP\b\6\1\2OL\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ"+
		"\3\2\2\2TU\7\13\2\2U\13\3\2\2\2VW\7\f\2\2WX\7\r\2\2X]\5\b\5\2YZ\7\6\2"+
		"\2Z\\\5\b\5\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2"+
		"\2\2`a\7\16\2\2a\r\3\2\2\2bc\t\2\2\2ch\7\21\2\2de\5\20\t\2ef\b\b\1\2f"+
		"g\7\22\2\2gi\3\2\2\2hd\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2"+
		"lb\3\2\2\2lm\3\2\2\2m\17\3\2\2\2no\5\22\n\2ow\b\t\1\2pq\t\3\2\2qr\b\t"+
		"\1\2rs\5\22\n\2st\b\t\1\2tv\3\2\2\2up\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3"+
		"\2\2\2xz\3\2\2\2yw\3\2\2\2z{\b\t\1\2{\21\3\2\2\2|}\5\24\13\2}~\t\4\2\2"+
		"~\177\5\24\13\2\177\u0080\b\n\1\2\u0080\u0089\3\2\2\2\u0081\u0082\5\24"+
		"\13\2\u0082\u0083\t\4\2\2\u0083\u0084\7\27\2\2\u0084\u0085\7\34\2\2\u0085"+
		"\u0086\7\27\2\2\u0086\u0087\b\n\1\2\u0087\u0089\3\2\2\2\u0088|\3\2\2\2"+
		"\u0088\u0081\3\2\2\2\u0089\23\3\2\2\2\u008a\u008b\7\34\2\2\u008b\u0091"+
		"\b\13\1\2\u008c\u008d\7\30\2\2\u008d\u008e\7\34\2\2\u008e\u0090\b\13\1"+
		"\2\u008f\u008c\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7\31\2\2"+
		"\u0095\u0096\7\34\2\2\u0096\u0097\b\13\1\2\u0097\u0098\3\2\2\2\u0098\u0099"+
		"\b\13\1\2\u0099\25\3\2\2\2\u009a\u009b\7\32\2\2\u009b\u009c\5\30\r\2\u009c"+
		"\27\3\2\2\2\u009d\u009e\7\33\2\2\u009e\u009f\5\32\16\2\u009f\u00a0\b\r"+
		"\1\2\u00a0\u00a2\3\2\2\2\u00a1\u009d\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\31\3\2\2\2\u00a5\u00a6\7\5\2"+
		"\2\u00a6\u00ab\5\34\17\2\u00a7\u00a8\7\6\2\2\u00a8\u00aa\5\34\17\2\u00a9"+
		"\u00a7\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7\7\2\2\u00af"+
		"\33\3\2\2\2\u00b0\u00b1\7\34\2\2\u00b1\u00b2\b\17\1\2\u00b2\u00b3\5\36"+
		"\20\2\u00b3\35\3\2\2\2\u00b4\u00b6\5 \21\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\u00ba\3\2\2\2\u00b7\u00b8\5\"\22\2\u00b8\u00b9\b\20\1\2"+
		"\u00b9\u00bb\3\2\2\2\u00ba\u00b7\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bf"+
		"\3\2\2\2\u00bc\u00bd\5\32\16\2\u00bd\u00be\b\20\1\2\u00be\u00c0\3\2\2"+
		"\2\u00bf\u00bc\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2"+
		"\b\20\1\2\u00c2\37\3\2\2\2\u00c3\u00c4\7\21\2\2\u00c4\u00c5\7\27\2\2\u00c5"+
		"\u00c6\7\34\2\2\u00c6\u00cb\b\21\1\2\u00c7\u00c8\7\34\2\2\u00c8\u00ca"+
		"\b\21\1\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2"+
		"\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf"+
		"\7\27\2\2\u00cf!\3\2\2\2\u00d0\u00d1\7\r\2\2\u00d1\u00d2\5$\23\2\u00d2"+
		"\u00d3\7\16\2\2\u00d3\u00d4\b\22\1\2\u00d4#\3\2\2\2\u00d5\u00d6\5&\24"+
		"\2\u00d6\u00dd\b\23\1\2\u00d7\u00d8\7\6\2\2\u00d8\u00d9\5&\24\2\u00d9"+
		"\u00da\b\23\1\2\u00da\u00dc\3\2\2\2\u00db\u00d7\3\2\2\2\u00dc\u00df\3"+
		"\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de%\3\2\2\2\u00df\u00dd"+
		"\3\2\2\2\u00e0\u00e1\7\34\2\2\u00e1\u00e2\b\24\1\2\u00e2\u00e3\7\25\2"+
		"\2\u00e3\u00e4\7\27\2\2\u00e4\u00e5\7\34\2\2\u00e5\u00e6\b\24\1\2\u00e6"+
		"\u00e7\7\27\2\2\u00e7\'\3\2\2\2\24\63=AFQ]jlw\u0088\u0091\u00a3\u00ab"+
		"\u00b5\u00ba\u00bf\u00cb\u00dd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}