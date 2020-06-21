import java.util.Arrays;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.TreeViewer;

public class Grammar
{
    public static void main(String[] args) throws Exception {
        CharStream charStream = CharStreams.fromFileName(args[0]);
        GrammarLexer lexer = new GrammarLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        ParseTree tree = parser.main();

        TreeViewer view = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
        view.open();
    }
}
