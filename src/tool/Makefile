.PHONY : default meta compile run

# Variables
RULES = "rules.txt"
INPUT = "input.txt"

META_GRAMMAR = "Meta_Grammar"
META_RULE = "processor"

GEN_GRAMMAR = "Grammar"


default:
	@printf "\n\033[33m*** Usage ***\033[0m\n\n\
	- meta    (compile + run Meta-Grammar & Generate Grammar) \n\
	- compile (compile Grammar) \n\
	- run     (run Grammar) \n\
	- clean   (remove target and generated grammar) \n"

meta:
	@printf "\n\033[32m* Compiling + Running Meta-Grammar & Generating Grammar *\033[0m\n\n"
####	
	@-mkdir -p target/generated-sources-meta
	java -jar ./lib/antlr-4.8-complete.jar -Xexact-output-dir -o target/generated-sources-meta ./src/antlr4/${META_GRAMMAR}.g4
	@-mkdir -p target/classes-meta
	javac src/java/*.java target/generated-sources-meta/*.java -d target/classes-meta
####
	cat input/${RULES} input/${INPUT} > input/meta-lang
	cd target/classes-meta && java org.antlr.v4.gui.TestRig ${META_GRAMMAR} ${META_RULE} ../../input/meta-lang
	@-mv target/classes-meta/phrase.tmp input 2> /dev/null || true
	@-mv target/classes-meta/${GEN_GRAMMAR}.g4 src/antlr4 2> /dev/null || true

compile:
	@printf "\n\033[32m* Compiling Grammar *\033[0m\n\n"
####
	@-mkdir -p target/generated-sources-grammar
	java -jar ./lib/antlr-4.8-complete.jar -Xexact-output-dir -o target/generated-sources-grammar ./src/antlr4/${GEN_GRAMMAR}.g4
	@-mkdir -p target/classes-grammar
	javac target/generated-sources-grammar/*.java -d target/classes-grammar

run:
	@printf "\n\033[32m* Running Grammar *\033[0m\n\n"
####
	cd target/classes-grammar && java org.antlr.v4.gui.TestRig ${GEN_GRAMMAR} main ../../input/phrase.tmp -gui

clean:
	rm -rf target
	@-rm -f input/meta-lang
	rm -f src/antlr4/${GEN_GRAMMAR}.g4
	@-rm -f input/phrase.tmp

