package com.zavakid.learn.parser.intermediate.symtabimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.zavakid.learn.parser.intermediate.SymTab;
import com.zavakid.learn.parser.intermediate.SymTabEntry;
import com.zavakid.learn.parser.intermediate.SymTabKey;

public class SymTabEntryImpl extends HashMap<SymTabKey, Object> implements SymTabEntry {

    private static final long serialVersionUID = -6260184758699863387L;

    // entry name
    private String            name;
    // parent symbol table
    private SymTab            symTab;
    // source line numbers
    private List<Integer>     lineNumbers;

    /**
     * Constructor.
     * 
     * @param name the name of the entry.
     * @param symTab the symbol table that contains this entry.
     */
    public SymTabEntryImpl(String name, SymTab symTab) {
        this.name = name;
        this.symTab = symTab;
        this.lineNumbers = new ArrayList<Integer>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public SymTab getSymTab() {
        return symTab;
    }

    @Override
    public void appendLineNumber(int lineNumber) {
        lineNumbers.add(lineNumber);
    }

    @Override
    public List<Integer> getLineNumbers() {
        return lineNumbers;
    }

    @Override
    public void setAttribute(SymTabKey key, Object value) {
        put(key, value);
    }

    @Override
    public Object getAttribute(SymTabKey key) {
        return get(key);
    }
}
