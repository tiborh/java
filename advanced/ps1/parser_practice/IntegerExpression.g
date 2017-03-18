/* Copyright (c) 2015-2017 MIT 6.005 course staff, all rights reserved.
 */

// grammar Expression;

/*
 *
 * You should make sure you have one rule that describes the entire input.
 * This is the "start rule". Below, "root" is the start rule.
 *
 * For more information, see the parsers reading.
 */
// first attempt, left recursion:
root ::= sum;
@skip whitespace{
	sum ::= primitive ('+' primitive)*;
	primitive ::= number | '(' sum ')';
}

// improved version (unfortunately it cannot be applied due to code in buildAST:
// @skip whitespace{
//     root ::= sum;
//     sum ::= (number '+')* number;
// }

number ::= [0-9]+;
whitespace ::= [ ]+;
