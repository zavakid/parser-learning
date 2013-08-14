package com.zavakid.learn.parser.backend.interpreter;

import static com.zavakid.learn.parser.message.MessageType.INTERPRETER_SUMMARY;

import com.zavakid.learn.parser.backend.Backend;
import com.zavakid.learn.parser.intermediate.ICode;
import com.zavakid.learn.parser.intermediate.SymTab;
import com.zavakid.learn.parser.message.Message;

public class Executor extends Backend {

    @Override
    public void process(ICode iCode, SymTab symTab) throws Exception {

        long startTime = System.currentTimeMillis();
        float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
        int executionCount = 0;
        int runtimeErrors = 0;

        //TODO 

        // Send the interpreter summary message.
        sendMessage(new Message(INTERPRETER_SUMMARY, new Number[] { executionCount, runtimeErrors,
                elapsedTime }));
    }

}
