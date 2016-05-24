	//正常新闻列表页面功能
	function page_change_load(){
		//加载指定页面
		load_news_list(1);
		var flag=1; 
		var page=1;
		//获取当前单击页码并加载
		$(".page_number").click(function(){
			
			page=$(this).text().trim();
			if(load_news_list(page)==0){
			flag=0;
				return;
			};
			$("#page_mo li").css("background-image","url()");
			this.style.backgroundImage= "url(img/page_on.png)";
		});
		//加载上一页
		$("#page_up").click(function(){
			if(page!=1){
				if(load_news_list(--page)==0){
					return;
				};
				page_change(page);
			}
		});
		//加载下一页
		$("#page_down").click(function(){
				if(load_news_list(++page)==0){
					return;
				};
				page_change(page);
			
		});
		//单击p-9的页码变换逻缉
		$("#p_9").click(function(){
			page=$(this).text().trim();
			page=parseInt(page);
			if(flag==0){
				return;
			};
			page_change(page);
		});
	}
	//推荐新闻加载
function page_change_recommend(){
		load_recommend_list(1);
		//控制不加载空白页并提示没有内容
		var flag=1; 
		var page=1;
		//获取当前单击页码并加载
		$(".page_number").click(function(){
			page=$(this).text().trim();
			if(load_recommend_list(page)==0){
			flag=0;
				return;
			};
			$("#page_mo li").css("background-image","url()");
			this.style.backgroundImage= "url(img/page_on.png)";
			
		});
		//加载上一页
		$("#page_up").click(function(){
			if(page!=1){
				if(load_recommend_list(--page)==0){
					return;
				};
				page_change(page);
			}
			
		});
		//加载下一页
		$("#page_down").click(function(){
				if(load_recommend_list(++page)==0){
					return;
				};
				page_change(page);
			
		});
		//单击p-9的页码变换逻缉
		$("#p_9").click(function(){
			page=$(this).text().trim();
			page=parseInt(page);
			if(flag==0){
				return;
			};
			page_change(page);
		});
	}
function page_change(page){
				$("#page_mo li").css("background-image","url()");
				$("#p_"+page).css("background-image","url(img/page_on.png)");
				if(page>=4){
				$("#p_1").text(page-3);
				$("#p_2").text(page-2);
				$("#p_3").text(page-1);
				$("#p_4").text(page);
				$("#p_9").text(page+5);
				$("#page_mo li").css("background-image","url()");
				$("#p_4").css("background-image","url(img/page_on.png)");
				}
}