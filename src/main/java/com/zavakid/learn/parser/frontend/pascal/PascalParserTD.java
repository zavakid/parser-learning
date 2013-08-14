package com.zavakid.learn.parser.frontend.pascal;

import static com.zavakid.learn.parser.frontend.pascal.PascalErrorCode.IO_ERROR;
import static com.zavakid.learn.parser.frontend.pascal.PascalTokenType.ERROR;
import static com.zavakid.learn.parser.message.MessageType.PARSER_SUMMARY;
import static com.zavakid.learn.parser.message.MessageType.TOKEN;

import com.zavakid.learn.parser.frontend.EofToken;
import com.zavakid.learn.parser.frontend.Parser;
import com.zavakid.learn.parser.frontend.Scanner;
import com.zavakid.learn.parser.frontend.Token;
import com.zavakid.learn.parser.frontend.TokenType;
import com.zavakid.learn.parser.message.Message;

public class PascalParserTD extends Parser {

    protected static PascalErrorHandler errorHandler = new PascalErrorHandler();

    public PascalParserTD(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void parse() throws Exception {
        Token token;
        long startTime = System.currentTimeMillis();

        try {
            while (!((token = nextToken()) instanceof EofToken)) {
                TokenType tokenType = token.getType();
                if (tokenType != ERROR) {
                    // Format each token.
                    sendMessage(new Message(TOKEN, new Object[] { token.getLineNumber(),
                            token.getPosition(), tokenType, token.getText(), token.getValue() }));
                } else {
                    errorHandler.flag(token, (PascalErrorCode) token.getValue(), this);
                }
            }

            // Send the parser summary message.
            float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
            sendMessage(new Message(PARSER_SUMMARY, new Number[] { token.getLineNumber(),
                    getErrorCount(), elapsedTime }));

        } catch (java.io.IOException ex) {
            errorHandler.abortTranslation(IO_ERROR, this);
        }
    }

    @Override
    public int getErrorCount() {
        return errorHandler.getErrorCount();
    }

}
