package com.zavakid.learn.parser.frontend;

public class EofToken extends Token {

    /**
     * Constructor.
     * 
     * @param source the source from where to fetch subsequent characters.
     * @throws Exception if an error occurred.
     */
    public EofToken(Source source) throws Exception {
        super(source);
    }

    public EofToken(Source source, TokenType type) throws Exception {
        super(source);
        this.type = type;
    }

    /**
     * Do nothing. Do not consume any source characters.
     * 
     * @param source the source from where to fetch the token's characters.
     * @throws Exception if an error occurred.
     */
    protected void extract(Source source) throws Exception {
    }
}
