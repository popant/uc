<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page language="java"
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
			<li><i class="fa"></i> <a href="${pageContext.request.contextPath}/consume/gotoStaticsDetail">消费明细</a> <i
				class="fa fa-angle-right"></i></li>
		</ul>
	</div>
	<!-- END PAGE HEADER-->
	<c:if test="${products == null || fn:length(products) == 0}">
		<div>
			<font size="5" face="黑体">产品未商用!</font>
		</div>
	</c:if>
	<c:if test="${fn:length(products) >= 0}">
		<c:if test="${fn:length(staticsDetails) == 0}">
			<div>
				<font size="5" face="黑体">尚未有消费数据!</font>
			</div>
		</c:if>
		<c:if test="${fn:length(staticsDetails) > 0}">
			<c:forEach var="product" items="${products}">
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-cogs"></i>${product.productName}
						</div>
						<div class="tools"></div>
					</div>
					<div class="portlet-body">
						<div class="table-scrollable">
							<table class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th scope="col" align="center">序号</th>
										<th scope="col">时间</th>
										<th scope="col">订单号</th>
										<th scope="col">金额</th>
										<th scope="col">通话时长</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="staticsDetail" items="${staticsDetails}" varStatus="vs">
										<c:if test="${staticsDetail.productId == product.productId}">
											<tr>
												<td>${vs.count}</td>
												<td><fmt:formatDate value="${staticsDetail.payTime}"
														pattern="yyyy/MM/dd HH:mm:ss" /></td>
												<td>${staticsDetail.orderId}</td>
												<td>${staticsDetail.totlePrice}</td>
												<td>${staticsDetail.totalResource}</td>
											</tr>
										</c:if>
									</c:forEach>
									<c:forEach var="row" items="${statics}">
										<c:if test="${row.productId == product.productId}">
											<tr>
												<th>总计</th>
												<td></td>
												<td></td>
												<th>${row.consumableMoney}元</th>
												<th>${row.consumableResource}分钟</th>
											</tr>
										</c:if>
									</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</c:if>
</div>
<%@ include file="../common/footer.jsp"%>