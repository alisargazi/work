package com.yush.mk.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;

import com.yush.mk.dao.PictureDao;
import com.yush.mk.entity.Picture;
import com.yush.mk.util.MkUtil;
@Service
public class PictureServiceImpl implements PictureService{
	@Resource
	private PictureDao pictureDao;
	@Override
	public void savePic(HttpServletRequest req, HttpServletResponse resp) {
		Picture pic=new Picture();
		// TODO Auto-generated method stub
		try {
	   req.setCharacterEncoding("utf-8");  
       resp.setContentType("text/html;charset=utf-8");  
       ServletContext servletContext = req.getSession().getServletContext();
       //为解析类提供配置信息  
       DiskFileItemFactory factory = new DiskFileItemFactory();  
       //创建解析类的实例  
       ServletFileUpload sfu = new ServletFileUpload(factory);  
       //开始解析  
       sfu.setFileSizeMax(1024*1000);  
       //每个表单域中数据会封装到一个对应的FileItem对象上  
        
       List<FileItem> items = sfu.parseRequest(req);  
       //区分表单域  
       for (int i = 0; i < items.size(); i++) {  
               FileItem item = items.get(i);  
               //isFormField为true，表示这不是文件上传表单域  
               if(!item.isFormField()){  
                   ServletContext sctx = servletContext;  
                   //获得存放文件的物理路径  
                   //upload下的某个文件夹   得到当前在线的用户  找到对应的文件夹  
                   String path = sctx.getRealPath("/upload");  
                   //获得文件名  
                   String fileName = item.getName();  
                   System.out.println(fileName);
                   //该方法在某些平台(操作系统),会返回路径+文件名  
                   fileName = fileName.substring(fileName.lastIndexOf("/")+1);  
                   //测试路径
                   String  path1="D:\\picrepo\\";
                   String id=MkUtil.createPicId();
                   pic.setP_id(id);
                   fileName=fileName.replaceAll("\\.[\\s\\S]{0,5}", "");
                   System.out.println("文件名："+fileName);
                   pic.setP_name(fileName);
                   pic.setP_localsite(path1+id+".png");
                   pic.setP_url("../upload/"+id+".png");
                   File file_tomcat = new File(path+"\\"+id+".png"); 
                   File file_local = new File(path1+id+".png");
                   if(!file_tomcat.exists()){ 
	                   	file_tomcat.createNewFile();
	                   	file_local.createNewFile();
	                    item.write(file_tomcat);  
	                    item.write(file_local);
	                    pictureDao.createPicture(pic);
	                       //将上传图片的名字记录到数据库中  
                        System.out.println("图片上传成功");
                   }  
               }  
           }  
       } catch (Exception e) {  
           e.printStackTrace();  
       }  
		
	}
	
}

