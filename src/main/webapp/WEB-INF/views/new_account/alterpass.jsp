<%--
  Created by IntelliJ IDEA.
  User: 宁
  Date: 2016/1/19
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="../common/header.jsp"%>
<script type="text/javascript" >
  jQuery(document).ready(function() {
    jQuery('#mysubmit').click(function(){
      var form = jQuery('#myform');
      if (form.valid() == false) {
        return false;
      }
      jQuery('#myform').submit();
    });
    var error = $('.alert-danger', jQuery('#myform'));
    var success = $('.alert-success', jQuery('#myform'));
    $('#myform').validate({
      doNotHideMessage: true, //this option enables to show the error/success messages on tab switch.
      errorElement: 'span', //default input error message container
      errorClass: 'help-block help-block-error', // default input error message class
      focusInvalid: true, // do not focus the last invalid input
      rules: {
        originPassword: {
          required: true
        },
        password: {
          required: true
        },
        confirmPassword: {
          required: true,
          equalTo: "#password"
        }
      },
      errorPlacement: function (error, element) { // render error placement for each input type
        if (element.attr("name") == "gender") { // for uniform radio buttons, insert the after the given container
          error.insertAfter("#form_gender_error");
        } else if (element.attr("name") == "payment[]") { // for uniform checkboxes, insert the after the given container
          error.insertAfter("#form_payment_error");
        } else {
          error.insertAfter(element); // for other inputs, just perform default behavior
        }
      },

      invalidHandler: function (event, validator) { //display error alert on form submit
        success.hide();
        error.show();
        Metronic.scrollTo(error, -200);
      },

      highlight: function (element) { // hightlight error inputs
        $(element)
                .closest('.form-group').removeClass('has-success').addClass('has-error'); // set error class to the control group
      },

      unhighlight: function (element) { // revert the change done by hightlight
        $(element)
                .closest('.form-group').removeClass('has-error'); // set error class to the control group
      },

      success: function (label) {
        if (label.attr("for") == "gender" || label.attr("for") == "payment[]") { // for checkboxes and radio buttons, no need to show OK icon
          label
                  .closest('.form-group').removeClass('has-error').addClass('has-success');
          label.remove(); // remove error label here
        } else { // display success icon for other inputs
          label
                  .addClass('valid') // mark the current input as valid and display OK icon
                  .closest('.form-group').removeClass('has-error').addClass('has-success'); // set success class to the control group
        }
      },

      submitHandler: function (form) {
        success.show();
        error.hide();
        //add here some ajax code to submit your form or just call form.submit() if you want to submit the form without ajax
        form.submit();
      }

    });
  });
</script>
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
        <a href="#">修改密码</a>
      </li>
    </ul>
  </div>
  <form id="myform" class="form-horizontal" action="${pageContext.request.contextPath}/ent/doauthenticate" method="post" role="form">
    <div class="form-body">
      <div class="alert alert-danger display-none">
        <button class="close" data-dismiss="alert"></button>
        对不起，您的表单填写有误，请检查后重新填写。
      </div>
      <div class="alert alert-success display-none">
        <button class="close" data-dismiss="alert"></button>
        Your form validation is successful!
      </div>
      <div class="form-group form-md-line-input">
        <label class="col-md-2 control-label" for="originPassword">原密码：</label>
        <div class="col-md-10">
          <input type="password" class="form-control" name="originPassword" id="originPassword">
          <div class="form-control-focus">
          </div>
          <%--<span class="help-block">Some help goes here...</span>--%>
        </div>
      </div>
      <div class="form-group form-md-line-input">
        <label class="col-md-2 control-label" for="password">新密码：</label>
        <div class="col-md-10">
          <input type="password" class="form-control" name="password" id="password">
          <div class="form-control-focus">
          </div>
          <%--<span class="help-block">Some help goes here...</span>--%>
        </div>
      </div>
      <div class="form-group form-md-line-input">
        <label class="col-md-2 control-label" for="confirmPassword">确认新密码：</label>
        <div class="col-md-10">
          <input type="password" class="form-control" name="confirmPassword" id="confirmPassword">
          <div class="form-control-focus">
          </div>
          <%--<span class="help-block">Some help goes here...</span>--%>
        </div>
      </div>
      <div class="form-actions">
        <div class="row">
          <div class="col-md-offset-4">
            <button type="button" id="mysubmit" class="btn btn-primary col-md-2 blue">提交</button>
          </div>
        </div>
      </div>
    </div>
  </form>
</div>
<%@ include file="../common/footer.jsp"%>
