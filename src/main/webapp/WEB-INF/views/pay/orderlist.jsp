<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.channelsoft.usercenter.pay.po.*"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/assets/global/css/components-rounded.css"
	rel="stylesheet" type="text/css">
<title>订单详情</title>

</head>
<%
	Order order = (Order) request.getAttribute("order");
	String orderId=order.getOrder_id().toString();
	String fee=order.getTotle_price().toString();
%>


<body>
	<br>
	<br>
	<form id="form" action="/usercenter/pay/topay" method="post"
		target="_top|_blank">
		<input type="hidden" name="orderId" value="<%=orderId%>">
		<input type="hidden" name="totalFee" value="<%=fee%>">
		<div class="portlet box green">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-cogs"></i>订单支付
				</div>
				<div class="tools"></div>
			</div>
			<div class="portlet-body">
				<div class="table-scrollable">
					<table class="table table-striped table-bordered table-hover">
						<thead>
						</thead>
						<tbody>

							<tr>
								<td>订单号：</td>
								<td><%=order.getOrder_id()%></td>
							</tr>
							<tr>
								<td>金&nbsp额：</td>
								<td id="fee"><%=order.getTotle_price()%></td>
							</tr>
					</table>

				</div>
			</div>
		</div>

		<button type="submit" class="btn btn-success btn-lg">去支付</button>
	</form>
</body>
</html>
