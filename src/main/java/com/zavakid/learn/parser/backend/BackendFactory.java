package com.zavakid.learn.parser.backend;

import com.zavakid.learn.parser.backend.compiler.CodeGenerator;
import com.zavakid.learn.parser.backend.interpreter.Executor;

public class BackendFactory {

    /**
     * Create a compiler or an interpreter back end component.
     * 
     * @param operation either "compile" or "execute"
     * @return a compiler or an interpreter back end component.
     * @throws Exception if an error occurred.
     */
    public static Backend createBackend(String operation) throws Exception {
        if (operation.equalsIgnoreCase("compile")) {
            return new CodeGenerator();
        } else if (operation.equalsIgnoreCase("execute")) {
            return new Executor();
        } else {
            throw new Exception("Backend factory: Invalid operation '" + operation + "'");
        }
    }

}
