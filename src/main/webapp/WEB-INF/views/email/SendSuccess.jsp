<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script src="${pageContext.request.contextPath}/jslib/jquery-1.8.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/jslib/knockout-3.2.0.js"></script>
</head>
<body>
<div class="portlet light" >
<!-- BEGIN PAGE HEADER-->
<div class="page-bar">
    <ul class="page-breadcrumb">
        <li><i class="fa fa-home"></i> <a href="index.html">发送成功</a> <i
                class="fa fa-angle-right"></i></li>
        <li><a href="#"></a></li>
    </ul>
</div>
</div>
<!-- END PAGE HEADER-->
激活链接已经发送至您的邮箱，请前往您的邮箱激活绑定。若未收到邮件，点此<a href="${pageContext.request.contextPath}/sendEmail/gotoSendEmailAgain">重新输入邮箱发送</a>。
</body>
</html>
<%@ include file="../common/footer.jsp" %>