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
	this.openedProducts = ko.observableArray();
	this.products = ko.observableArray();
	this.forCommercial = function(status,url){
		if(status){
// 			return true;
			//这里去掉return true换成ajax好了..
			$.ajax({
				url:url,
				type:'get',
				cache:false,
				dataType:'json',  
				success:function(data) {  
				         if(data.ret =="00" ){  
				             alert("操作成功！");  
				             self.products.removeAll();
				     		 self.openedProducts.removeAll();
				     		 self.initVals();
				        }else{  
				        	alert("操作失败");  
				         }  
				      } 
			});
		}else{
			if(confirm("当前企业还没有成功认证,是否前往认证页面?")){
				//前往认证
				location.href="${pageContext.request.contextPath}/ent/authenticate";
			}
		}
	}
	this.initVals = function(){
		$.ajax({
			url:'${pageContext.request.contextPath}/business/init',
			type:'get',
			cache:false,
			dataType:'json',  
			success:function(data) {  
			         if(data.ret =="00" ){  
			             var notOpen = data.notOpenProducts;
// 						 for (var i = 0, len = list.length; i < len; i++) {
// 							 self.products.push({productName:list[i].productName,productId:list[i].productId});
// 						 }
			             for(var i in notOpen){
			            	 self.products.push({productName:notOpen[i].productName,productId:notOpen[i].productId});
			             }
			             var opened = data.openedProducts;
			             for(var j in opened){
			            	 self.openedProducts.push({productName:opened[j].productName,productId:opened[j].productId,remainCallTime:opened[j].remainCallTime,commercial:opened[j].commercial,commercialUrl:"${pageContext.request.contextPath}"+opened[j].commercialUrl,deposit:opened[j].deposit,depositUrl:"${pageContext.request.contextPath}"+opened[j].depositUrl,agreement:opened[j].agreement,agreementUrl:"${pageContext.request.contextPath}"+opened[j].agreementUrl,status:opened[j].status.desc,passAudit:opened[j].passAudit});
			             }
			        }else{  
			        	alert("初始化失败");  
			         }  
			      } 
		});
	}
	this.openProduct = function(id){
		$.ajax({
			url:'${pageContext.request.contextPath}/business/open?id='+id,
			type:'get',
			cache:false,
			dataType:'json',  
			success:function(data) {  
			         if(data.ret =="00" ){  
			             alert("开通成功！");  
			             self.products.removeAll();
			     		 self.openedProducts.removeAll();
			     		 self.initVals();
			        }else{  
			        	alert("开通失败");  
			         }  
			      } 
		});
		
	}
	
	
}

$(function() {
    APP.vm = new APP.viewModel();
    ko.applyBindings(APP.vm);
    
    APP.vm.initVals();
});
</script>
</head>
<body>
  <h3 style="background-color: #e0dada;">
产品开通</h3>
 <table border="0" style="border-collapse: collapse; table-layout: fixed; width: 100%; height: 107px; position: relative; top: 1em;">
   <colgroup>
     <col></col>
     <col></col>
     <col></col>
     <col></col>
     <col></col>
     <col></col>
   </colgroup>
   <tbody>
     <tr>
       <td>
         已开通:</td>
       <td>
         &nbsp;</td>
       <td>
         &nbsp;</td>
       <td>
         &nbsp;</td>
       <td>
         &nbsp;</td>
         <td>
         &nbsp;</td>
     </tr>
         <!-- ko foreach: openedProducts -->
     <tr>
       <td>
         <input type="text" size="12" disabled="disabled" data-bind="value:productName">
         </td>
         <td>
         <span data-bind="text:status" ></span>
         </td>
         <td>
         剩余通话时长:<span data-bind="text:remainCallTime" ></span>
         </td>
         <td>
         <a data-bind="visible:commercial,attr:{href:commercialUrl},click:function() {return $parent.forCommercial(passAudit,commercialUrl)}" >申请商用</a>
         </td>
         <td>
         <a data-bind="visible:deposit,attr:{href:depositUrl}" >立即充值</a>
         </td>
         <td>
         <a data-bind="visible:agreement,attr:{href:agreementUrl}" >申请合同</a>
         </td>
     </tr>
         <!-- /ko -->
     <tr>
       <td>
         未开通</td>
       <td>
         &nbsp;</td>
       <td>
         &nbsp;</td>
       <td>
         &nbsp;</td>
       <td>
         &nbsp;</td>
         <td>
         &nbsp;</td>
     </tr>
     <tr>
         <!-- ko foreach: products -->
       <td>
         <input type="text" size="12" disabled="disabled" data-bind="value:productName">
         <input type="button" value="+" data-bind="click:function() {$parent.openProduct(productId)}">
         </td>
         <!-- /ko -->

     </tr>
   </tbody>
 </table>
</body>
</html>