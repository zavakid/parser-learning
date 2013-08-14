package com.zavakid.learn.parser.frontend.pascal;

import static com.zavakid.learn.parser.frontend.pascal.PascalErrorCode.INVALID_CHARACTER;
import static com.zavakid.learn.parser.frontend.pascal.PascalTokenType.END_OF_FILE;

import com.zavakid.learn.parser.frontend.EofToken;
import com.zavakid.learn.parser.frontend.Scanner;
import com.zavakid.learn.parser.frontend.Source;
import com.zavakid.learn.parser.frontend.Token;
import com.zavakid.learn.parser.frontend.pascal.tokens.PascalErrorToken;
import com.zavakid.learn.parser.frontend.pascal.tokens.PascalNumberToken;
import com.zavakid.learn.parser.frontend.pascal.tokens.PascalSpecialSymbolToken;
import com.zavakid.learn.parser.frontend.pascal.tokens.PascalStringToken;
import com.zavakid.learn.parser.frontend.pascal.tokens.PascalWordToken;

public class PascalScanner extends Scanner {

    public PascalScanner(Source source) {
        super(source);
    }

    /**
     * Extract and return the next Pascal token from the source.
     * 
     * @return the next token.
     * @throws Exception if an error occurred.
     */
    @Override
    protected Token extractToken() throws Exception {
        skipWhiteSpace();

        Token token;
        char currentChar = currentChar();

        // Construct the next token.  The current character determines the
        // token type.
        if (currentChar == Source.EOF) {
            token = new EofToken(source, END_OF_FILE);
        } else if (Character.isLetter(currentChar)) {
            token = new PascalWordToken(source);
        } else if (Character.isDigit(currentChar)) {
            token = new PascalNumberToken(source);
        } else if (currentChar == '\'') {
            token = new PascalStringToken(source);
        } else if (PascalTokenType.SPECIAL_SYMBOLS.containsKey(Character.toString(currentChar))) {
            token = new PascalSpecialSymbolToken(source);
        } else {
            token = new PascalErrorToken(source, INVALID_CHARACTER, Character.toString(currentChar));
            nextChar(); // consume character
        }

        return token;
    }

    /**
     * Skip whitespace characters by consuming them. A comment is whitespace.
     * 
     * @throws Exception if an error occurred.
     */
    private void skipWhiteSpace() throws Exception {
        char currentChar = currentChar();

        while (Character.isWhitespace(currentChar) || (currentChar == '{')) {

            // Start of a comment?
            if (currentChar == '{') {
                do {
                    currentChar = nextChar(); // consume comment characters
                } while ((currentChar != '}') && (currentChar != Source.EOF));

                // Found closing '}'?
                if (currentChar == '}') {
                    currentChar = nextChar(); // consume the '}'
                }
            }

            // Not a comment.
            else {
                currentChar = nextChar(); // consume whitespace character
            }
        }
    }

}
