/**
 * 
 */

var AjaxUtil = function (url, params, type, dataType){
	if(!url){
		alert("url정보가 없습니다.");
		return null;
	}
	this.url = url;
	this.param = "";
	this.type = type?type:"POST";
	
	if(params){
		var paramArr = params.split(",");

		var data = {};
		for(var i=0,max=paramArr.length;i<max;i++){
			//input, select, textarea
			var objName = paramArr[i];
			var obj = $("[name=" + objName + "]");
			if(obj.length==0){
				alert(objName + "라는 name을 가진 객체가 없습니다.");
				throw "Error : name[" + objName + "] is not found in html!!";
			}
			var objTag = obj.prop("tagName");
			var selector = "";
			if(objTag=="INPUT"){
				selector = "input[name=" + objName +"]";
				if(obj.attr("type")=="radio"){
					selector += ":checked";
				}
			}else if(objTag=="SELECT"){
				selector = "select[name=" + objName +"]";
			}else if(objTag=="TEXTAREA"){
				selector = "textarea[name=" + objName +"]";
			}else{
				alert(objName + "의 엘리먼트가 form태그가 아닙니다.");
				throw "Error : The element tag is not instead in formtags!!";
			}
			data[objName] = $(selector).val();
		}
		console.log(data);
		this.param = JSON.stringify(data);
		if(this.type.toUpperCase()=="GET"){
			this.param = encodeURIComponent(this.param);
		}
	}
	this.dataType = dataType?dataType:"json";
	this.callbackSuccess = function(json){
    	var url = json.url;
    	var data = json.data;
    	var msg = json.msg;
    	if(msg){
    		alert(msg);
    	}
    	if(url){
        	pageMove(url);
    	}
	}
	
	this.setCallbackSuccess = function(callback){
		this.callbackSuccess = callback;
	}
	this.send = function(callback){
		if(callback){
			this.callbackSuccess = callback;
		}
		$.ajax({ 
	        type     : this.type
	    ,   url      : this.url
	    ,   dataType : this.dataType 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : this.param
	    ,   success : this.callbackSuccess
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+xhr.responseText);
		},
		done : function(e) {
		}
		});
 
	}
}


var AjaxUtilForList = function (target, url, params, type, dataType){
	var imgs = {
			1:'/images/portfolio/hansik.jpg',
			2:'/images/portfolio/jungsik.jpg',
			3:'/images/portfolio/ilsik.jpg',
	}
	var au = new AjaxUtil(url, params, type, dataType);
	this.callback = function(res){
		var htmlStr ='';
		for(var key in res){
			var ca = res[key];
			htmlStr +='<div class="col-sm-6 portfolio-item">';
			htmlStr += '<a href="' + pPath + '/reservation/shop" class="portfolio-link">';
			htmlStr += '<div class="caption">';
			htmlStr += '<div class="caption-content">';
			htmlStr += '<h2>' + ca.shopCaNo + '.' + ca.shopCaName + '</h2>';
			htmlStr += '</div>';
			htmlStr += '</div>';
			htmlStr += '<img src="' + rPath + imgs[ca.shopCaNo] + '"class="img-responsive" alt="">';
			htmlStr += '</a>';
			htmlStr += '</div>';
		}
		$(target).html(htmlStr);
		console.log(htmlStr);
	}
	this.send = function(){
		au.send(this.callback);
	}
}



