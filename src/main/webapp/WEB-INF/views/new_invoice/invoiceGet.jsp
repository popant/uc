<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	var APP = {};
	APP.viewModel = function() {
		var self = this;
		this.canEdit = ko.dependentObservable(function() {
			if ('${canEdit}' == 'true') {
				return true;
			} else {
				return false;
			}
		});

	}

	$(function() {
		APP.vm = new APP.viewModel();
		ko.applyBindings(APP.vm);
	});
</script>
<!-- BEGIN PAGE HEADER-->
<div class="portlet light">
<div class="page-bar" id="centerNav">
<!-- 	<ul class="page-breadcrumb"> -->
<!-- 		<li><i class="fa fa-home"></i> <a href="index.html">发票索取</a> <i -->
<!-- 			class="fa fa-angle-right"></i></li> -->
<!-- 		<li><a href="#"></a></li> -->
<!-- 	</ul> -->
</div>
<!-- END PAGE HEADER-->

<h>${msg }</h>
<h>
<font color="red">${err }</font> <h>
<font color="red">${invoiceInfo==null?"您还没有配置发票信息!":"" }</font></h> <!-- BEGIN PAGE CONTENT-->
<div class="row">
	<div class="col-md-12" id="form_wizard_1">
<!-- 		<div class="portlet box blue" id="form_wizard_1"> -->
<!-- 			<div class="portlet-title"> -->
<!-- 				<div class="caption"> -->
<!-- 					<i class="fa fa-gift"></i> 发票索取 - <span class="step-title"> -->
<!-- 						Step 1 of 2 </span> -->
<!-- 				</div> -->
<!-- 				<div class="tools hidden-xs"> -->
<!-- 					<a href="javascript:;" class="collapse"> </a> -->
<!-- 				</div> -->
<!-- 			</div> -->
			<div class="portlet-body form">
				<form action="saveRecord" class="form-horizontal" id="submit_form"
					method="POST">
					<div class="form-wizard">
						<div class="form-body">
							<ul class="nav nav-pills nav-justified steps">
								<li><a href="#tab1" data-toggle="tab" class="step"> <span
										class="number"> 1 </span> <span class="desc"> <i
											class="fa fa-check"></i> 开票订单、月结算单选择
									</span>
								</a></li>
								<li><a href="#tab2" data-toggle="tab" class="step"> <span
										class="number"> 2 </span> <span class="desc"> <i
											class="fa fa-check"></i> 确定发票信息和地址
									</span>
								</a></li>
							</ul>
							<div id="bar" class="progress progress-striped"
								role="progressbar">
								<div class="progress-bar progress-bar-success"></div>
							</div>
							<div class="tab-content">
								<div class="alert alert-danger display-none">
									<button class="close" data-dismiss="alert"></button>
									您还没有输入金额
								</div>
								<div class="alert alert-success display-none">
									<button class="close" data-dismiss="alert"></button>
									Your form validation is successful!
								</div>
								<div class="tab-pane active" id="tab1">
									<div class="form-group form-md-line-input">
										<label class="col-md-3 control-label" for="form_control_1">待开发票金额</label>
										<div class="col-md-5">
                                           <span class="btn">${maxInvoiceNum }</span>
										</div>
									</div>
									<div class="form-group form-md-line-input">
										<label class="col-md-3 control-label" for="form_control_1">开票金额</label>
										<div class="col-md-5">
											<input type="text" class="form-control" id="invoiceSum"
												placeholder="Enter your name" name="invoiceSum">
											<div class="form-control-focus"></div>
										</div>
									</div>
								</div>
								<div class="tab-pane" id="tab2">
								<div class="form-group form-md-line-input">
										<label for="form_control_1" class="col-md-3 control-label">邮寄地址</label>
										<div class="col-md-5">
											<select id="form_control_1" class="form-control"  name="addressId">
												<c:forEach var="address" items="${addressList }"> 
                                                  <option value=${address.id}>${address.mailAddress}</option>
                                                </c:forEach>
											</select>
											<div class="form-control-focus">
											</div>
										</div>
									</div>
									<div class="form-group form-md-line-input">
										<label class="col-md-3 control-label" for="form_control_1">开具类型</label>
										<div class="col-md-5">
                                           <span class="btn">${invoiceInfo.invoiceKind.desc }</span>
										</div>
									</div>
									<div class="form-group form-md-line-input">
										<label class="col-md-3 control-label" for="form_control_1">发票抬头</label>
										<div class="col-md-5">
                                           <span class="btn">${invoiceInfo.invoiceTitle }</span>
										</div>
									</div>
									<div class="form-group form-md-line-input">
										<label class="col-md-3 control-label" for="form_control_1">发票类型</label>
										<div class="col-md-5">
                                           <span class="btn">${invoiceInfo.invoiceType.desc }</span>
										</div>
									</div>
									<div class="form-group form-md-line-input">
										<label class="col-md-3 control-label" for="form_control_1">税务登记证号</label>
										<div class="col-md-5">
                                           <span class="btn">${invoiceInfo.taxRegistrationNumber }</span>
										</div>
									</div>
									<div class="form-group form-md-line-input">
										<label class="col-md-3 control-label" for="form_control_1">基本开户银行名称</label>
										<div class="col-md-5">
                                           <span class="btn">${invoiceInfo.basicAccountBankName }</span>
										</div>
									</div>
									<div class="form-group form-md-line-input">
										<label class="col-md-3 control-label" for="form_control_1">基本开户账号</label>
										<div class="col-md-5">
                                           <span class="btn">${invoiceInfo.basicAccountNumber }</span>
										</div>
									</div>
									<div class="form-group form-md-line-input">
										<label class="col-md-3 control-label" for="form_control_1">注册场所地址</label>
										<div class="col-md-5">
                                           <span class="btn">${invoiceInfo.registerPlaceAddress }</span>
										</div>
									</div>
									<div class="form-group form-md-line-input">
										<label class="col-md-3 control-label" for="form_control_1">注册固定电话</label>
										<div class="col-md-5">
                                           <span class="btn">${invoiceInfo.registerTel }</span>
										</div>
									</div>
									<div class="form-group form-md-line-input">
										<label class="col-md-3 control-label" for="form_control_1">营业执照复印件</label>
										<div class="col-md-5">
                                           <div class="thumbnail">
                                             <img style="width: 100%; height: 200px; display: block;"  src="${pageContext.request.contextPath}/invoice/preview/b">
                                           </div>
										</div>
									</div>
									<div class="form-group form-md-line-input">
										<label class="col-md-3 control-label" for="form_control_1">税务登记复印件</label>
										<div class="col-md-5">
                                           <div class="thumbnail">
                                             <img style="width: 100%; height: 200px; display: block;"  src="${pageContext.request.contextPath}/invoice/preview/t">
                                           </div>
										</div>
									</div>
									<div class="form-group form-md-line-input">
										<label class="col-md-3 control-label" for="form_control_1">一般纳税人资格认证复印件</label>
										<div class="col-md-5">
                                           <div class="thumbnail">
                                             <img style="width: 100%; height: 200px; display: block;"  src="${pageContext.request.contextPath}/invoice/preview/g">
                                           </div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9">
									<a href="javascript:;" class="btn default button-previous">
										<i class="m-icon-swapleft"></i> Back
									</a> <a href="javascript:;" class="btn blue button-next">
										Continue <i class="m-icon-swapright m-icon-white"></i>
									</a> <a href="javascript:;" class="btn green button-submit">
										Submit <i class="m-icon-swapright m-icon-white"></i>
									</a>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
<!-- 		</div> -->
	</div>
</div>
</div>
<script src="${pageContext.request.contextPath}/jslib/invoiceGet.js" type="text/javascript"></script>
<!-- END PAGE CONTENT--> 
<%@ include file="../common/footer.jsp"%>
<script>
  jQuery(document).ready(function() {
	  usercenter.nav("centerNav", [{
			title : "首页",
			href : '${pageContext.request.contextPath}/index'
		}, {
			title : "发票管理"
		}, {
			title : "发票索取"
		}]);
	  FormWizard.init();
  });
</script>