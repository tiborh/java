// $ANTLR 3.5.2 S001HelloWord.g 2017-03-20 00:21:42

package helloword2;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class S001HelloWordLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ENDSYMBOL=4;
	public static final int SALUTATION=5;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public S001HelloWordLexer() {} 
	public S001HelloWordLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public S001HelloWordLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "S001HelloWord.g"; }

	// $ANTLR start "SALUTATION"
	public final void mSALUTATION() throws RecognitionException {
		try {
			int _type = SALUTATION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S001HelloWord.g:28:11: ( 'Hello word' )
			// S001HelloWord.g:28:12: 'Hello word'
			{
			match("Hello word"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SALUTATION"

	// $ANTLR start "ENDSYMBOL"
	public final void mENDSYMBOL() throws RecognitionException {
		try {
			int _type = ENDSYMBOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S001HelloWord.g:29:10: ( '!' )
			// S001HelloWord.g:29:11: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENDSYMBOL"

	@Override
	public void mTokens() throws RecognitionException {
		// S001HelloWord.g:1:8: ( SALUTATION | ENDSYMBOL )
		int alt1=2;
		int LA1_0 = input.LA(1);
		if ( (LA1_0=='H') ) {
			alt1=1;
		}
		else if ( (LA1_0=='!') ) {
			alt1=2;
		}

		else {
			NoViableAltException nvae =
				new NoViableAltException("", 1, 0, input);
			throw nvae;
		}

		switch (alt1) {
			case 1 :
				// S001HelloWord.g:1:10: SALUTATION
				{
				mSALUTATION(); 

				}
				break;
			case 2 :
				// S001HelloWord.g:1:21: ENDSYMBOL
				{
				mENDSYMBOL(); 

				}
				break;

		}
	}



}
