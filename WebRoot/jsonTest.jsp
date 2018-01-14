<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json测试</title>
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
// 请求json,返回json
function requestJson(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath}/requestJson.action',
		contentType:'application/json;charset=utf-8',
		data:'{"name":"手机","price":999}',
		success:function(data){
			alert(data);
		}
	});	
}
//请求key/value,返回json
function responseJson() {
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath}/responseJson.action',
//		contentType:'application/json;charset=utf-8',
		data:'name=手机&price=999',
		success:function(data){
			alert(data);
		}
	});	
}
</script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求json,返回json">
<input type="button" onclick="responseJson()" value="请求key/value,返回json">
</body>
</html>