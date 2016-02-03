<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE HTML >
<html>
	<head>

		<title>My JSP 'main.jsp' starting page</title>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<ul>
			<li>
				<h2>
					<a target="_self" href="${pageContext.request.contextPath}/user/myjsp">myjsp</a>
				</h2>
			</li>
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
