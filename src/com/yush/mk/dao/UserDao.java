package com.yush.mk.dao;

import com.yush.mk.entity.NewsAdmin;

public interface UserDao {
	public NewsAdmin findByName(String name);
}
