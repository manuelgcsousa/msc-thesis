import java.util.Arrays;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class MetaGrammar
{
    public static void main(String[] args) throws Exception {
        CharStream charStream = CharStreams.fromFileName(args[0]);
        MetaGrammarLexer lexer = new MetaGrammarLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MetaGrammarParser parser = new MetaGrammarParser(tokens);
        ParseTree tree = parser.processor();
    }
}
