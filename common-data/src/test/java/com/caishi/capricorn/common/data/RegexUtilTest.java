package com.caishi.capricorn.common.data;

import junit.framework.TestCase;

public class RegexUtilTest extends TestCase {
    public void testMakeValidatorForIP(){
        String val = "127.0.0.1";
        boolean status = RegexUtil.makeValidatorForIP(val);
        assertTrue(status);
    }
}
