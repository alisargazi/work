package com.yush.mk.controller.pic;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yush.mk.service.PictureService;

@Controller
@RequestMapping("/pic")
public class PicUpController {
	@Resource
	private PictureService service;
	@RequestMapping("/upload.do")
	@ModelAttribute
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response){
		 service.savePic(request, response);
		 ModelAndView mv=new ModelAndView("/uploadsuccess.html");
			return mv;
    }  
		
	}


