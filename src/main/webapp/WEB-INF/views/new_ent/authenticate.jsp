<%--
  Created by IntelliJ IDEA.
  User: 宁
  Date: 2016/1/19
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="../common/header.jsp"%>
<script type="text/javascript">
  jQuery(document).ready(function() {
    $('#form_wizard_1').bootstrapWizard({
      onTabClick: function (tab, navigation, index, clickedIndex) {
        return false;
        /*
         success.hide();
         error.hide();
         if (form.valid() == false) {
         return false;
         }
         handleTitle(tab, navigation, clickedIndex);
         */
      },
      onTabShow: function (tab, navigation, index) {
        var total = navigation.find('li').length;
        var num =  ${ent.auditStatus.value};
        if(num == 4 ){
          num = 3;
        }
        var current = num;
        var $percent = (current / total) * 100;
        $('#form_wizard_1').find('.progress-bar').css({
          width: $percent + '%'
        });
      }
    });
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
        //account
        enterpriseName: {
          required: true
        },
        enterpriseAddress: {
          required: true
        },
        contactPerson: {
          required: true
        },
        contactInfo: {
          required: true
        },
        businessLicenceFile: {
          required: true
        }
      },

      messages: { // custom messages for radio buttons and checkboxes
        required:"该选项不能为空！",
        'payment[]': {
          required: "该选项不能为空！",
          minlength: jQuery.validator.format("Please select at least one option")
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
        <a href="#">企业认证</a>
      </li>
    </ul>
  </div>
  <div class="portlet-body form">
    <form id="myform" class="form-horizontal" action="${pageContext.request.contextPath}/ent/doauthenticate" method="post"
          enctype="multipart/form-data" role="form">
      <div class="form-wizard" id="form_wizard_1">
        <div class="form-body">
          <ul class="nav nav-pills nav-justified steps">
            <li <c:if test="${1 == ent.auditStatus.value} "> class="active" </c:if>
              <a href="#tab1" data-toggle="tab" class="step" >
                                                    <span class="number">
                                                    1 </span>
                                                    <span class="desc">
                                                    <i class="fa fa-check"></i>未审核</span>
              </a>
            </li>
            <li <c:if test="${2 == ent.auditStatus.value} "> class="active" </c:if>>
              <a href="#tab2" data-toggle="tab" class="step">
                                                    <span class="number">
                                                    2 </span>
                                                    <span class="desc">
                                                    <i class="fa fa-check"></i>审核中</span>
              </a>
            </li>
            <c:choose>
              <c:when test="${4 == ent.auditStatus.value}">
                <li class="active">
                  <a href="#tab3" data-toggle="tab" class="step">
                                                    <span class="number">
                                                    3 </span>
                                                    <span class="desc">
                                                    <i class="fa fa-check"></i>审核不通过</span>
                  </a>
                </li>
              </c:when>
              <c:otherwise>
                <li <c:if test="${3 == ent.auditStatus.value}"> class="active" </c:if>>
                  <a href="#tab3" data-toggle="tab" class="step active">
                                                    <span class="number">
                                                    3 </span>
                                                    <span class="desc">
                                                    <i class="fa fa-check"></i>审核通过</span>
                  </a>
                </li>
              </c:otherwise>
            </c:choose>
          </ul>
          <div id="bar" class="progress progress-striped" role="progressbar">
            <div class="progress-bar progress-bar-success" >
            </div>
          </div>
          <div class="alert alert-danger display-none">
            <button class="close" data-dismiss="alert"></button>
            对不起，您的表单填写有误，请检查后重新填写。
          </div>
          <div class="alert alert-success display-none">
            <button class="close" data-dismiss="alert"></button>
            Your form validation is successful!
          </div>
          <div class="form-group form-md-line-input">
            <label class="col-md-2 control-label" for="enterpriseName">公司名称：</label>
            <div class="col-md-10">
              <input type="text" class="form-control" name="enterpriseName" id="enterpriseName" value="${ent.enterpriseName}" <c:if test="${2==ent.auditStatus.value&&3==ent.auditStatus.value}">disabled</c:if>>
              <div class="form-control-focus">
              </div>
              <%--<span class="help-block">Some help goes here...</span>--%>
            </div>
          </div>
          <div class="form-group form-md-line-input">
            <label class="col-md-2 control-label" for="enterpriseAddress">公司地址：</label>
            <div class="col-md-10">
              <input type="text" class="form-control" name="enterpriseAddress" id="enterpriseAddress" value="${ent.enterpriseAddress}" <c:if test="${2==ent.auditStatus.value&&3==ent.auditStatus.value}">disabled</c:if>>
              <div class="form-control-focus">
              </div>
              <%--<span class="help-block">Some help goes here...</span>--%>
            </div>
          </div>
          <div class="form-group form-md-line-input">
            <label class="col-md-2 control-label" for="contactPerson">联系人 ：</label>
            <div class="col-md-10">
              <input type="text" class="form-control" name="contactPerson" id="contactPerson" value="${ent.contactPerson}" <c:if test="${2==ent.auditStatus.value&&3==ent.auditStatus.value}">disabled</c:if>>
              <div class="form-control-focus">
              </div>
              <%--<span class="help-block">Some help goes here...</span>--%>
            </div>
          </div>
          <div class="form-group form-md-line-input">
            <label class="col-md-2 control-label" for="contactInfo">联系方式：</label>
            <div class="col-md-10">
              <input type="text" class="form-control" name="contactInfo" id="contactInfo" value="${ent.contactInfo}" <c:if test="${2==ent.auditStatus.value&&3==ent.auditStatus.value}">disabled</c:if>>
              <div class="form-control-focus">
              </div>
              <%--<span class="help-block">Some help goes here...</span>--%>
            </div>
          </div>
          <div class="form-group form-md-line-input">
            <label class="col-md-2 control-label" for="businessLicenceFile">营业执照：</label>
            <div class="col-md-10">
              <div class="form-control-focus">
              </div>
              <div class="fileinput fileinput-new" data-provides="fileinput">
                <div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
                  <c:if test="${ent==null||ent.auditStatus.value==null}">
                    <img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image" alt=""/>
                  </c:if>
                  <c:if test="${ent!=null&&ent.auditStatus.value!=null}">
                    <img src="${pageContext.request.contextPath}/ent/image" alt=""/>
                  </c:if>
                </div>
                <c:if test="${ent==null||ent.auditStatus.value==null||4==ent.auditStatus.value}">
                <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;">
                </div>
                  <div>
                                                        <span class="btn default btn-file">
                                                        <span class="fileinput-new">
                                                        选择图片</span>
                                                        <span class="fileinput-exists">
                                                        重选图片</span>
                                                        <input id="businessLicenceFile" type="file" name="businessLicenceFile">
                                                        </span>
                    <a href="javascript:;" class="btn red fileinput-exists" data-dismiss="fileinput">
                      移除图片 </a>
                  </div>
                  <%--<span class="help-block">Some help goes here...</span>--%>
                </c:if>
              </div>
            </div>
          </div>
          <div id="form_gender_error">
          </div>
          <%--未审核和审核失败可以提交--%>
          <c:if test="${ent==null||ent.auditStatus.value==null||4==ent.auditStatus.value}">
            <div class="form-actions">
              <div class="row">
                <div class="col-md-offset-4">
                  <button type="button" class="btn default col-md-2">取消</button>
                  <button type="button" id="mysubmit" class="btn btn-primary col-md-2 blue">提交</button>
                </div>
              </div>
            </div>
          </c:if>
        </div>
      </div>
    </form>
    <c:if test="${ent!=null&&ent.auditInfo!=null&&ent.auditInfo!='' }">
      <div class="alert alert-danger">
        <span>${invoiceInfo.auditInfo }</span>
      </div>
    </c:if>
  </div>
</div>
<%--</body>--%>
<%--</html>--%>
<%@ include file="../common/footer.jsp"%>