/**
 * (C) Channelsoft.com
 * File		: usercenter.js
 * Desc		: 
 * Date		: 2014年12月25日
 * Author	: mengchen
 */

(function(usercenter) {
	usercenter.utils = {
		$ : function(id) {
			return document.getElementById(id);
		},
		isArray : function(arr) {
			return Object.prototype.toString.call(arr) === "[object Array]";
		}
	};
	
	/**
	 * Generate Navbar
	 */
	usercenter.nav = function(id, data) {
		var navBar = usercenter.utils.$(id);
		
		var navArr = [];
		if (usercenter.utils.isArray(data)) {
			navArr.push("<ul class='page-breadcrumb'>");
			for (var i = 0; i < data.length; i++) {
				var item = data[i];
				var title = item.title;
				var href = item.href;
				if(i==0){
					navArr.push("<li><i class='fa fa-home'></i>");
				}else{
					navArr.push("<li>");
				}
				if (href) {
					navArr.push("<a href='" + href + "'>" + title + "</a>");
				} else {
					navArr.push("<a href='#'>" + title + "</a>");
				}
				navArr.push("<i class='fa fa-angle-right'></i></li>");
			}
			navArr.push("</ul>");
			navBar.innerHTML = navArr.join("");
		}
	};
	usercenter.showCountDown = function(id,data){
		var countDownDialog = usercenter.utils.$(id);
		var countDownArr = [];
		
		var url = data.url;
		var count = data.count;
		var msg = data.msg;
		var success = data.success;
		
		if(!count){
			count = 5;
		}
		countDownArr.push("<div id='"+id+"_result'>"+msg+"</div>");
		if(data.success){
			countDownArr.push("<div id='"+id+"_result_tip'><span id='"+id+"_jump'>"+count+"</span>秒后自动跳转到列表管理，或者<a href='"+url+"'>点击此处</a>直接跳转。</div>");
		}
		var test = usercenter.utils.$(id+"_result");
		countDownDialog.innerHTML = countDownArr.join("");
		if(!test){
			$("#"+id).dialog({
				title:'提示框',
				modal:true,
				width:500,
				height:200,
				closable: true
			});
		}
		$("#"+id).dialog('open');
		if(data.success){
			usercenter.countDown(id, data);
		}
	}
	usercenter.countDown = function(id,data){
		var count = data.count;
		var url = data.url;
		$("#"+id+"_jump").html(data.count);
		data.count = data.count -1;
		 if(data.count>0){
			 setTimeout(function() {
				 usercenter.countDown(id, {
					 count : data.count,
					 url : data.url
				 });
			 }, 1000);
		  }else{
		    	window.location.href = data.url;
		  }	
	}
	
	window.usercenter = usercenter;
	
})(window.usercenter || {});