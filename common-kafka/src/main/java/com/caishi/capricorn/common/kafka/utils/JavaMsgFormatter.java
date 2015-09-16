package com.caishi.capricorn.common.kafka.utils;

import com.alibaba.fastjson.JSON;
import kafka.tools.MessageFormatter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.Properties;

/**
 * Created by apple on 15/9/16.
 */
public class JavaMsgFormatter implements MessageFormatter {
	@Override
	public void writeTo(byte[] bytes, byte[] bytes1, PrintStream printStream) {
		if (bytes1 != null) {
			try {
				ObjectInputStream oin = new ObjectInputStream(new ByteArrayInputStream(bytes1));
				Object object = oin.readObject();
				printStream.write(JSON.toJSONBytes(object));
				printStream.write("\n".getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void init(Properties properties) {

	}

	@Override
	public void close() {

	}
}
