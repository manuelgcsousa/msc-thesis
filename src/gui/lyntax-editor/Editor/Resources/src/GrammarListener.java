// Generated from src/Grammar.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(GrammarParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(GrammarParser.MainContext ctx);
}