<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
function adminHave(){
	var au = new AjaxUtil("${root}/shop/adminHave",null,"GET");
	au.send(callback);  
}
function callback(res){
	console.log(res);
}

</script>

<body onload="adminHave()">
<section class="section">
<h1>사장님이 가지고 있는 shopList</h1>

</section>
</body>
</html>