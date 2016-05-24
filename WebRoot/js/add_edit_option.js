function add_edit_option(){
var s_ul="<ul class='editor'>"+
	"<li class='delect_news'>删除新闻</li>"+
	"<li class='set_recommened'>设为推荐</li>"+
	"<li class='remove_recommened'>取消推荐</li>"+
	"</ul>";
	var $ul=$(s_ul);
	$(".the_list").append($ul);
	
}