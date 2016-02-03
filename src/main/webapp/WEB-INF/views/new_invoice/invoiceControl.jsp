<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp"%>
<script type="text/javascript">
	var APP = {};
	APP.viewModel = function() {
		var self = this;
		//个人:0 企业:1
		this.kindRadioType = ko.observable("${invoiceInfo.invoiceKind!=null?invoiceInfo.invoiceKind.value:0}");
		//普通发票:0 专用发票:1
		this.typeRadioType = ko.observable("${invoiceInfo.invoiceType!=null?invoiceInfo.invoiceType.value:0}");
		this.auditProcess = ko.observable(${invoiceInfo.auditStatus!=null?invoiceInfo.auditStatus.value:0});
		this.auditProcessBar = ko.dependentObservable(function(){
			if(self.auditProcess()==0){
				return "25%";
			}else if(self.auditProcess()==1){
				return "50%";
			}else{
				return "100%";
			}
		});
		this.displayEnt = ko.dependentObservable(function() {
			if (self.kindRadioType() == "0") {
				return false;
			} else {
				return true;
			}
		});
		this.displaySpecial = ko.dependentObservable(function() {
			if (self.kindRadioType() == "1" && self.typeRadioType() == "1") {
				return true;
			} else {
				return false;
			}
		});
		this.canEdit = ko.dependentObservable(function() {
			if ('${canEdit}' == 'true') {
				return true;
			} else {
				return false;
			}
		});
		this.canPreview = ko.dependentObservable(function() {
			if ('${invoiceInfo!=null}' == 'true' && !self.canEdit) {
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
<!-- 		<li><i class="fa fa-home"></i> <a href="index.html">发票信息管理</a> <i -->
<!-- 			class="fa fa-angle-right"></i></li> -->
<!-- 		<li><a href="#"></a></li> -->
<!-- 	</ul> -->
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN PROGRESSBAR -->
<div class="form-wizard">
<ul class="nav nav-pills nav-justified steps">
											<li data-bind="css: { active: auditProcess() >= 0 }">
												<a href="#tab1" data-toggle="tab" class="step">
												<span class="number">
												1 </span>
												<span class="desc">
												<i class="fa fa-check"></i> 提交中 </span>
												</a>
											</li>
											<li data-bind="css: { active: auditProcess() >= 1 }">
												<a href="#tab2" data-toggle="tab" class="step">
												<span class="number">
												2 </span>
												<span class="desc">
												<i class="fa fa-check"></i> 审核中 </span>
												</a>
											</li>
											<li data-bind="css: { active: auditProcess()==2 },visible:auditProcess()<=2">
												<a href="#tab3" data-toggle="tab" class="step active">
												<span class="number">
												3 </span>
												<span class="desc">
												<i class="fa fa-check"></i> 审核通过 </span>
												</a>
											</li>
											<li data-bind="css: { active: true },visible:auditProcess()==3">
												<a href="#tab3" data-toggle="tab" class="step active">
												<span class="number">
												3 </span>
												<span class="desc">
												<i class="fa fa-check"></i> 审核失败 </span>
												</a>
											</li>
											
										</ul>
										<div id="bar" class="progress progress-striped" role="progressbar">
											<div class="progress-bar progress-bar-success" data-bind="style: { width: auditProcessBar }">
											</div>
										</div>
</div>
<!-- END PROGRESSBAR -->
<form role="form" class="form-horizontal" action="saveInfo"
	method="post" enctype="multipart/form-data">
	<div class="form-body col-md-offset-2">
		<div class="form-group form-md-radios">
			<label class="col-md-3 control-label" for="form_control_1">开具类型</label>
			<div class="col-md-5">
				<div class="md-radio-inline " id="form_control_1">
					<div class="md-radio">
						<input type="radio" class="md-radiobtn" name="invoiceKind" id="radio6" value="0" data-bind="checked: kindRadioType">
						<label for="radio6"> <span class="inc"></span> <span
							class="check"></span> <span class="box"></span> 个人
						</label>
					</div>
					<div class="md-radio">
						<input type="radio" checked="" class="md-radiobtn" name="invoiceKind"
							id="radio7" value="1" data-bind="checked: kindRadioType"> <label for="radio7"> <span
							class="inc"></span> <span class="check"></span> <span class="box"></span>
							企业
						</label>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group form-md-line-input">
			<label class="col-md-3 control-label" for="form_control_1">发票抬头</label>
			<div class="col-md-5" data-bind="visible: !displayEnt()">
              <span>个人</span>
            </div>
			<div class="col-md-5"  data-bind="visible: displayEnt">
				<input type="text" class="form-control" id="form_control_1"
					placeholder="Enter your name" name="invoiceTitle" value="${invoiceInfo.invoiceTitle }">
				<div class="form-control-focus"></div>
			</div>
		</div>
		<div class="form-group form-md-radios">
			<label class="col-md-3 control-label" for="form_control_1">发票类型</label>
			<div data-bind="visible: !displayEnt()">
                <span>增值税普通发票</span>
            </div>
			<div class="md-radio-inline" id="form_control_1" data-bind="visible: displayEnt">
				<div class="md-radio">
					<input type="radio" class="md-radiobtn" name="invoiceType" id="radio8"  value="0" data-bind="checked: typeRadioType" checked>
					<label for="radio8"> <span class="inc"></span> <span
						class="check"></span> <span class="box"></span> 增值税普通发票
					</label>
				</div>
				<div class="md-radio">
					<input type="radio" checked="" class="md-radiobtn" name="invoiceType"
						id="radio9"  value="1" data-bind="checked: typeRadioType" > <label for="radio9"> <span
						class="inc"></span> <span class="check"></span> <span class="box"></span>
						增值税专用发票
					</label>
				</div>
			</div>
		</div>
		<!-- ko if: displaySpecial -->  
		<div class="form-group form-md-line-input">
			<label class="col-md-3 control-label" for="form_control_1">税务登记证号</label>
			<div class="col-md-5">
				<input type="text" class="form-control" id="form_control_1"
					placeholder="Enter your name"  name="taxRegistrationNumber" value="${invoiceInfo.taxRegistrationNumber }">
				<div class="form-control-focus"></div>
			</div>
		</div>
		<div class="form-group form-md-line-input">
			<label class="col-md-3 control-label" for="form_control_1">基本开户银行名称</label>
			<div class="col-md-5">
				<input type="text" class="form-control" id="form_control_1"
					placeholder="Enter your name" name="basicAccountBankName" value="${invoiceInfo.basicAccountBankName }">
				<div class="form-control-focus"></div>
			</div>
		</div>
		<div class="form-group form-md-line-input">
			<label class="col-md-3 control-label" for="form_control_1">基本开户账号</label>
			<div class="col-md-5">
				<input type="text" class="form-control" id="form_control_1"
					placeholder="Enter your name" name="basicAccountNumber" value="${invoiceInfo.basicAccountNumber }">
				<div class="form-control-focus"></div>
			</div>
		</div>
		<div class="form-group form-md-line-input">
			<label class="col-md-3 control-label" for="form_control_1">注册场所地址</label>
			<div class="col-md-5">
				<input type="text" class="form-control" id="form_control_1"
					placeholder="Enter your name" name="registerPlaceAddress" value="${invoiceInfo.registerPlaceAddress }">
				<div class="form-control-focus"></div>
			</div>
		</div>
		<div class="form-group form-md-line-input">
			<label class="col-md-3 control-label" for="form_control_1">注册固定电话</label>
			<div class="col-md-5">
				<input type="text" class="form-control" id="form_control_1"
					placeholder="Enter your name" name="registerTel" value="${invoiceInfo.registerTel }">
				<div class="form-control-focus"></div>
			</div>
		</div>
		<div class="form-group form-md-line-input">
			<label class="col-md-3 control-label">营业执照复印件</label>
			<div class="col-md-5">
				<div class="fileinput fileinput-new" data-provides="fileinput">
					<div class="fileinput-preview thumbnail" data-trigger="fileinput"
						style="width: 200px; height: 150px;">
						<img src="${pageContext.request.contextPath}/invoice/preview/b" >
						</div>
					<div>
						<span class="btn default btn-file"> <span
							class="fileinput-new"> 选择图片 </span> <span
							class="fileinput-exists"> 更改 </span> <input type="file"
							name="businessLicence">
						</span> <a href="javascript:;" class="btn red fileinput-exists"
							data-dismiss="fileinput"> 移除 </a>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group form-md-line-input">
			<label class="control-label col-md-3">税务登记复印件</label>
			<div class="col-md-5">
				<div class="fileinput fileinput-new" data-provides="fileinput">
					<div class="fileinput-preview thumbnail" data-trigger="fileinput"
						style="width: 200px; height: 150px;">
						<img src="${pageContext.request.contextPath}/invoice/preview/t" >
						</div>
					<div>
						<span class="btn default btn-file"> <span
							class="fileinput-new"> 选择图片 </span> <span
							class="fileinput-exists"> 更改 </span> <input type="file"
							name="taxRegistration">
						</span> <a href="javascript:;" class="btn red fileinput-exists"
							data-dismiss="fileinput"> 移除 </a>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group form-md-line-input">
			<label class="control-label col-md-3">一般纳税人资格认证复印件</label>
			<div class="col-md-5">
				<div class="fileinput fileinput-new" data-provides="fileinput">
					<div class="fileinput-preview thumbnail" data-trigger="fileinput"
						style="width: 200px; height: 150px;">
						<img src="${pageContext.request.contextPath}/invoice/preview/g" >
						</div>
					<div>
						<span class="btn default btn-file"> <span
							class="fileinput-new"> 选择图片 </span> <span
							class="fileinput-exists"> 更改 </span> <input type="file"
							name="generalTaxQua">
						</span> <a href="javascript:;" class="btn red fileinput-exists"
							data-dismiss="fileinput"> 移除 </a>
					</div>
				</div>
			</div>
		</div>
		<!-- /ko -->  
	</div>
	<!-- ko if: canEdit -->  
	<div class="form-actions">
			<div class="row">
				<div class="col-md-offset-4">
					<button type="button" class="btn default col-md-2">取消</button>
					<button type="submit" class="btn btn-primary col-md-2 blue">提交</button>
				</div>
			</div>
	</div>
	<!-- /ko -->  
</form>
<h> <font color="red">${err!=null?err:"" }</font></h>
</br>

<c:if test="${invoiceInfo!=null&&invoiceInfo.auditInfo!=null&&invoiceInfo.auditInfo!='' }">
<div class="alert alert-danger">
<span>${invoiceInfo.auditInfo }</span>
</div>
</c:if>
</div>
<%@ include file="../common/footer.jsp"%>
<script>
  jQuery(document).ready(function() {
	  usercenter.nav("centerNav", [{
			title : "首页",
			href : '${pageContext.request.contextPath}/index'
		}, {
			title : "发票管理"
		}, {
			title : "发票信息管理"
		}]);
  });
</script>