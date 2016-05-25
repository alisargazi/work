package com.yush.mk.util;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.yush.mk.entity.News;

public class MkUtil {
	/**
	 * 
	 * ID生成器xxxxx-xxxxx-xxxxx-xxxxx-xxxxx
	 * @return
	 */
	public static String createId() {
		String id=createRandomCharData(5);
		for(int i=0;i++<=4;){
			id+="-"+createRandomCharData(5);
		}
		return id;
	}
	public static String createPicId(){
		String id=createRandomCharData(10);
		return id;
	}
	/**
	 * 随机数生成，生成length位随机数
	 * @param length
	 * @return
	 */
	

	public static String  createRandomCharData(int length) {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();// 随机用以下三个随机生成器
		Random randdata = new Random();
		int data = 0;
		for (int i = 0; i < length; i++) {
			int index = rand.nextInt(3);
			// 目的是随机选择生成数字，大小写字母
			switch (index) {
			case 0:
				data = randdata.nextInt(10);// 仅仅会生成0~9
				sb.append(data);
				break;
			case 1:
				data = randdata.nextInt(26) + 65;// 保证只会产生65~90之间的整数
				sb.append((char) data);
				break;
			case 2:
				data = randdata.nextInt(26) + 97;// 保证只会产生97~122之间的整数
				sb.append((char) data);
				break;
			}
		}
		String result = sb.toString();
		return result;
	}
	
	
	/**
	 * 生成home的view，设置新闻类型
	 * @param news
	 * @return
	 */
	public static News viewCreate(News news){
			String img;
			String title = news.getN_title();
			String body = news.getN_body();
			news.setN_type("1");
			String id=news.getN_id();
			Pattern pattern = Pattern.compile("http[\\s\\S]{1,100}(.jpeg|.jpg|.png|.jif)");
			Matcher matcher = pattern.matcher(body);
			body=body.replaceAll("<[^<]{0,100}>", "");
			if(matcher.find()){
				img=matcher.group();
				body="<img class='news_img' src='"+img+"'><a href='news-"+id+".do' target='"+id+"_black'>"+title+"</a>";
				news.setN_type("2");
				news.setN_img(img);
			}else if(body.length()>=110){
				body=body.substring(0,110);
			}
			System.out.println(body);
			news.setN_view(body);
			return news;
	}
	private static void Date() {
		// TODO Auto-generated method stub
		
	}
//public static void main(String[] args) {
//	Date date=new Date();
//	System.out.println(date);
//	News news=new News();
//	news.setN_body("<p>人工微结构科学与技术协同创新中心管委会第九次会议于5月9日10日在南京大学召开。中心主任邢定钰院士主持会议。</p>"+
//					
//					"<p>会上，人工微结构科学与技术协同创新中心所属科学家共申报了19项科研成果参与述职和评审。专家委员会现场听取了候选项目申请人的报告和答辩。经过专家无记名投票，共选出十项高水平工作作为人工微结构科学与技术协同创新中心2015年度十大科学成果。本次评选更为注重科研工作的质量和原创性，关注该项工作的内在科学意义和对于国际学术界的影响力。</p>"+
//					
//					"<p>此次人工微结构科学与技术协同创新中心年度十大成果评选中，中心成员单位得奖情况如下：南京大学3项，复旦大学1.5项，中国科学技术大学1.5项，浙江大学1项，上海交通大学2项，中科院强磁场中心1项。</p>"+
//					
//					"<p>特别值得一提的是，复旦大学和中国科学技术大学合作的黑磷材料系列工作与南京大学牵头，联合了中科院强磁场中心、复旦大学等中心成员单位的新型量子材料WTe<sub>2</sub>研究系列进展成为通过中心平台深度合作、强强联合取得科研佳绩的经典案例。这两项工作均由中心成员之间超越现有科研单位建制，通过长期紧密协同、有效科研合作完成，且均已在《自然》子刊、《物理评论快报》等国际一流科研期刊上发表多篇系列研究论文并获得国际物理学界的热烈反响。（微结构中心 吴煜昊）</p>");
//	news.setN_title("test");
//	System.out.println(viewCreate(news));
//	
//	
//	//	System.out.println(createId());
////}
//	// 根据指定长度生成纯数字的随机数
////	public static void createData(int length) {
////		StringBuilder sb = new StringBuilder();
////		Random rand = new Random();
////		for (int i = 0; i < length; i++) {
////			sb.append(rand.nextInt(10));
////		}
////		String data = sb.toString();
////		System.out.println(length + " random data: " + data);
//	}
}
