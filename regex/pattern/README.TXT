From https://www.tutorialspoint.com/java/java_regular_expressions.htm

Subexpression   Matches
==================================================
^               Matches the beginning of the line.
$               Matches the end of the line.
.               Matches any single character except newline. Using m option allows it to match the newline as well.
[...]           Matches any single character in brackets.
[^...]          Matches any single character not in brackets.
\A              Beginning of the entire string.
\z              End of the entire string.
\Z              End of the entire string except allowable final line terminator.
re*             Matches 0 or more occurrences of the preceding expression.
re+             Matches 1 or more of the previous thing.
re?             Matches 0 or 1 occurrence of the preceding expression.
re{ n}          Matches exactly n number of occurrences of the preceding expression.
re{ n,}         Matches n or more occurrences of the preceding expression.
re{ n, m}       Matches at least n and at most m occurrences of the preceding expression.
a| b            Matches either a or b.
(re)            Groups regular expressions and remembers the matched text.
(?: re)         Groups regular expressions without remembering the matched text.
(?> re)         Matches the independent pattern without backtracking.
\w              Matches the word characters.
\W              Matches the nonword characters.
\s              Matches the whitespace. Equivalent to [\t\n\r\f].
\S              Matches the nonwhitespace.
\d              Matches the digits. Equivalent to [0-9].
\D              Matches the nondigits.
\A              Matches the beginning of the string.
\Z              Matches the end of the string. If a newline exists, it matches just before newline.
\z              Matches the end of the string.
\G              Matches the point where the last match finished.
\n              Back-reference to capture group number "n".
\b              Matches the word boundaries when outside the brackets. Matches the backspace (0x08) when inside the brackets.
\B              Matches the nonword boundaries.
\n, \t, etc.    Matches newlines, carriage returns, tabs, etc.
\Q              Escape (quote) all characters up to \E.
\E              Ends quoting begun with \Q.

But also:
https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html

POSIX character classes (US-ASCII only)

\p{Lower} 	A lower-case alphabetic character: [a-z]
\p{Upper} 	An upper-case alphabetic character:[A-Z]
\p{ASCII} 	All ASCII:[\x00-\x7F]
\p{Alpha} 	An alphabetic character:[\p{Lower}\p{Upper}]
\p{Digit} 	A decimal digit: [0-9]
\p{Alnum} 	An alphanumeric character:[\p{Alpha}\p{Digit}]
\p{Punct} 	Punctuation: One of !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
\p{Graph} 	A visible character: [\p{Alnum}\p{Punct}]
\p{Print} 	A printable character: [\p{Graph}\x20]
\p{Blank} 	A space or a tab: [ \t]
\p{Cntrl} 	A control character: [\x00-\x1F\x7F]
\p{XDigit} 	A hexadecimal digit: [0-9a-fA-F]
\p{Space} 	A whitespace character: [ \t\n\x0B\f\r]
 
java.lang.Character classes (simple java character type)
\p{javaLowerCase} 	Equivalent to java.lang.Character.isLowerCase()
\p{javaUpperCase} 	Equivalent to java.lang.Character.isUpperCase()
\p{javaWhitespace} 	Equivalent to java.lang.Character.isWhitespace()
\p{javaMirrored} 	Equivalent to java.lang.Character.isMirrored()
 
Classes for Unicode scripts, blocks, categories and binary properties
\p{IsLatin} 	A Latin script character (script)
\p{InGreek} 	A character in the Greek block (block)
\p{Lu} 	An uppercase letter (category)
\p{IsAlphabetic} 	An alphabetic character (binary property)
\p{Sc} 	A currency symbol
\P{InGreek} 	Any character except one in the Greek block (negation)
[\p{L}&&[^\p{Lu}]] 	Any letter except an uppercase letter (subtraction)
 
Greediness:

Greedy quantifiers
X? 	X, once or not at all
X* 	X, zero or more times
X+ 	X, one or more times
X{n} 	X, exactly n times
X{n,} 	X, at least n times
X{n,m} 	X, at least n but not more than m times
 
Reluctant quantifiers
X?? 	X, once or not at all
X*? 	X, zero or more times
X+? 	X, one or more times
X{n}? 	X, exactly n times
X{n,}? 	X, at least n times
X{n,m}? 	X, at least n but not more than m times
 
Possessive quantifiers
X?+ 	X, once or not at all
X*+ 	X, zero or more times
X++ 	X, one or more times
X{n}+ 	X, exactly n times
X{n,}+ 	X, at least n times
X{n,m}+ 	X, at least n but not more than m times
 
Logical operators
XY 	X followed by Y
X|Y 	Either X or Y
(X) 	X, as a capturing group

Special constructs (named-capturing and non-capturing)
(?<name>X) 	X, as a named-capturing group
(?:X) 	X, as a non-capturing group
(?idmsuxU-idmsuxU)  	Nothing, but turns match flags i d m s u x U on - off
(?idmsux-idmsux:X)   	X, as a non-capturing group with the given flags i d m s u x on - off
(?=X) 	X, via zero-width positive lookahead
(?!X) 	X, via zero-width negative lookahead
(?<=X) 	X, via zero-width positive lookbehind
(?<!X) 	X, via zero-width negative lookbehind
(?>X) 	X, as an independent, non-capturing group
