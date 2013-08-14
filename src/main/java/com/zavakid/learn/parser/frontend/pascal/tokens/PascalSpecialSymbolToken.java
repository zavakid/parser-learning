package com.zavakid.learn.parser.frontend.pascal.tokens;

import static com.zavakid.learn.parser.frontend.pascal.PascalErrorCode.INVALID_CHARACTER;
import static com.zavakid.learn.parser.frontend.pascal.PascalTokenType.ERROR;
import static com.zavakid.learn.parser.frontend.pascal.PascalTokenType.SPECIAL_SYMBOLS;

import com.zavakid.learn.parser.frontend.Source;
import com.zavakid.learn.parser.frontend.pascal.PascalToken;

public class PascalSpecialSymbolToken extends PascalToken {

    public PascalSpecialSymbolToken(Source source) throws Exception {
        super(source);
    }

    /**
     * Extract a Pascal special symbol token from the source.
     * 
     * @throws Exception if an error occurred.
     */
    protected void extract() throws Exception {
        char currentChar = currentChar();

        text = Character.toString(currentChar);
        type = null;
        switch (currentChar) {

        // Single-character special symbols.
            case '+':
            case '-':
            case '*':
            case '/':
            case ',':
            case ';':
            case '\'':
            case '=':
            case '(':
            case ')':
            case '[':
            case ']':
            case '{':
            case '}':
            case '^': {
                nextChar(); // consume character
                break;
            }

            // : or :=
            case ':': {
                currentChar = nextChar(); // consume ':';

                if (currentChar == '=') {
                    text += currentChar;
                    nextChar(); // consume '='
                }

                break;
            }

            // < or <= or <>
            case '<': {
                currentChar = nextChar(); // consume '<';

                if (currentChar == '=') {
                    text += currentChar;
                    nextChar(); // consume '='
                } else if (currentChar == '>') {
                    text += currentChar;
                    nextChar(); // consume '>'
                }

                break;
            }

            // > or >=
            case '>': {
                currentChar = nextChar(); // consume '>';
                if (currentChar == '=') {
                    text += currentChar;
                    nextChar(); // consume '='
                }

                break;
            }

            // . or ..
            case '.': {
                currentChar = nextChar(); // consume '.';

                if (currentChar == '.') {
                    text += currentChar;
                    nextChar(); // consume '.'
                }

                break;
            }

            default: {
                nextChar(); // consume bad character
                type = ERROR;
                value = INVALID_CHARACTER;
            }
        }

        // Set the type if it wasn't an error.
        if (type == null) {
            type = SPECIAL_SYMBOLS.get(text);
        }
    }

}
