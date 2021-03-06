grammar S001HelloWord;

options
{
  // antlr will generate java lexer and parser
  language = Java;
  // generated parser should create abstract syntax tree
  output = AST;
}

//as the generated lexer will reside in org.meri.antlr_step_by_step.parsers 
//package, we have to add package declaration on top of it
@lexer::header {
package helloword2.parsers;
}

//as the generated parser will reside in org.meri.antlr_step_by_step.parsers 
//package, we have to add package declaration on top of it
@parser::header {
package helloword2.parsers;

//add imports 
import helloword2.S001HelloWordCompiler.S001HelloWordError;
}

// ***************** lexer rules:
//the grammar must contain at least one lexer rule
SALUTATION:'Hello word';   
ENDSYMBOL:'!';

// ***************** parser rules:
//our grammar accepts only salutation followed by an end symbol
expression : SALUTATION ENDSYMBOL;
catch [RecognitionException e] {
    //Custom handling of an exception. Any java code is allowed.
    throw new S001HelloWordError(":(", e); 
}
