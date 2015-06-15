package com.caishi.capricorn.common.kafka.producer;

import com.caishi.capricorn.common.base.FeedMessage;

import java.util.*;

/**
 * Created by user on 15/6/12.
 */
public class QueuedProducerTest {
	/**
	 * comment the annotation in case it is called on maven test
	 *
	 * @Test
	 */
	@org.junit.Test
	public void testSend() {
		Properties props = new Properties();

		QueuedProducer queuedProducer = new QueuedProducer("10.10.1.64:9092", 5, true);

		FeedMessage message = new FeedMessage();
		message.setContent("this is content");
		message.setTitle("this is title");
		message.setCreateTime(System.currentTimeMillis());
		message.setPubtime("2015-06-09 12:43:23");

		HashMap<String, Object> extra = new HashMap<String, Object>();
		extra.put("time", new Date());

		List<String> categories = new ArrayList<String>();
		categories.add("科技");
		categories.add("互联网");
		extra.put("categories", categories);

		HashMap<String, String> cookies = new HashMap<String, String>();
		cookies.put("C1", "V1");
		cookies.put("C2", "V2");
		extra.put("cookies", cookies);

		message.setExtra(extra);

		queuedProducer.sendMessage("test", message);
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
