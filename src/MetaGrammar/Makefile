.PHONY: compile jar clean

compile:
	java -jar /usr/local/lib/antlr-4.8-complete.jar antlr4/MetaGrammar.g4
	mkdir target/ && mv antlr4/*.interp antlr4/*.tokens antlr4/*.java target/
	javac java/*.java target/*.java -d target/

jar:
	cd target && jar cmfv ../MANIFEST.MF ../MetaGrammar.jar *.class
	cp MetaGrammar.jar ../cli/lyntax/lib/
	cp MetaGrammar.jar ../gui/lyntax/Release/Lyntax/Resources/lib/

clean:
	rm -f MetaGrammar.jar
	rm -rf target/
