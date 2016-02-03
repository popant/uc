<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ include file="../common/header.jsp"%>    
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
<!-- BEGIN PAGE HEADER-->
<div class="portlet light" >
<div class="page-bar" id="centerNav">
<!-- 	<ul class="page-breadcrumb"> -->
<!-- 		<li> -->
<!-- 			<i class="fa fa-home"></i> -->
<!-- 			<a href="index.html">产品开通</a> -->
<!-- 			<i class="fa fa-angle-right"></i> -->
<!-- 		</li> -->
<!-- 		<li> -->
<!-- 			<a href="#"></a> -->
<!-- 		</li> -->
<!-- 	</ul> -->
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN PAGE CONTENT-->
<div class="row ">
	<div class="col-md-12">
				<!-- BEGIN SAMPLE FORM PORTLET-->
<!-- 		<div class="portlet box light"> -->
<!-- 			<div class="portlet-title"> -->
<!-- 				<div class="caption"> -->
<!-- 					<i class="fa fa-gift"></i> 已开通 -->
<!-- 				</div> -->
<!-- 				<div class="tools"> -->
<!-- 					<a href="" class="collapse"> -->
<!-- 					</a> -->
<!-- 				</div> -->
<!-- 			</div> -->
            <a class="btn light" >
                 <i class="fa fa-gift"></i>已开通 
            </a>
			 <!-- ko foreach: openedProducts -->
			<div class="portlet-body">

				<form role="form">
					<div class="row">
						<!-- /.col-lg-6 -->
						<div class="col-md-3">
							<div class="input-group">
								<input type="text" class="form-control" data-bind="value:productName" disabled >
							</div>
							<!-- /input-group -->
						</div>
						<!-- /.col-lg-6 -->
						<div class="col-md-1"> 
						    <span class="btn light" type="button" data-bind="text:status" disabled></span>
						</div>
						<div class="col-md-2">剩余通话时长:
						    <span class="btn light" type="button" data-bind="text:remainCallTime" disabled></span>
						</div>
						<!-- ko if: commercial -->  
						<div class="col-md-1" > 
						    <a class="btn light" data-bind="attr:{href:commercialUrl},click:function() {return $parent.forCommercial(passAudit,commercialUrl)}">申请商用</a>
						</div>
						<!-- /ko -->  
						<!-- ko if: deposit -->  
						<div class="col-md-1" > 
						    <a class="btn light" data-bind="attr:{href:depositUrl}" >立即充值</a>
						</div>
						<!-- /ko -->  
						<!-- ko if: agreement -->  
						<div class="col-md-1" > 
						    <a class="btn light"  data-bind="attr:{href:agreementUrl}">申请合同</a>
						</div>
						<!-- /ko -->  
					</div>
					<!-- /.row -->
				</form>
			</div>
			 <!-- /ko -->
			
<!-- 		</div> -->
		<!-- END SAMPLE FORM PORTLET-->
	</div>
	
	<div class="col-md-12">
		
		<!-- BEGIN SAMPLE FORM PORTLET-->
<!-- 		<div class="portlet box light"> -->
<!-- 			<div class="portlet-title"> -->
<!-- 				<div class="caption"> -->
<!-- 					<i class="fa fa-gift"></i> 未开通 -->
<!-- 				</div> -->
<!-- 				<div class="tools"> -->
<!-- 					<a href="" class="collapse"> -->
<!-- 					</a> -->
<!-- 				</div> -->
<!-- 			</div> -->
            <a class="btn light" >
                 <i class="fa fa-gift"></i>未开通 
            </a>
			<div class="portlet-body">

				<form role="form">
					<div class="row">
						 <!-- ko foreach: products -->
						<div class="col-lg-3">
							<div class="input-group">
								<input type="text" class="form-control" data-bind="value:productName" disabled >
								<span class="input-group-btn">
								<button class="btn green-turquoise" type="button" data-bind="click:function() {$parent.openProduct(productId)}">+</button>
								</span>
							</div>
						</div>
						<!-- /ko -->
					</div>
					<!-- /.row -->
				</form>
			</div>
<!-- 		</div> -->
		<!-- END SAMPLE FORM PORTLET-->
	</div>
</div>
<!-- END PAGE CONTENT-->
</div>
<%@ include file="../common/footer.jsp"%>
<script>
  jQuery(document).ready(function() {
		usercenter.nav("centerNav", [{
			title : "首页",
			href : '${pageContext.request.contextPath}/index'
		}, {
			title : "产品管理"
		}, {
			title : "产品开通"
		}]);
  });
</script>