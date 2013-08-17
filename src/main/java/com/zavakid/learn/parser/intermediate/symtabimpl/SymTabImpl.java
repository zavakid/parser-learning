package com.zavakid.learn.parser.intermediate.symtabimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import com.zavakid.learn.parser.intermediate.SymTab;
import com.zavakid.learn.parser.intermediate.SymTabEntry;
import com.zavakid.learn.parser.intermediate.SymTabFactory;

public class SymTabImpl extends TreeMap<String, SymTabEntry> implements SymTab {

    private static final long serialVersionUID = 1350181542733182480L;

    private int               nestingLevel;

    public SymTabImpl(int nestingLevel) {
        this.nestingLevel = nestingLevel;
    }

    @Override
    public int getNestingLevel() {
        return nestingLevel;
    }

    @Override
    public SymTabEntry enter(String name) {
        SymTabEntry entry = SymTabFactory.createSymTabEntry(name, this);
        put(name, entry);

        return entry;
    }

    @Override
    public SymTabEntry lookup(String name) {
        return get(name);
    }

    @Override
    public List<SymTabEntry> sortedEntries() {
        Collection<SymTabEntry> entries = values();
        Iterator<SymTabEntry> iter = entries.iterator();
        ArrayList<SymTabEntry> list = new ArrayList<SymTabEntry>(size());

        // Iterate over the sorted entries and append them to the list.
        while (iter.hasNext()) {
            list.add(iter.next());
        }

        return list; // sorted list of entries
    }

}
