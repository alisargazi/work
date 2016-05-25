package com.yush.mk.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yush.mk.dao.UserDao;
import com.yush.mk.entity.MkResult;
import com.yush.mk.entity.NewsAdmin;
@Service
//扫描控制组件
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	public MkResult checkName(String name,String pwd) {
		MkResult result = new MkResult();
		NewsAdmin admin = userDao.findByName(name);
		if(admin==null||pwd==null){
			result.setMsg("用户名或密码错误！");
			result.setStatus(0);
			return result;
		}
		
		if(pwd.equals(admin.getUser_password())){
			result.setMsg("登录成功！");
			result.setStatus(1);
			return result;
		}
		result.setMsg("用户名或密码错误");
		result.setStatus(0);
		return result;
	}

}
