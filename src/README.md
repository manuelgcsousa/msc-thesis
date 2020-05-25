# msc-thesis

Applying Attribute Grammars to teach Linguistic Rules

<hr/>

## Information

The main purpose of this tool is to generate ANTLR instructions based on a previously created Domain Specific Language. By giving this DSL as input, a *Grammar.g4* is generated, to then be processed and analysed with a graphical tool.

Input files must be inside the **input/** directory. Both files (teacher and student) must have specific names:

- **Teacher**: "rules.txt"

- **Student**: "input.txt"

**These names can be changed within the Makefile (variables)**.

<br/>  

### Folder Structure

- **src/** - contains the source code of the tool.
  
  - **src/antlr4/** - contains the meta-grammar of the DSL.
  
  - **src/java/** - extra java classes used within the meta-grammar file.

- **lib/** - contains the **antlr4 jar** use in this project (version **4.8**).

- **input/** - folder where all input files should be placed.

<hr/>

## Usage

In the Makefile, there are 3 instructions that can be called to use the tool.

```bash
$ make

*** Usage ***

- meta    (compile + run Meta-Grammar & Generate Grammar)
- compile (compile Grammar)
- run     (run Grammar)
- clean   (remove target and generated grammar)
```

- **meta** - it will compile and run the meta-grammar for the teacher + student input, check for any syntax and logic errors, and then generate the ANTLR instructions.

- **compile** - it will compile the previously generated grammar.

- **run** - it will run the generated grammar, and create a visual tree of the syntax using the *TestRig* tool.

- **clean** - cleans previously created target folder and generated grammar.

<hr/>

## Dependencies

* **JDK** (Java Development Kit)

* **ANTLR** (ANother Tool for Language Recognition)


