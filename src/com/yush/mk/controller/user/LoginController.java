package com.yush.mk.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yush.mk.entity.MkResult;
import com.yush.mk.service.UserService;

@Controller
@RequestMapping("/user")
public class LoginController {
	@Resource
	private UserService userService;// 注入

	@RequestMapping("/login.do")
	@ResponseBody
	// 将NoteResult转成json输出
	public MkResult execute(String name, String pwd) {
		MkResult result = userService.checkName(name, pwd);
		return result;
	}
}
