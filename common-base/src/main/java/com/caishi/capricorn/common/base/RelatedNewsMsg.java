package com.caishi.capricorn.common.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 16/4/5.
 */
public class RelatedNewsMsg implements Serializable {

	private String newsId;

	private List<RelatedNews> relatedNews;

	public RelatedNewsMsg() {
	}

	public RelatedNewsMsg(String newsId, List<RelatedNews> relatedNews) {
		this.newsId = newsId;
		this.relatedNews = relatedNews;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public List<RelatedNews> getRelatedNews() {
		return relatedNews;
	}

	public void setRelatedNews(List<RelatedNews> relatedNews) {
		this.relatedNews = relatedNews;
	}

	@Override
	public String toString() {
		return "RelatedNewsMsg{" +
				"newsId='" + newsId + '\'' +
				", relatedNews=" + relatedNews +
				'}';
	}
}
