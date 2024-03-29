#!/bin/bash

generate() {
    # Change working directory.
    cd Resources

    java -jar lib/MetaGrammar.jar target/meta-lang
    mv Grammar.g4 phrase.tmp src/ > /dev/null 2>&1

    java -jar lib/antlr-4.8-complete.jar src/Grammar.g4
    javac -cp lib/antlr-4.8-complete.jar src/*.java -d target/
}

run() {
    # Change working directory.
    cd Resources/target

    java -cp ../lib/antlr-4.8-complete.jar:. Grammar ../src/phrase.tmp
}

clean() {
    # Change working directory.
    cd Resources

    (cd src && rm -f Grammar.g4 Grammar.interp Grammar.tokens GrammarBaseListener.java GrammarLexer.interp GrammarLexer.java GrammarLexer.tokens GrammarListener.java GrammarParser.java phrase.tmp)
    (cd target && rm -f *)
}


# Main #
case "$1" in
    -g)
        generate $(echo "$*" | cut -f 2- -d ' ')
        ;;
    -r)
        run
        ;;
    -c)
        clean
        ;;
    *)
        echo "Option not available..."
        ;;
esac
