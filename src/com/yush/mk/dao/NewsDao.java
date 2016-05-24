package com.yush.mk.dao;

import java.util.List;
import java.util.Map;

import com.yush.mk.entity.HomeNews;
import com.yush.mk.entity.News;

public interface NewsDao {
	public News findById(String id);
	public List<Map<String,String>>  findAllNews(Map<String,Integer> pageMap);
	public List<Map<String,String>> findHomeNews();
	public void createNews(News news);
	public void createNewsHome(HomeNews homenews);
	public void deleNewsHome(String n_home);
	public void setRecommend(String n_id);
	public void removeRecommend(String n_id);
	public void deleNews(String n_id);
	public List<Map<String,String>> findRecommedNews(int start);
}
