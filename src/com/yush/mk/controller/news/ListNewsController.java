package com.yush.mk.controller.news;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yush.mk.entity.MkResult;
import com.yush.mk.service.NewsService;
import com.yush.mk.service.UserService;
@Controller
@RequestMapping("/news")
public class ListNewsController {
	@Resource
	private NewsService newsService;
	@RequestMapping("/listnews.do")
	@ResponseBody
	public MkResult execute(int page){
		MkResult result = newsService.listNews(page);
		return result;
	}
	@RequestMapping("/listhomenews.do")
	@ResponseBody
	public MkResult execute(){
		MkResult result = newsService.listHomeNews();
		return result;
		
	}
}
