<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page language="java" import="com.channelsoft.usercenter.consumable.po.*,java.util.List;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="../metronicHeader.jsp" />
<title>菜单</title>
<%
	List<Product> products = (List<Product>)request.getAttribute("products");
%>
</head>
<body>
	<% 	
		if(products.size() == 0){
			
	%>
			<div><font size="5" face="黑体">暂未开通任何产品!</font></div>
	<%
		}else{
			for(Product row : products){
		
	%>
			<div align="center"><a class="btn green btn-block" href="<%=request.getContextPath()%>/purchase/getConsumables?productId=<%=row.getProductId()%>" target="rightFrame"><%=row.getProductName()%></a></div>			
	<%
			}
		}
	%>
</body>
</html>