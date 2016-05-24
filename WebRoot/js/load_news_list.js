function load_news_list(page){
	var flag=2;
	$.ajax({
		  url:"http://localhost:8090/jiayu/news/listnews.do",
          type:"post",
          async: false,
          data:{"page":page},
          dataType:"json",
          success:function(result){
        	  if(result.data.length==0){
        		 alert("没有了..");
        		 flag=0;
        		 return flag;
          	}
          	if(result.status){
          		$("#news_list").html("");
          		var newsList=result.data;
          		for(var i=0;i<newsList.length;i++){
          			var title=newsList[i].n_title;
          			var time=newsList[i].n_createtime;
          			var id=newsList[i].n_id;
          			var img=newsList[i].n_img;
          			var body=newsList[i].n_body;
          			var re = /<[^>]*>/g;
          			body=body.replace(re, "");
          			body=body.substr(0,150);
          			var type = newsList[i].n_type;
          			var date = new Date(time);
          			var day=date.getDate();
          			var month=date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1;
          			var s_li="'<li class='the_list' id='news_list_1'>"+
								"<div class='news_view'>"+
									"<div class='view_header'>"+
										"<div class='view_date'>"+
											"<a>"+month+"</br>"+day+"</a>"+
										"</div>"+
										"<div class='view_title'>"+
											"<a href='news-"+id+".do' target='"+id+"_black'>"+title+"</a>"+
										"</div>"+
									"</div>"+
									"<div class='view_content'>"+
										"<a>"+body+"</a>"+
									"</div>"+
								"</div>";
								
					if(type==2){
						s_li+="<div class='news_pic'>"+
								"	<img alt='' src='"+img+"'>"+
								"</div>"+
							"</li>";
					}else if(type==1){
						s_li+="</li>";
					}
          			var $li = $(s_li);
          			$li.data("newsid",id);
					$("#news_list").append($li);
					
          		}
          	}else{
          	alert("系统繁忙");
          	}
          }
         
		});
			return flag;
		}