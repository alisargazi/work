package com.yush.mk.service;

import java.security.Timestamp;

import com.yush.mk.entity.MkResult;

public interface NewsService {
	public MkResult showTheNews(String id);
	public MkResult listNews(int page);
	public MkResult createNews(String title,String body,String abstr);
	public MkResult listHomeNews();
	public MkResult removeRecommend(String id);
	public MkResult setRecommend(String id);
	public MkResult deleNews(String id);
	public MkResult findRecommendNews(int page);
	public MkResult findPreNews(String time);
	public MkResult findNextNews(String time);
}
