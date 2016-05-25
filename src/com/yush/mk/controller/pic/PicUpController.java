package com.yush.mk.controller.pic;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pic")
public class PicUpController {
	private  HttpServletRequest req;
	private HttpServletResponse resp;
	@RequestMapping("/upload.do")
	@ModelAttribute
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response){
		 try {
			 this.req = request;  
	         this.resp = response; 
		req.setCharacterEncoding("utf-8");  
        resp.setContentType("text/html;charset=utf-8");  
        ServletContext servletContext = request.getSession().getServletContext();
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
                    System.out.println(path);  
                    //获得文件名  
                    String fileName = item.getName();  
                    //该方法在某些平台(操作系统),会返回路径+文件名  
                    fileName = fileName.substring(fileName.lastIndexOf("/")+1);  
                    //测试路径
                    System.out.println(path);
                    String  path1="D:\\picrepo\\";
                    System.out.println("测试："+path1+fileName);
                    File file = new File(path+"\\"+fileName);  
                    System.out.println(file);
                    if(!file.exists()){ 
                    	file.createNewFile();
                        item.write(file);  
                        //将上传图片的名字记录到数据库中  
                          
                    }  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
		 ModelAndView mv=new ModelAndView("/uploadsuccess.html");
			return mv;
    }  
		
	}


