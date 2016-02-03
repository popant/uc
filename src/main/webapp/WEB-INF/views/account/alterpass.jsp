<%--
  Created by IntelliJ IDEA.
  User: 宁
  Date: 2016/1/19
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="../common/header.jsp"%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>修改密码</title>--%>
    <%--<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">--%>
    <%--<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<form class="form-horizontal" action="${pageContext.request.contextPath}/doalterpass">
  <fieldset>
    <div id="legend" class="">
      <legend class="">修改密码</legend>
    </div>
    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" >原密码：</label>
      <div class="controls">
        <input type="password" name="originPassword" placeholder="" class="input-xlarge">
        <p class="help-block"></p>
      </div>
    </div><div class="control-group">

    <!-- Text input-->
    <label class="control-label" name="password">新密码：</label>
    <div class="controls">
      <input type="password" name="password" placeholder="" class="input-xlarge">
      <p class="help-block"></p>
    </div>
  </div>





    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" name="confirmPassword">确认新密码</label>
      <div class="controls">
        <input type="password" name="confirmPassword" placeholder="" class="input-xlarge">
        <p class="help-block"></p>
      </div>
    </div>



    <div class="control-group">
      <label class="control-label">${errorMessage}</label>

      <!-- Button -->
      <div class="controls">
        <button type="submit" class="btn btn-success">修改密码</button>
      </div>
    </div>

  </fieldset>
</form>
<%--</body>--%>
<%--</html>--%>
<%@ include file="../common/footer.jsp"%>
