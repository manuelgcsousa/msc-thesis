@echo OFF

IF "%1"=="-g" (
	CALL :generate
	goto :eof :: EXIT
)

IF "%1"=="-r" (
	CALL :run
	goto :eof :: EXIT
)


:: FUNCTIONS ::

:default
ECHO Option not available...
goto :eof :: EXIT

:generate
cd Resources

java -jar lib\MetaGrammar.jar target\meta-lang
move Grammar.g4 src\
move phrase.tmp src\

java -jar lib\antlr-4.8-complete.jar src\Grammar.g4
javac -cp lib\antlr-4.8-complete.jar src\*.java -d target\
EXIT /B 0

:run
cd Resources
cd target

java -cp ..\lib\antlr-4.8-complete.jar;. Grammar ..\src\phrase.tmp
EXIT /B 0
