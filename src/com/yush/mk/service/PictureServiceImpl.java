package com.yush.mk.service;

import java.io.File;

import org.springframework.stereotype.Service;

import com.yush.mk.entity.MkResult;
@Service
public class PictureServiceImpl implements PictureService{

	@Override
	public MkResult savePic(File beforFile,String name) {
		// TODO Auto-generated method stub
		File newsFile=new File("d://picrepo");
		return null;
	}
	
	
}
