# msc-thesis

Applying Attribute Grammars to teach Linguistic Rules

<hr/>

## Information

The main purpose of this tool is to generate ANTLR instructions based on a previously created specification. This specification is written in a Domain Specific Language (Meta-Grammar) that allows the definition of possible sentence structures. When processed, a file called *Grammar.g4* is generated, which corresponds to the ANTLR instructions for the recognition of a sentence. Then, by processing the new generated file and by giving input accordingly, a visual syntax parse tree allows for a better analysis of the input.

<br/>  

### Versions

- **CLI** - command line version of the tool.
    - Allows for a quick and easy usage of the tool (works only on UNIX).
    - Source code of the Meta-Grammar as well as Makefile for recompilation.

- **GUI** - graphical user interface that acts like a wrapper.
    - Composed of two main text areas that correspond to the Rules and Input blocks.
    - Allows for the generation of the specific grammar and analysis of the input.
    - Can be used as an editor for the specification.

<hr/>

## Usage

The CLI version has an included help message to explain which options are available, and how to use them.

```bash
$ tool -h

tool
Linguistic rules for beginners.

USAGE:
    | tool [-h | help]
    | tool [-g | generate] <RULES> <INPUT>
    | tool [-r | run]
    | tool [-c | clean]

OPTIONS:
    -h, help              Help message.
    -c, generate          Generates Grammar sources.
    -r, run               Compiles Grammar sources, running it given the sentence as input.
    -c, clean             Cleans files.

ARGS:
    <RULES>               Sentence rules (STRUCTURE + ERRORS blocks).
    <INPUT>               Parsed input (INPUT block).
```

As for the GUI version (compiled as a JAR file), the interaction is pretty straight forward.

<hr/>

## Dependencies

* **JDK** (Java Development Kit)

* **ANTLR** (ANother Tool for Language Recognition)

