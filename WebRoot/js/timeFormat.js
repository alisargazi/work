function getLocalTime(nS) {     
       return new Date(parseInt(nS)).toLocaleString().replace(/:d{1,2}$/,' ');     
}  
function getLocalTimeStamp(time){
	 	var date=new Date(time);
		var day=date.getDate();
		var month=date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1;
		var year=date.getFullYear();
		var hour = date.getHours();
	    var min = date.getMinutes();
	    var sec = date.getSeconds();
		hour = (hour < 10 ? "0" : "") + hour;
	    min = (min < 10 ? "0" : "") + min;
	    sec = (sec < 10 ? "0" : "") + sec;
	    t1= year + "-" + month + "-" + day + " " +  hour + ":" + min + ":" + sec;
	    return t1;
}
function get_y_m_d(time){
	var date=new Date(time);
	var day=date.getDate();
	var month=date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1;
	var year=date.getFullYear();
	var t1=year+"-"+month+"-"+day;
	return t1
}