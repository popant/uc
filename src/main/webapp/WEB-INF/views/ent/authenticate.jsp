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
    <%--<title>企业认证</title>--%>
    <%--<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">--%>
    <%--<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<form class="form-horizontal" action="${pageContext.request.contextPath}/ent/doauthenticate" method="post" enctype="multipart/form-data">
  <fieldset>
    <div id="legend" class="">
      <legend class="">企业认证</legend>
    </div>


    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" >公司名称：</label>

      <div class="controls">
        <input type="text" name="enterpriseName" placeholder="" class="input-xlarge">

        <p class="help-block"></p>
      </div>
    </div>


    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" for="input01">公司地址：</label>

      <div class="controls">
        <input type="text" name="enterpriseAddress" placeholder="" class="input-xlarge">

        <p class="help-block"></p>
      </div>
    </div>


    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" for="input01">联系人 ：</label>

      <div class="controls">
        <input type="text" name="contactPerson" placeholder="" class="input-xlarge">

        <p class="help-block"></p>
      </div>
    </div>

    <div class="control-group">

      <!-- Text input-->
      <label class="control-label" for="input01">联系方式：</label>

      <div class="controls">
        <input type="text" name="contactInfo" placeholder="" class="input-xlarge">

        <p class="help-block"></p>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label">营业执照：</label>

      <!-- File Upload -->
      <div class="controls">
        <input class="input-file" name="businessLicenceFile" id="fileInput" type="file">
      </div>
    </div>
    <div class="control-group">
      <label class="control-label"></label>

      <!-- Button -->
      <div class="controls">
        <button type="submit" class="btn btn-success">提交认证</button>
      </div>
      <p>${errorMessage}</p>
    </div>


  </fieldset>
</form>
<%--</body>--%>
<%--</html>--%>
<%@ include file="../common/footer.jsp"%>