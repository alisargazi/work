//编缉新闻功能，删除新闻，设置热点
	function news_option(){
	add_edit_option();
	$("#news_list").on("click",".remove_recommened",function(){ 
		var id=$(this).parent().parent().data("newsid");
		$.ajax({
			url:"http://localhost:8090/jiayu/news/recommendremove.do",
			type:"post",
			data:{"id":id},
         	dataType:"json",
         	success:function(result){
         		alert(result.msg);
         		location.reload([true]);
         	}
		});
	});
	$("#news_list").on("click",".set_recommened",function(){ 
		var id=$(this).parent().parent().data("newsid");
		$.ajax({
			url:"http://localhost:8090/jiayu/news/setrecommend.do",
			type:"post",
			data:{"id":id},
         	dataType:"json",
         	success:function(result){
         		alert(result.msg);
         	}
		});
	});
	$("#news_list").on("click",".delect_news",function(){ 
		var id=$(this).parent().parent().data("newsid");
		$.ajax({
			url:"http://localhost:8090/jiayu/news/delenews.do",
			type:"post",
			data:{"id":id},
         	dataType:"json",
         	success:function(result){
         		alert(result.msg);
         		location.reload([true]);
         	}
		});
	
	});
	
	}
	function add_edit_option(){
		var s_ul="<ul class='editor'>"+
			"<li class='delect_news'>删除新闻</li>"+
			"<li class='set_recommened'>设为推荐</li>"+
			"<li class='remove_recommened'>取消推荐</li>"+
			"</ul>";
			var $ul=$(s_ul);
			$(".the_list").append($ul);
	}