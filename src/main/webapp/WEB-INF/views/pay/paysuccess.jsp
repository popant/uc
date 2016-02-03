<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"%>
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
<title>支付成功</title>
</head>

<%
	String out_trade_no = request.getAttribute("out_trade_no")
			.toString();
	String total_fee = request.getAttribute("total_fee").toString();
	String body = request.getAttribute("body").toString();
%>
<body>


	<div class="portlet box green">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-cogs"></i>支付成功
			</div>
			<div class="tools"></div>
		</div>
		<div class="portlet-body">
			<div class="table-scrollable">
				<table class="table table-striped table-bordered table-hover">
					<tbody>

						<tr>
							<td>订单详情：</td>
							<td><%=body%></td>
						</tr>
						<tr>
							<td>订单编号：</td>
							<td><%=out_trade_no%></td>
						</tr>
						<tr>
							<td>订单金额：</td>
							<td><%=total_fee%></td>
						</tr>
				</table>
			</div>
		</div>
	</div>
	<div align="center">
		<input type="button" value=" Close" onclick="window.close()">
	</div>
</body>
</html>

<%@ include file="../common/footer.jsp"%>