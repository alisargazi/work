function js_stytle(){
		//鼠标悬停图片切换
		$("#img_home_1").mousemove(function(){
			this.src="img/hover_01.png";
		});
		$("#img_home_1").mouseout(function(){
			this.src="img/nomal_01.png";
		});
		$("#img_home_3").mousemove(function(){
			this.src="img/hover_03.png";
		});
		$("#img_home_3").mouseout(function(){
			this.src="img/nomal_03.png";
		});
		$("#img_home_4").mousemove(function(){
			this.src="img/hover_04.png";
		});
		$("#img_home_4").mouseout(function(){
			this.src="img/nomal_04.png";
		});
		$("#img_home_5").mousemove(function(){
			this.src="img/hover_05.png";
		});
		$("#img_home_5").mouseout(function(){
			this.src="img/nomal_05.png";
		});
		//鼠标皮悬停样式变换
		$("#news_list").on("mousemove",".view_title a",function(){
			$(this).parent().parent().find(".view_date").css("background","#50c0a7");
		});
		$("#news_list").on("mouseout",".view_title a",function(){
			$(this).parent().parent().find(".view_date").css("background","#aaaaac");
		});
	};