<%--
  Created by IntelliJ IDEA.
  User: 宁
  Date: 2016/1/25
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.5
Version: 3.3.0
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
  <meta charset="utf-8"/>
  <title>用户中心注册</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
  <meta http-equiv="Content-type" content="text/html; charset=utf-8">
  <meta content="" name="description"/>
  <meta content="" name="author"/>
  <!-- BEGIN GLOBAL MANDATORY STYLES -->
  <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
  <!-- END GLOBAL MANDATORY STYLES -->
  <!-- BEGIN PAGE LEVEL STYLES -->
  <link href="${pageContext.request.contextPath}/assets/admin/pages/css/login.css" rel="stylesheet" type="text/css"/>
  <!-- END PAGE LEVEL SCRIPTS -->
  <!-- BEGIN THEME STYLES -->
  <link href="${pageContext.request.contextPath}/assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/assets/admin/layout/css/themes/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
  <link href="${pageContext.request.contextPath}/assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
  <!-- END THEME STYLES -->
  <link rel="shortcut icon" href="favicon.ico"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login">
<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
<div class="menu-toggler sidebar-toggler">
</div>
<!-- END SIDEBAR TOGGLER BUTTON -->
<!-- BEGIN LOGO -->
<div class="logo">
  <a href="${pageContext.request.contextPath}/index">
    <img src="${pageContext.request.contextPath}/images/CCOD_LOGO.png" alt="" style="width:104px;height:34px;"/>
  </a>
</div>
<!-- END LOGO -->
<!-- BEGIN LOGIN -->
<div class="content">
  <!-- BEGIN REGISTRATION FORM -->
  <form class="login-form" action="${pageContext.request.contextPath}/doregister" method="post">
    <h3>Sign Up</h3>
    <p class="hint">
      请输入您的相关注册信息:
    </p>
    <div class="form-group">
      <label class="control-label visible-ie8 visible-ie9">手机号</label>
      <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="手机号" name="userName"/>
    </div>
    <div class="form-group">
      <label class="control-label visible-ie8 visible-ie9">密码</label>
      <input class="form-control placeholder-no-fix" type="password" autocomplete="off" id="register_password" placeholder="密码" name="password"/>
    </div>
    <div class="form-group">
      <label class="control-label visible-ie8 visible-ie9">确认密码</label>
      <input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="确认密码" name="comfirmPassword"/>
    </div>
    <div class="form-group">
      <label class="control-label visible-ie8 visible-ie9">短信验证码</label>
      <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="短信验证码" name="valideCode" value="a1bfc1"/>
    </div>
    <div class="form-group">
      <label class="control-label visible-ie8 visible-ie9">验证码</label>
      <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="验证码" name="j_checkcode"  style="width: 75%;display: inline-block"/>
      <a href="" onClick="document.getElementById('CheckPic').src='${pageContext.request.contextPath}/servlet/captchaCode?a='+Math.random()"><img  id="CheckPic" src="${pageContext.request.contextPath}/servlet/captchaCode" style="display: inline-block"/></a>
    </div>
    <c:if test="${errorMessage != null && !empty errorMessage}">
      <div class="form-group">
        <label class="control-label"><p class="text-danger">${errorMessage}</p></label>
      </div>
    </c:if>
    <div class="form-actions">
      <button type="button" onclick="javascript:history.back();" class="btn btn-default">返回</button>
      <button type="submit" id="register-submit-btn" class="btn btn-success uppercase pull-right">注册</button>
    </div>
  </form>
  <!-- END REGISTRATION FORM -->
</div>
<div class="copyright">
  青牛（北京）技术有限公司© 版权所有 京ICP备10016421号-3
</div>
<!-- END LOGIN -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/assets/global/plugins/respond.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${pageContext.request.contextPath}/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/admin/pages/scripts/login.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
  jQuery(document).ready(function() {
    Metronic.init(); // init metronic core components
    Layout.init(); // init current layout
    Login.init();
    Demo.init();
  });
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
