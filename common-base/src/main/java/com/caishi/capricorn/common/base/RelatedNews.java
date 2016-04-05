package com.caishi.capricorn.common.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 16/4/5.
 */
public class RelatedNews implements Serializable {

	private String newsId;

	private MessageType newsType;

	private Double score;

	private List<Integer> categoryIds;

	public RelatedNews() {
	}

	public RelatedNews(String newsId, MessageType newsType, Double score, List<Integer> categoryIds) {
		this.newsId = newsId;
		this.newsType = newsType;
		this.score = score;
		this.categoryIds = categoryIds;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public MessageType getNewsType() {
		return newsType;
	}

	public void setNewsType(MessageType newsType) {
		this.newsType = newsType;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	@Override
	public String toString() {
		return "RelatedNews{" +
				"newsId='" + newsId + '\'' +
				", newsType=" + newsType +
				", score=" + score +
				", categoryIds=" + categoryIds +
				'}';
	}
}
