package com.zavakid.learn.parser.backend.compiler;

import static com.zavakid.learn.parser.message.MessageType.COMPILER_SUMMARY;

import com.zavakid.learn.parser.backend.Backend;
import com.zavakid.learn.parser.intermediate.ICode;
import com.zavakid.learn.parser.intermediate.SymTab;
import com.zavakid.learn.parser.message.Message;

public class CodeGenerator extends Backend {

    @Override
    public void process(ICode iCode, SymTab symTab) throws Exception {

        long startTime = System.currentTimeMillis();
        float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
        int instructionCount = 0;

        //TODO

        // Send the compiler summary message.
        sendMessage(new Message(COMPILER_SUMMARY, new Number[] { instructionCount, elapsedTime }));

    }
}
