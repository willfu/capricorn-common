package com.caishi.capricorn.common.base;


import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.HashMap;
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

    private String title;

    private String content;

    private String summary;

    private String pubtime;

    private Map<String, Object> media;

    private String sourceLink;

    private Map<String, Object> sourceMeta;

    private long createTime;

    private HashMap<String, Object> extra;

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

    public String getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }

    public Map<String, Object> getSourceMeta() {
        return sourceMeta;
    }

    public void setSourceMeta(Map<String, Object> sourceMeta) {
        this.sourceMeta = sourceMeta;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public HashMap<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(HashMap<String, Object> extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "FeedMessage:\n{\n" +
                "title:" + title + "\n" +
                "content:" + content + "\n" +
                "pubtime:" + pubtime + "\n" +
                "createtime:" + createTime + "\n" +
                "extra:" + JSON.toJSONString(extra) + "\n}\n";
    }
}
