package com.zavakid.learn.parser.frontend.pascal.tokens;

import static com.zavakid.learn.parser.frontend.pascal.PascalTokenType.ERROR;

import com.zavakid.learn.parser.frontend.Source;
import com.zavakid.learn.parser.frontend.pascal.PascalErrorCode;
import com.zavakid.learn.parser.frontend.pascal.PascalToken;

public class PascalErrorToken extends PascalToken {

    /**
     * Constructor.
     * 
     * @param source the source from where to fetch subsequent characters.
     * @param errorCode the error code.
     * @param tokenText the text of the erroneous token.
     * @throws Exception if an error occurred.
     */
    public PascalErrorToken(Source source, PascalErrorCode errorCode, String tokenText)
            throws Exception {
        super(source);

        this.text = tokenText;
        this.type = ERROR;
        this.value = errorCode;
    }

    /**
     * Do nothing. Do not consume any source characters.
     * 
     * @throws Exception if an error occurred.
     */
    protected void extract() throws Exception {
    }

}
