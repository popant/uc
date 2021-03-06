<%--
  Created by IntelliJ IDEA.
  User: 宁
  Date: 2016/1/19
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.channelsoft.usercenter.account.po.status.AuditStatus" %>
<c:set var="PASS_AUDIT" value="<%=AuditStatus.PASS_AUDIT.getValue()%>" />
<c:set var="FAIL_AUDIT" value="<%=AuditStatus.FAIL_AUDIT.getValue()%>" />
<c:set var="AUDITING" value="<%=AuditStatus.AUDITING.getValue()%>" />
<%@ include file="../common/header.jsp"%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>企业认证</title>--%>
    <%--<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">--%>
    <%--<script type="text/javascript" src="/usercenter/jslib/jquery.js"></script>--%>
    <%--<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<script type="text/javascript">
  jQuery(document).ready(function(){
    $('#businessLicenceFile').change(function(){
      $('#image').hide();
    })
  });
</script>
<form class="form-horizontal" action="${pageContext.request.contextPath}/ent/doauthenticate" method="post" enctype="multipart/form-data">
  <input type="hidden" name="auditStatusInteger" value="${ent.auditStatusInteger}"/>
  <input type="hidden" name="enterpriseId" value="${ent.enterpriseId}"/>
  <fieldset>
    <div id="legend" class="">
      <legend class="">企业认证 <p>当前认证状态：${ent.auditStatus.desc}</p></legend>
    </div>


    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" >公司名称：</label>
      <div class="controls">
        <input type="text" name="enterpriseName" <c:if test="${FAIL_AUDIT != ent.auditStatus.value}"> disabled </c:if> value="${ent.enterpriseName}" placeholder="" class="input-xlarge">

        <p class="help-block"></p>
      </div>
    </div>


    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" for="input01">公司地址：</label>
      <div class="controls">
        <input type="text" name="enterpriseAddress" placeholder="" value="${ent.enterpriseAddress}" <c:if test="${FAIL_AUDIT != ent.auditStatus.value}"> disabled </c:if> class="input-xlarge">
        <p class="help-block"></p>
      </div>
    </div>


    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" for="input01">联系人 ：</label>

      <div class="controls">
        <input type="text" name="contactPerson" value="${ent.contactPerson}" <c:if test="${FAIL_AUDIT != ent.auditStatus.value}"> disabled </c:if> placeholder="" class="input-xlarge">

        <p class="help-block"></p>
      </div>
    </div>

    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" for="input01">联系方式：</label>

      <div class="controls">
        <input type="text" name="contactInfo" value="${ent.contactInfo}" <c:if test="${FAIL_AUDIT != ent.auditStatus.value}"> disabled </c:if> placeholder="" class="input-xlarge">

        <p class="help-block"></p>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label">营业执照：</label>

      <!-- File Upload -->
      <div class="controls">
        <a id="image" href="${pageContext.request.contextPath}/ent/image" >营业执照.jpg</a>
        <%--审核中不允许上传文件--%>
        <c:if test="${AUDITING != ent.auditStatus.value}">
          <input class="input-file" name="businessLicenceFile" id="businessLicenceFile"  type="file">
        </c:if>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label"></label>

      <!-- Button -->
      <div class="controls">
        <%--审核中不允许提交审核--%>
        <c:if test="${AUDITING != ent.auditStatus.value}">
          <button type="submit" class="btn btn-success">提交认证</button>
        </c:if>
      </div>
      <p>${errorMessage}<c:if test="${FAIL_AUDIT == ent.auditStatus.value}">审核评语： ${ent.auditInfo} </c:if></p>
    </div>


  </fieldset>
</form>
<%--</body>--%>
<%--</html>--%>
<%@ include file="../common/footer.jsp"%>
