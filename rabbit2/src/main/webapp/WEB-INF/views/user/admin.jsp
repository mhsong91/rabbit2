<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	console.log(res.spList[0].shopName);
}
"<h1>히아요^^</h1>
"
</script>

<body onload="adminHave()">
<section class="section">
<h1>사장님 환영합니다</h1>

</section>
</body>
</html>