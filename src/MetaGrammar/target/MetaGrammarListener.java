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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MetaGrammarParser}.
 */
public interface MetaGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#processor}.
	 * @param ctx the parse tree
	 */
	void enterProcessor(MetaGrammarParser.ProcessorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#processor}.
	 * @param ctx the parse tree
	 */
	void exitProcessor(MetaGrammarParser.ProcessorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructure(MetaGrammarParser.StructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructure(MetaGrammarParser.StructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#part}.
	 * @param ctx the parse tree
	 */
	void enterPart(MetaGrammarParser.PartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#part}.
	 * @param ctx the parse tree
	 */
	void exitPart(MetaGrammarParser.PartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(MetaGrammarParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(MetaGrammarParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterAttributes(MetaGrammarParser.AttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitAttributes(MetaGrammarParser.AttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#subparts}.
	 * @param ctx the parse tree
	 */
	void enterSubparts(MetaGrammarParser.SubpartsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#subparts}.
	 * @param ctx the parse tree
	 */
	void exitSubparts(MetaGrammarParser.SubpartsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#errors}.
	 * @param ctx the parse tree
	 */
	void enterErrors(MetaGrammarParser.ErrorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#errors}.
	 * @param ctx the parse tree
	 */
	void exitErrors(MetaGrammarParser.ErrorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MetaGrammarParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MetaGrammarParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MetaGrammarParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MetaGrammarParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MetaGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MetaGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(MetaGrammarParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(MetaGrammarParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(MetaGrammarParser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(MetaGrammarParser.PhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#parts}.
	 * @param ctx the parse tree
	 */
	void enterParts(MetaGrammarParser.PartsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#parts}.
	 * @param ctx the parse tree
	 */
	void exitParts(MetaGrammarParser.PartsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MetaGrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MetaGrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(MetaGrammarParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(MetaGrammarParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#slice}.
	 * @param ctx the parse tree
	 */
	void enterSlice(MetaGrammarParser.SliceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#slice}.
	 * @param ctx the parse tree
	 */
	void exitSlice(MetaGrammarParser.SliceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#attrs}.
	 * @param ctx the parse tree
	 */
	void enterAttrs(MetaGrammarParser.AttrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#attrs}.
	 * @param ctx the parse tree
	 */
	void exitAttrs(MetaGrammarParser.AttrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#evaluations}.
	 * @param ctx the parse tree
	 */
	void enterEvaluations(MetaGrammarParser.EvaluationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#evaluations}.
	 * @param ctx the parse tree
	 */
	void exitEvaluations(MetaGrammarParser.EvaluationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#eval}.
	 * @param ctx the parse tree
	 */
	void enterEval(MetaGrammarParser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#eval}.
	 * @param ctx the parse tree
	 */
	void exitEval(MetaGrammarParser.EvalContext ctx);
}