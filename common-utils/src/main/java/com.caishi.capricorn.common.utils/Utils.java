package com.caishi.capricorn.common.utils;

import java.lang.management.ManagementFactory;

/**
 * Generic utility
 *
 * @author humphrey.han@9icaishi.net
 * @since 0.0.1
 */
public class Utils {

    /**
     * Get current process PID
     *
     * @return
     */
    public static String getProcessId() {
        String pid="1";
        try {
            pid = ManagementFactory.getRuntimeMXBean().getName();
            String[] aItems = pid.split("@");
            if (aItems!=null && aItems.length>0)
                return aItems[0];
        } catch (Exception e) {}
        return pid;
    }
}
