package com.zavakid.learn.parser.intermediate.symtabimpl;

import java.util.ArrayList;

import com.zavakid.learn.parser.intermediate.SymTab;
import com.zavakid.learn.parser.intermediate.SymTabEntry;
import com.zavakid.learn.parser.intermediate.SymTabFactory;
import com.zavakid.learn.parser.intermediate.SymTabStack;

public class SymTabStackImpl extends ArrayList<SymTab> implements SymTabStack {

    private static final long serialVersionUID = -390626355533708305L;

    // current scope nesting level
    private int               currentNestingLevel;

    /**
     * Constructor.
     */
    public SymTabStackImpl() {
        this.currentNestingLevel = 0;
        add(SymTabFactory.createSymTab(currentNestingLevel));
    }

    @Override
    public int getCurrentNestingLevel() {
        return currentNestingLevel;
    }

    @Override
    public SymTab getLocalSymTab() {
        return get(currentNestingLevel);
    }

    @Override
    public SymTabEntry enterLocal(String name) {
        return get(currentNestingLevel).enter(name);
    }

    @Override
    public SymTabEntry lookupLocal(String name) {
        return get(currentNestingLevel).lookup(name);
    }

    @Override
    public SymTabEntry lookup(String name) {
        return lookupLocal(name);
    }

}
