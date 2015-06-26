package com.caishi.capricorn.common.utils;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic utility
 *
 * @author humphrey.han@9icaishi.net
 * @since 0.0.1
 */
public class CommonUtils {

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

    /**
     * Convert "host1:port1, host2:port2, host3:port3" list to
     * "[host1, port1],[host2, port2],[host3, port3]" list
     * @param hostPortList
     * @return
     */
    public static List<String[]> convert2HostPortPairs(List<String> hostPortList) {
        List<String[]> hostPortPairList = new ArrayList<String[]>();

        for (String hostPort : hostPortList) {
            hostPortPairList.add(new String[] { hostPort.split(":")[0], hostPort.split(":")[1] });
        }

        return hostPortPairList;
    }
}
