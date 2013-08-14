package com.zavakid.learn.parser.pascal;

import org.junit.Test;

public class PascalTests {

    @Test
    public void testPascal() {
        String helloPascal = PascalTests.class.getResource("/pascal/hello.pas").getFile()
                .toString();
        String[] args = new String[] { "compile", helloPascal };
        Pascal.main(args);
    }
}
