package com.yush.mk.controller.news;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yush.mk.entity.MkResult;
import com.yush.mk.service.NewsService;
@Controller
@RequestMapping("/news")
public class ShowNewsRecommend {
	@Resource
	private NewsService service;
	@RequestMapping("/recommendnews.do")
	@ResponseBody
	public MkResult execute(int page){
		MkResult result=service.findRecommedNews(page);
		return result;
	}
}
