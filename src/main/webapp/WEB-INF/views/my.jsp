<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<!DOCTYPE HTML>
<html>
  <head>
  </head>
  
  <body>
  Hello, <shiro:principal/>, how are you today?  

  <h2>myjsp</h2>
    <ul>
			<li>
				<h2>
					<a target="_self" href="${pageContext.request.contextPath}/user/notmyjsp">无权访问</a>
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
