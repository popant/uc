<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@page
	import="com.channelsoft.usercenter.consumable.po.*,java.util.List;"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../common/header.jsp"%>
<div class="portlet light">
	<!-- BEGIN PAGE HEADER-->
	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li><i class="fa fa-home"></i> <a href="${pageContext.request.contextPath}/index">首页</a> <i
				class="fa fa-angle-right"></i></li>
			<li><i class="fa"></i> <a href="javascript:void(0)">消费管理</a> <i
				class="fa fa-angle-right"></i></li>
			<li><i class="fa"></i> <a href="${pageContext.request.contextPath}/consume/gotoStatics">消费统计</a> <i
				class="fa fa-angle-right"></i></li>
		</ul>
	</div>
	<!-- END PAGE HEADER-->
	<div class="row inbox">
		<c:if test="${products == null || fn:length(products) == 0}">
			<div>
				<font size="5" face="黑体">该产品尚未商用!</font>
			</div>
		</c:if>
		<c:if test="${fn:length(products) > 0}">
			<div class="portlet box blue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i>
					</div>
					<div class="tools"></div>
				</div>
				<div class="portlet-body">
					<div class="table-scrollable">
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th scope="col" align="center">产品名</th>
									<th scope="col">消费总金额</th>
									<th scope="col">消费总资源</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="product" items="${products}">
									<c:forEach var="row" items="${statics}">
										<c:if test="${row.productId == product.productId}">
											<tr>
												<td>${product.productName}</td>
												<td>${row.consumableMoney}</td>
												<td>${row.consumableResource}</td>
											</tr>
										</c:if>
									</c:forEach>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</c:if>
	</div>
</div>
</div>
<!-- END CONTENT -->
</div>
<%@ include file="../common/footer.jsp"%>