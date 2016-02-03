<%--
  Created by IntelliJ IDEA.
  User: 宁
  Date: 2016/1/19
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@page import="com.channelsoft.usercenter.account.po.status.AuditStatus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="NOT_AUDIT" value="<%=AuditStatus.NOT_AUDIT.getValue()%>" />
<%--<html>--%>
<%--<head>--%>
    <%--<title>企业认证</title>--%>
    <%--<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">--%>
    <%--&lt;%&ndash;<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>&ndash;%&gt;--%>
<%--</head>--%>
<%--<body>--%>
<%@ include file="../common/header.jsp"%>
<form class="form-horizontal" action="${pageContext.request.contextPath}/ent/doauthenticate" method="post" enctype="multipart/form-data">
  <fieldset>
    <div id="legend" class="">
      <legend class="">企业认证</legend>
    </div>


    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" >登陆账号： </label>

      <div class="controls">
        <p class="help-block">${userInfo.userName}</p>
      </div>
    </div>


    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" >注册时间： </label>
      <div class="controls">
        <p class="help-block"><fmt:formatDate value="${enterpriseInfo.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
      </div>
    </div>
    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" >登陆密码 ：</label>

      <div class="controls">

        <p class="help-block">****** <a href="${pageContext.request.contextPath}/alterpass">修改密码</a> </p>
      </div>
    </div>

    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" for="input01">绑定邮箱：</label>

      <div class="controls">
        <p class="help-block">${enterpriseInfo.email}<c:if test="${enterpriseInfo.email == null}"><a href="#">绑定邮箱</a> </c:if> </p>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label">企业认证：</label>

      <div class="controls">
        <c:choose>
          <c:when test="${NOT_AUDIT == enterpriseInfo.auditStatus.value}">
            <a href="${pageContext.request.contextPath}/ent/authenticate" >前往认证</a>
          </c:when>
          <c:otherwise>
            <p>${enterpriseInfo.enterpriseName}</p>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
  </fieldset>
</form>
<%--</body>--%>
<%--</html>--%>
<%@ include file="../common/footer.jsp"%>
