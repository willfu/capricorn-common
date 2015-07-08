package com.caishi.capricorn.commom.log;

import org.junit.*;
import com.caishi.capricorn.common.log.LogType;
import static org.junit.Assert.*;

public class LogTypeUnitTest {

    @Test
    public void testValueOf(){
        LogType logType = LogType.valueOf("SCENE_OPEN");
        assertTrue(logType==LogType.SCENE_OPEN);
    }
}
