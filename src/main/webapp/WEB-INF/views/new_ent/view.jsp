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
<%@ include file="../common/header.jsp"%>
<div class="portlet light">
  <div class="page-bar">
    <ul class="page-breadcrumb">
      <li>
        <i class="fa fa-home"></i>
        <a href="${pageContext.request.contextPath}/index">首页</a>
        <i class="fa fa-angle-right"></i>
      </li>
      <li>
        <a href="#">账号管理</a>
        <i class="fa fa-angle-right"></i>
      </li>
      <li>
        <a href="#">查看账号信息</a>
      </li>
    </ul>
  </div>
<div class="row">
  <div class="form-body">
    <div class="form-group form-md-line-input">
      <label class="col-md-2 control-label" >登陆账号：</label>
      <div class="col-md-10">
        <div class="form-control form-control-static">
          ${userInfo.userName}
        </div>
      </div>
    </div>
    <div class="form-group form-md-line-input">
      <label class="col-md-2 control-label" >注册时间：</label>
      <div class="col-md-10">
        <div class="form-control form-control-static">
          <fmt:formatDate value="${enterpriseInfo.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
        </div>
      </div>
    </div>
    <div class="form-group form-md-line-input">
      <label class="col-md-2 control-label" >登陆密码：</label>
      <div class="col-md-10">
        <div class="form-control form-control-static">
          ****** <a href="${pageContext.request.contextPath}/alterpass?currentParentId=1&currentMenuId=13">修改密码</a>
        </div>
      </div>
    </div>
    <div class="form-group form-md-line-input">
      <label class="col-md-2 control-label" >绑定邮箱：</label>
      <div class="col-md-10">
        <div class="form-control form-control-static">
          ${enterpriseInfo.email}<c:if test="${enterpriseInfo.email == null}"><a href="${pageContext.request.contextPath}/sendEmail/gotoSendEmail?currentParentId=1&currentMenuId=14">绑定邮箱</a> </c:if>
        </div>
      </div>
    </div>
    <div class="form-group form-md-line-input">
      <label class="col-md-2 control-label" >企业认证：</label>
      <div class="col-md-10">
        <div class="form-control form-control-static">
          <c:choose>
            <c:when test="${NOT_AUDIT == enterpriseInfo.auditStatus.value}">
              <a href="${pageContext.request.contextPath}/ent/authenticate?currentParentId=1&currentMenuId=3" >前往认证</a>
            </c:when>
            <c:otherwise>
              ${enterpriseInfo.enterpriseName}
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
  </div>
</div>
  </div>
<%--</body>--%>
<%--</html>--%>
<%@ include file="../common/footer.jsp"%>
