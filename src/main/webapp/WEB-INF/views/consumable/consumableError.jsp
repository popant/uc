<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>错误页面</title>
	<%
		String errorMsg = (String)request.getAttribute("error");
	%>
</head>
<body>
		<%
			if(errorMsg != null){
		%>
				<div><font size="5" color="red"><%=errorMsg%></font></div>
		<%
			}
		%>
</body>
</html>