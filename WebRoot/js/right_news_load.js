//右侧推荐新闻加载
function load_news_right(){
		$.ajax({
			url:"http://localhost:8090/jiayu/news/recommendnews.do",
			type:"post",
			data:{"page":1},
			dataType:"json",
			success:function(result){
			if(result.status){
				var newsList=result.data;
				for(var i=0;i<newsList.length&&i<5;i++){
					var title=newsList[i].n_title;
					var body=newsList[i].n_body;
					var id=newsList[i].n_id;
					var re = /<[^>]*>/g;
          			body=body.replace(re, "");
          			body=body.substr(0,150);
          			var s_li="<li class='recommend_body'>"+
									"<div class='r_news_title'>"+
										"<a href='news-"+id+".do' target='"+id+"_black'>"+title+"</a>"+
									"</div>"+
									"<div class='r_news_body'>"+
										"<a>"+body+"</a>"+
									"</div>"+
							  "</li>";
					var $li=$(s_li);
					$("#news_recommend").append($li);
				}
			}else{
				alert("系统繁忙！");
			}
			
			}
		});
		$.ajax({
			url:"http://localhost:8090/jiayu/news/listnews.do",
			type:"post",
			data:{"page":2},
			dataType:"json",
			success:function(result){
				if(result.status){
					var newsList=result.data;
	          		for(var i=0;i<5;i++){
	          			var title=newsList[i].n_title;
	          			var time=newsList[i].n_createtime;
	          			var id=newsList[i].n_id;
	          			var date = new Date(time);
	          			var day=date.getDate();
	          			var month=date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1;
	          			var div ="<div class='hot_body'>"+
										"<div class='hot_time'>"+
										"<a>"+month+"-"+day+"</a>"+
									"</div>"+
									"<div class='hot_title'>"+
										"<a href='news-"+id+".do' target='"+id+"_black'>"+title+"</a>"+
									"</div>"+
								"</div>";
	          			$("#hot_list").append(div);
	          		}
				}else{
					alert("系统繁忙，请稍后再试！");
					
				}
			}
		});
}