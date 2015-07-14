package com.caishi.capricorn.common.base;


import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.Map;

/**
 * Feed model is initialized from capricorn crawler. Transmitted between several <br>
 * data processing pipelines through (kafka) queue. E.g.<br>
 * Crawler ==> Kafka ==> Classifier ==> Kafka ==> ImageProcessor
 *
 * @author humphrey.han@9icaishi.net
 * @since 0.0.1
 */
public class FeedMessage implements Serializable {

	public static Long serialVersionUID = 1L;

	public static String FEED_TITLE = "title";
	public static String FEED_CONTENT = "content";
	public static String FEED_SUMMARY = "summary";
	public static String FEED_PUBTIME = "pubtime";

	public static String FEED_ORIGIN = "origin";
	public static String FEED_ORIGIN_NAME = "origin_name";
	public static String FEED_ORIGIN_URL = "origin_url";

	public static String FEED_SOURCE_META = "source_meta";
	public static String FEED_SOURCE_META_NAME = "name";
	public static String FEED_SOURCE_META_DIRECTLINKTO = "direct_linkto";
	public static String FEED_SOURCE_META_PRIORITY = "priority";
	public static String FEED_SOURCE_META_CATEGORIES = "categories";
	public static String FEED_SOURCE_META_TAGS = "tags";
	public static String FEED_SOURCE_META_MODE = "mode";
	public static String FEED_SOURCE_META_RESOURCE_FETCHER = "resource_fetcher";

	public static String FEED_SOURCE_LINK = "src_link";

	public static String FEED_MEDIA = "media";
	public static String FEED_MEDIA_IMAGES = "images";
	public static String FEED_MEDIA_VIDEOS = "videos";

	public static String FEED_EXTRA = "extra";
	public static String FEED_EXTRA_COOKIES = "cookies";
	public static String FEED_EXTRA_DEBUG_INFO = "DEBUG_INFO";

	public static String FEED_CREATE_TIME = "createtime";

	private String id;

	private String title;

	private String content;

	private String summary;

	private String pubtime;

	private Map<String, Object> media;

	private String srcLink;

	private Map<String, Object> sourceMeta;

	private Map<String, Object> origin;

	private long createtime;

	private Map<String, Object> extra;

	private ResourceFetcherType fetcherType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ResourceFetcherType getFetcherType() {
		return fetcherType;
	}

	public void setFetcherType(ResourceFetcherType fetcherType) {
		this.fetcherType = fetcherType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPubtime() {
		return pubtime;
	}

	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

	public Map<String, Object> getMedia() {
		return media;
	}

	public void setMedia(Map<String, Object> media) {
		this.media = media;
	}

	public String getSrcLink() {
		return srcLink;
	}

	public void setSrcLink(String srcLink) {
		this.srcLink = srcLink;
	}

	public Map<String, Object> getOrigin() {
		return this.origin;
	}

	public void setOrigin(Map<String, Object> origin) {
		this.origin = origin;
	}

	public Map<String, Object> getSourceMeta() {
		return sourceMeta;
	}

	public void setSourceMeta(Map<String, Object> sourceMeta) {
		this.sourceMeta = sourceMeta;
	}

	public long getCreatetime() {
		return createtime;
	}

	public void setCreatetime(long createtime) {
		this.createtime = createtime;
	}

	public Map<String, Object> getExtra() {
		return extra;
	}

	public void setExtra(Map<String, Object> extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "FeedMessage:\n{\n" +
				"title:" + title + "\n" +
				"content:" + content + "\n" +
				"pubtime:" + pubtime + "\n" +
				"createtime:" + createtime + "\n" +
				"extra:" + JSON.toJSONString(extra) + "\n}\n";
	}
}
