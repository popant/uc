<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/jslib/jquery-1.8.0.min.js"></script>
<script src="${pageContext.request.contextPath}/jslib/knockout-3.2.0.js"></script>
<script type="text/javascript">

var APP = {};
APP.viewModel = function() {
	var self = this;
	//个人:0 企业:1
	this.kindRadioType = ko.observable("${invoiceInfo.invoiceKind!=null?invoiceInfo.invoiceKind.value:0}");
	//普通发票:0 专用发票:1
	this.typeRadioType = ko.observable("${invoiceInfo.invoiceType!=null?invoiceInfo.invoiceType.value:0}");
    this.displayEnt = ko.dependentObservable(function (){
        if (self.kindRadioType() == "0"){
            return false;
        }else{
            return true;
        }
    });
    this.displaySpecial = ko.dependentObservable(function(){
    	if(self.kindRadioType() == "1"&&self.typeRadioType() == "1"){
    		return true;
    	}else{
    		return false;
    	}
    });
	this.canEdit = ko.dependentObservable(function(){
		if('${canEdit}'=='true'){
			return true;
		}else{
			return false;
		}
	});
	this.canPreview = ko.dependentObservable(function(){
		if('${invoiceInfo!=null}'=='true' && !self.canEdit){
			return true;
		}else{
			return false;
		}
	});
	
	
}

$(function() {
    APP.vm = new APP.viewModel();
    ko.applyBindings(APP.vm);
});
</script>
</head>
<body>
  <h3 style="background-color: #e0dada;">
发票信息管理</h3>
<form action="saveInfo" method="post" enctype="multipart/form-data">
 <table border="0" style="border-collapse: collapse; table-layout: fixed; width: 100%;">
   <colgroup>
     <col></col>
     <col></col>
     <col></col>
   </colgroup>
   <tbody>
     <tr>
       <td style="text-align: right;" class="right">
         开具类型:</td>
       <td>
         <input type="radio" name="invoiceKind" value="0" data-bind="checked: kindRadioType" checked></input><span>个人</span>
         <input type="radio" name="invoiceKind" value="1" data-bind="checked: kindRadioType"></input><span>企业</span>
       </td>
       <td>
         &nbsp;</td>
     </tr>
     <tr>
       <td style="text-align: right;" class="right">
         发票抬头:</td>
       <td>
       <div data-bind="visible: !displayEnt()">
         <span>个人</span>
       </div>
       <div data-bind="visible: displayEnt" >
         <input name="invoiceTitle" placeholder="请填写您营业执照上的全称" value="${invoiceInfo.invoiceTitle }"></input>
       </div>
       </td>
       <td>
       </td>
     </tr>
     <tr>
       <td style="text-align: right;" class="right">
         发票类型:</td>
       <td>
       <div data-bind="visible: !displayEnt()">
         增值税普通发票
       </div>
       <div data-bind="visible: displayEnt">
         &nbsp;<input type="radio" name="invoiceType" value="0" data-bind="checked: typeRadioType" checked></input>
<label>
增值税普通发票</label>
<input  type="radio" name="invoiceType" value="1" data-bind="checked: typeRadioType" ></input>
<label>
增值税专用发票</label>
       </div>
         </td>
       <td>
</td>
     </tr>
     <tr data-bind="visible : displaySpecial">
       <td style="text-align: right;" class="right">
         税务登记证号:</td>
       <td>
         &nbsp;<input type="text" name="taxRegistrationNumber" value="${invoiceInfo.taxRegistrationNumber }"></input>
</td>
       <td>
         &nbsp;</td>
     </tr>
     <tr data-bind="visible : displaySpecial">
       <td style="text-align: right;" class="right">
         基本开户银行名称:</td>
       <td>
         &nbsp;<input name="basicAccountBankName" value="${invoiceInfo.basicAccountBankName }"></input>
</td>
       <td>
         &nbsp;</td>
     </tr>
     <tr data-bind="visible : displaySpecial">
       <td style="text-align: right;" class="right">
         基本开户账号:</td>
       <td>
         &nbsp;<input name="basicAccountNumber" value="${invoiceInfo.basicAccountNumber }"></input>
</td>
       <td>
         &nbsp;</td>
     </tr>
     <tr data-bind="visible : displaySpecial">
       <td style="text-align: right;" class="right">
         注册场所地址:</td>
       <td>
         &nbsp;<input name="registerPlaceAddress" value="${invoiceInfo.registerPlaceAddress }"></input>
</td>
       <td>
         &nbsp;</td>
     </tr>
     <tr data-bind="visible : displaySpecial">
       <td style="text-align: right;" class="right">
         注册固定电话:</td>
       <td>
         &nbsp;<input name="registerTel" value="${invoiceInfo.registerTel }"></input>
</td>
       <td>
         &nbsp;</td>
     </tr>
     <tr data-bind="visible : displaySpecial">
       <td style="text-align: right;" class="right">
         营业执照复印件:</td>
       <td>
       <div data-bind="if : !canEdit()">
       <a href="${pageContext.request.contextPath}/invoice/preview/b" >预览</a>
       </div>
         &nbsp;<input type="file" name="businessLicence" data-bind="visible : canEdit"></input>
</td>
       <td>
         &nbsp;</td>
     </tr>
     <tr data-bind="visible : displaySpecial">
       <td style="text-align: right;" class="right">
         税务登记复印件:</td>
       <td>
       <div data-bind="if : !canEdit()">
       <a href="${pageContext.request.contextPath}/invoice/preview/t" >预览</a>
       </div>
         &nbsp;<input type="file" name="taxRegistration" data-bind="visible : canEdit"></input>
</td>
       <td>
         &nbsp;</td>
     </tr>
     <tr data-bind="visible : displaySpecial">
       <td style="text-align: right;" class="right">
         一般纳税人资格认证复印件:</td>
       <td>
       <div data-bind="if : !canEdit()">
       <a href="${pageContext.request.contextPath}/invoice/preview/g" >预览</a>
       </div>
         &nbsp;<input type="file" name="generalTaxQua" data-bind="visible : canEdit"></input>
</td>
       <td>
         &nbsp;</td>
     </tr>
     <tr>
       <td>
         &nbsp;</td>
       <td>
         &nbsp;<input type="submit"  value="提交" data-bind="visible : canEdit"></input>
</td>
       <td>
         &nbsp;</td>
     </tr>
   </tbody>
 </table>
</form>
<h><font color="red">${err!=null?err:"" }</font></h></br>
<h>当前进度:${invoiceInfo.auditStatus==null?"提交":invoiceInfo.auditStatus.desc } </h><h>${invoiceInfo.auditInfo }</h>
</body>
</html>