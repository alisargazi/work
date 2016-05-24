package com.yush.mk.controller.news;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yush.mk.entity.MkResult;
import com.yush.mk.service.NewsService;
@Controller
@RequestMapping("/news")
public class NewsRecommendSetController {
	@Resource
	private NewsService service;
	@RequestMapping("/setrecommend.do")
	@ResponseBody
	public MkResult execute(String id){
		MkResult result=service.setRecommend(id);
		return result;
	}
}
