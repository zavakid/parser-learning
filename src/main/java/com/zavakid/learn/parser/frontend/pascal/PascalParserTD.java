package com.zavakid.learn.parser.frontend.pascal;

import static com.zavakid.learn.parser.message.MessageType.PARSER_SUMMARY;

import com.zavakid.learn.parser.frontend.EofToken;
import com.zavakid.learn.parser.frontend.Parser;
import com.zavakid.learn.parser.frontend.Scanner;
import com.zavakid.learn.parser.frontend.Token;
import com.zavakid.learn.parser.message.Message;

public class PascalParserTD extends Parser {

    public PascalParserTD(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void parse() throws Exception {
        Token token;
        long startTime = System.currentTimeMillis();

        while (!((token = nextToken()) instanceof EofToken)) {
            //do sth
        }

        // Send the parser summary message.
        float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
        sendMessage(new Message(PARSER_SUMMARY, new Number[] { token.getLineNumber(),
                getErrorCount(), elapsedTime }));

    }

    @Override
    public int getErrorCount() {
        return 0;
    }

}
