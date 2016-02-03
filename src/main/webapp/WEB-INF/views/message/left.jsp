<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="../common/header.jsp"%>
<script>
var APPpath = "${pageContext.request.contextPath}";
</script>
<div class="portlet light" >
	<!-- BEGIN PAGE HEADER-->
			<div class="page-bar"  id="centerNav">
<!-- 				<ul class="page-breadcrumb"> -->
<!-- 					<li> -->
<!-- 						<i class="fa fa-home"></i> -->
<!-- 						<a href="index.html">短信管理</a> -->
<!-- 						<i class="fa fa-angle-right"></i> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<a href="#">Pages</a> -->
<!-- 						<i class="fa fa-angle-right"></i> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<a href="#">Inbox</a> -->
<!-- 					</li> -->
<!-- 				</ul> -->
			</div>
			<!-- END PAGE HEADER-->
			<div class="row inbox">
				<div class="col-md-2">
					<ul class="inbox-nav margin-bottom-10">
						<li class="compose-btn">
							<a href="javascript:;" data-title="短信服务" class="btn">
							<i class="fa fa-edit"></i> 短信服务 </a>
						</li>
						<li class="smsSignature active">
							<a href="javascript:;" class="btn" data-title="短信签名">
							短信签名 </a>
							<b></b>
						</li>
						<li class="smsTemplate">
							<a class="btn" href="javascript:;" data-title="短信模板">
							短信模板 </a>
							<b></b>
						</li>
						<li class="forApiKey">
							<a class="btn" href="javascript:;" data-title="申请密钥">
							申请密钥 </a>
							<b></b>
						</li>
						<li class="sendRecord">
							<a class="btn" href="javascript:;" data-title="发送记录">
							发送记录 </a>
							<b></b>
						</li>
						<li class="sendStatistics">
							<a class="btn" href="javascript:;" data-title="发送统计">
							发送统计 </a>
							<b></b>
						</li>
					</ul>
				</div>
				<div class="col-md-10">
					<div class="inbox-header">
						<h1 class="pull-left">&nbsp;</h1>
					</div>
					<div class="inbox-loading">
						 Loading...
					</div>
					<div class="inbox-content">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<script src="${pageContext.request.contextPath}/jslib/smsService.js"></script>
<%@ include file="../common/footer.jsp"%>
<script>
  jQuery(document).ready(function() {
	  usercenter.nav("centerNav", [{
			title : "首页",
			href : '${pageContext.request.contextPath}/index'
		}, {
			title : "产品管理"
		}, {
			title : "短信管理"
		}]);
	  Inbox.init();
  });
</script>