package com.zavakid.learn.parser.intermediate;

import com.zavakid.learn.parser.intermediate.symtabimpl.SymTabEntryImpl;
import com.zavakid.learn.parser.intermediate.symtabimpl.SymTabImpl;
import com.zavakid.learn.parser.intermediate.symtabimpl.SymTabStackImpl;

public class SymTabFactory {

    /**
     * Create and return a symbol table stack implementation.
     * 
     * @return the symbol table implementation.
     */
    public static SymTabStack createSymTabStack() {
        return new SymTabStackImpl();
    }

    /**
     * Create and return a symbol table implementation.
     * 
     * @param nestingLevel the nesting level.
     * @return the symbol table implementation.
     */
    public static SymTab createSymTab(int nestingLevel) {
        return new SymTabImpl(nestingLevel);
    }

    /**
     * Create and return a symbol table entry implementation.
     * 
     * @param name the identifier name.
     * @param symTab the symbol table that contains this entry.
     * @return the symbol table entry implementation.
     */
    public static SymTabEntry createSymTabEntry(String name, SymTab symTab) {
        return new SymTabEntryImpl(name, symTab);
    }
}
