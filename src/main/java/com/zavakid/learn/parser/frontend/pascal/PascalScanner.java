package com.zavakid.learn.parser.frontend.pascal;

import com.zavakid.learn.parser.frontend.EofToken;
import com.zavakid.learn.parser.frontend.Scanner;
import com.zavakid.learn.parser.frontend.Source;
import com.zavakid.learn.parser.frontend.Token;

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
        Token token;
        char currentChar = currentChar();

        // Construct the next token.  The current character determines the
        // token type.
        if (currentChar == Source.EOF) {
            token = new EofToken(source);
        } else {
            token = new Token(source);
        }

        return token;
    }

}
