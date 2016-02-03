<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<!DOCTYPE HTML>
<html>
  <head>
  </head>
  
  <body>
  <h2>notmyjsp</h2>
  1. Hello, <shiro:principal/>, how are you today?  

  <ul>
			<li>
				<h2>
					<a target="_self" href="${pageContext.request.contextPath}/user/myjsp">myjsp</a>
				</h2>
			</li>
			<li>
				<h2>
					<a target="_self" href="${pageContext.request.contextPath}/login">登录</a>
				</h2>
			</li>
			<li>
				<h2>
					<a target="_self" href="${pageContext.request.contextPath}/login/logout">注销</a>
				</h2>
			</li>
		</ul>
  </body>
</html>
