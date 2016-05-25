package com.yush.mk.controller.news;

import java.security.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yush.mk.entity.MkResult;
import com.yush.mk.service.NewsService;
@Controller
@RequestMapping("/news")
public class NextAndPreNewsController {
	@Resource
	private NewsService service;
	@RequestMapping("/nextandpre.do")
	@ResponseBody
	public MkResult execute(String time,String mark){
		MkResult result;
		if("-1".equals(mark)){
			result=service.findPreNews(time);
		}else if("1".equals(mark)){
			result=service.findNextNews(time);
		}else{
			result=null;
		}
		return result;
		
	}
}
