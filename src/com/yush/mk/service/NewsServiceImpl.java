package com.yush.mk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yush.mk.dao.NewsDao;
import com.yush.mk.entity.HomeNews;
import com.yush.mk.entity.MkResult;
import com.yush.mk.entity.News;
import com.yush.mk.util.MkUtil;
@Service
public class NewsServiceImpl implements NewsService{
	@Resource
	private NewsDao newsDao;
	@Override
	public MkResult showTheNews(String id) {
		// TODO Auto-generated method stub
		News news=new News();
		MkResult result = new MkResult();
		news=newsDao.findById(id);
		if(news==null){
			result.setMsg("系统繁忙！！");
			result.setStatus(0);
			return result;
		}
		result.setData(news);
		result.setMsg("加载成功！");
		result.setStatus(1);
		
		return result;
	}
	@Override
	public MkResult listNews(int page) {
		List<Map<String,String>> newsList ;
		MkResult result = new MkResult();
		Map<String,Integer> pageMap=new HashMap<String,Integer>();
		pageMap.put("start",page*10-10);
		pageMap.put("end",page*10);
		newsList = newsDao.findAllNews(pageMap);
		if(newsList==null){
			result.setMsg("加载失败！");
			result.setStatus(0);
			return result;
		}
		result.setMsg("加载成功");
		result.setStatus(1);
		result.setData(newsList);
		return result;
	}
	public MkResult createNews(String title, String body,String abstr) {
		MkResult result=new MkResult();
		News news = new News();
		HomeNews homenews=new HomeNews();
		
		news.setN_id(MkUtil.createId());
		news.setN_title(title);
		news.setN_body(body);
		news.setN_abstract(abstr);
		news=MkUtil.viewCreate(news);
		homenews.setN_id(news.getN_id());
		homenews.setN_home(news.getN_type());
		newsDao.createNews(news);
		newsDao.createNewsHome(homenews);
		newsDao.deleNewsHome(news.getN_type());
		result.setMsg("新闻添加成功！");
		result.setStatus(1);
		return result;
	}
	public MkResult listHomeNews(){
		List<Map<String,String>> newsList ;
		MkResult result = new MkResult();
		newsList = newsDao.findHomeNews();
		result.setData(newsList);
		result.setMsg("加载成功");
		result.setStatus(1);
		return result;
		
	}
	@Override
	public MkResult removeRecommend(String id) {
		MkResult result = new MkResult();
		newsDao.removeRecommend(id);
		result.setMsg("移除热点成功！");
		result.setStatus(1);
		return result;
	}
	@Override
	public MkResult setRecommend(String id) {
		MkResult result = new MkResult();
		newsDao.setRecommend(id);
		result.setMsg("设置热点成功！");
		result.setStatus(1);
		return result;
	}
	@Override
	public MkResult deleNews(String id) {
		MkResult result = new MkResult();
		newsDao.deleNews(id);
		result.setMsg("新闻删除成功！");
		result.setStatus(1);
		return result;
	}
	@Override
	/**
	 * 推荐新闻列表
	 */
	public MkResult findRecommendNews(int page) {
		List<Map<String,String>> newsList ;
		MkResult result = new MkResult();
		int start =page*10-10;
		newsList=newsDao.findRecommendNews(start);
		result.setMsg("加载成功！");
		result.setData(newsList);
		result.setStatus(1);
		return result;
	}
	@Override
	public MkResult findPreNews(String time) {
		// TODO Auto-generated method stub
		Map<String,String> news ;
		MkResult result = new MkResult();
		news=newsDao.findPreNews(time);
		result.setMsg("加载成功！");
		result.setData(news);
		result.setStatus(1);
		return result;
	}
	@Override
	public MkResult findNextNews(String time) {
		// TODO Auto-generated method stub
		Map<String,String> news ;
		MkResult result = new MkResult();
		news=newsDao.findNextNews(time);
		result.setMsg("加载成功！");
		result.setData(news);
		result.setStatus(1);
		return result;
	}
}
