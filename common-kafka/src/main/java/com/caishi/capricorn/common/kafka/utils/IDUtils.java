package com.caishi.capricorn.common.kafka.utils;

import org.apache.commons.lang3.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created by apple on 15/7/9.
 */
public class IDUtils {


	static Random random = new Random();

	public static String hostPortID(InetAddress address) {
		if (address == null) {
			return String.valueOf(random.nextLong());
		}

		String hostName = address.getHostName();
		if (StringUtils.isNotEmpty(hostName) && !StringUtils.startsWithIgnoreCase(hostName, "localhost")) {
			return StringUtils.capitalize(StringUtils.trimToEmpty(hostName));
		}

		//ip
		String ipaddress = address.getHostAddress();
		if (StringUtils.isNotEmpty(ipaddress) && !StringUtils.startsWith(ipaddress, "127.0")) {
			return StringUtils.capitalize(StringUtils.trimToEmpty(ipaddress));
		}


		return random.nextLong() + "";
	}

	public static void main(String[] args) throws UnknownHostException {
		System.out.println(IDUtils.hostPortID(InetAddress.getLocalHost()));
	}
}
