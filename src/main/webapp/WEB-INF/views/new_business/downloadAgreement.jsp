<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ include file="../common/header.jsp"%>   
<!-- BEGIN PAGE HEADER-->
<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a href="index.html">合同管理</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a href="#"></a>
		</li>
	</ul>
</div>
<!-- END PAGE HEADER-->
<div class="row">
<div class="col-md-12 margin-top-10">
<img src="${pageContext.request.contextPath}/agreement/loadImg/${productId}"></br>
<a href="${pageContext.request.contextPath}/agreement/download/${productId}">点击下载</a>
</div>
</div>
<%@ include file="../common/footer.jsp"%>