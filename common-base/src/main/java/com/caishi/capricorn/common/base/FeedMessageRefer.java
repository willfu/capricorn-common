package com.caishi.capricorn.common.base;

import java.io.Serializable;

/**
 * Created by apple on 15/8/20.
 * 消息引用数：
 * 1. commends
 * 2.page link count
 */
public class FeedMessageRefer implements Serializable {

	private static final long serialVersionUID = 1683400391195693810L;
	private String id;
	private Integer comments;
	private Integer pageLinkCount;

	public FeedMessageRefer() {
	}

	public FeedMessageRefer(String id, Integer comments, Integer pageLinkCount) {
		this.id = id;
		this.comments = comments;
		this.pageLinkCount = pageLinkCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public Integer getPageLinkCount() {
		return pageLinkCount;
	}

	public void setPageLinkCount(Integer pageLinkCount) {
		this.pageLinkCount = pageLinkCount;
	}
}
