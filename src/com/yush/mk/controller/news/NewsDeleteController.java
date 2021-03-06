package com.yush.mk.controller.news;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yush.mk.entity.MkResult;
import com.yush.mk.service.NewsService;
@Controller
@RequestMapping("/news")
public class NewsDeleteController {
	@Resource
	private NewsService service;
	@RequestMapping("/delenews.do")
	@ResponseBody
	public MkResult execute(String id){
		MkResult result=service.deleNews(id);
		return result;
	}
}
