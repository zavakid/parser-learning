package com.zavakid.learn.parser.pascal;

import org.junit.Test;

public class PascalTests {

    @Test
    public void testPascal() {
        String helloPascal = PascalTests.class.getResource("/pascal/hello.pas").getFile()
                .toString();
        doParse("compile", helloPascal);
    }

    @Test
    public void testPascal_2() {
        String file = PascalTests.class.getResource("/pascal/scannertest.txt").getFile().toString();
        doParse("compile", file);
    }

    @Test
    public void testPascal_3() {
        String file = PascalTests.class.getResource("/pascal/newton.pas").getFile().toString();
        doParse("compile", "-x", file);
    }

    private void doParse(String... args) {
        Pascal.main(args);
    }
}
