package com.zavakid.learn.parser.frontend;

import com.zavakid.learn.parser.intermediate.ICode;
import com.zavakid.learn.parser.intermediate.SymTab;

/**
 * A language-independent framework class. This abstract parser class will be
 * implemented by language-specific subclasses.
 */
public abstract class Parser {

    protected static SymTab symTab = null; // generated symbol table

    protected Scanner       scanner;      // scanner used with this parser
    protected ICode         iCode;        // intermediate code generated by this parser

    protected Parser(Scanner scanner) {
        this.scanner = scanner;
        this.iCode = null;
    }

    /**
     * Parse a source program and generate the intermediate code and the
     * symbol table. To be implemented by a language-specific parser
     * subclass.
     * 
     * @throws Exception
     *             if an error occurred.
     */
    public abstract void parse() throws Exception;

    /**
     * Return the number of syntax errors found by the parser.
     * To be implemented by a language-specific parser subclass.
     * 
     * @return the error count.
     */
    public abstract int getErrorCount();

    /**
     * Call the scanner's currentToken() method.
     * 
     * @return the current token.
     */
    public Token currentToken() {
        return scanner.currentToken();
    }

    /**
     * Call the scanner's nextToken() method.
     * 
     * @return the next token.
     * @throws Exception
     *             if an error occurred.
     */
    public Token nextToken() throws Exception {
        return scanner.nextToken();
    }

}
