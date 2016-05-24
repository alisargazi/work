package com.yush.mk.controller.news;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class NewsJumpController {
	@RequestMapping("/news-*.do")
public ModelAndView execute(){
	ModelAndView mv=new ModelAndView("thenewspage1.html");
	return mv;
}
}
