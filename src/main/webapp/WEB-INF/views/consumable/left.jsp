<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@page
	import="com.channelsoft.usercenter.consumable.po.*,java.util.List;"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../common/header.jsp"%>
<script type="text/javascript">
	//提交表单前的验证
	function checkMyForm() {
		var checkedValue = $("input[name='consumable']:checked").val();
		if (checkedValue == undefined) {
			alert("您没有选中任何消费品!");
			return;
		} else {
			var id = "consumableNum" + checkedValue;
			if ($("#" + id).val() == "" || $("#" + id).val() == null
					|| $("#" + id).val() == "0") {
				alert("请选择数量!");
				return;
			} else {
				$("#consumableId").val(checkedValue);
				$("#consumableName").val($("#name" + checkedValue).val());
				$("#consumableNumber").val(
						$("#consumableNum" + checkedValue).val());
				$("#consumablePrice").val($("#price" + checkedValue).val());
				$("#consumableResource").val(
						$("#resource" + checkedValue).val());
				$("#myForm").submit();
			}
		}
	}

	//验证消费品数量为正整数
	function validNum(id) {
		if (/^[0-9]*[1-9][0-9]*$/.test($("#consumableNum" + id).val())) {
			$("#consumableTotalPrice").val(
					parseInt($("#consumableNum" + id).val())
							* parseFloat($("#price" + id).val()));
		} else {
			alert("请输入正整数!");
			$("#consumableNum" + id).val("");
		}
	}

	//数量减1
	function subtract(id) {
		if (/^[0-9]*[1-9][0-9]*$/.test($("#consumableNum" + id).val())) {
			if ($("#consumableNum" + id).val() == "1") {
				alert("最少选择1");
			} else {
				$("#radio" + id).attr("checked", "checked");
				$("#consumableNum" + id).val(
						parseInt($("#consumableNum" + id).val()) - 1);
				$("#consumableTotalPrice")
						.val(
								(parseFloat($("#consumableTotalPrice").val()) - parseFloat($(
										"#price" + id).val())).toFixed(2));
			}
		} else {
			$("#radio" + id).attr("checked", "checked");
			$("#consumableNum" + id).val("1");
			$("#consumableTotalPrice").val(
					parseFloat($("#price" + id).val()).toFixed(2));
			$("input[name='num']").each(function(index) {
				if ($(this).attr("id") != "consumableNum" + id) {
					$(this).val("0");
				}
			});
		}
	}

	//数量加1
	function add(id) {
		if (/^[0-9]*[1-9][0-9]*$/.test($("#consumableNum" + id).val())) {
			$("#radio" + id).attr("checked", "checked");
			$("#consumableNum" + id).val(
					parseInt($("#consumableNum" + id).val()) + 1);
			$("#consumableTotalPrice")
					.val(
							(parseFloat($("#consumableTotalPrice").val()) + parseFloat($(
									"#price" + id).val())).toFixed(2));
		} else {
			$("#radio" + id).attr("checked", "checked");
			$("#consumableNum" + id).val("1");
			$("#consumableTotalPrice").val(
					parseFloat($("#price" + id).val()).toFixed(2));
			$("input[name='num']").each(function(index) {
				if ($(this).attr("id") != "consumableNum" + id) {
					$(this).val("0");
				}
			});
		}
	}

	//计算总金额
	function calculateTotalPrice(id) {
		$("#consumableTotalPrice").val("0".toFixed(2));
		$("input[name='num" + id + "']").each(function(index) {
			$(this).val("0");
		});
	}
	var APPpath = "${pageContext.request.contextPath}";

	$(function() {
		$("input[name='productBtn']").each(function(index) {
			$(this).removeClass();
		});
		$("#btn"+${currentId}).addClass("active");
	})
</script>
<div class="portlet light">
	<!-- BEGIN PAGE HEADER-->
	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li><i class="fa fa-home"></i> <a
				href="${pageContext.request.contextPath}/index">首页</a> <i
				class="fa fa-angle-right"></i></li>
			<li><i class="fa"></i> <a href="javascrpit:void(0);">消费管理</a> <i
				class="fa fa-angle-right"></i></li>
			<li><i class="fa"></i> <a
				href="${pageContext.request.contextPath}/purchase/gotoFrame">充值缴费</a>
				<i class="fa fa-angle-right"></i></li>
		</ul>
	</div>
	<!-- END PAGE HEADER-->
	<c:if test="${products == null || fn:length(products) == 0}">
		<font size="5" face="黑体">暂无产品!</font>
	</c:if>
	<c:if test="${fn:length(products) > 0}">
		<div class="row inbox">
			<div class="col-md-2">
				<ul class="inbox-nav margin-bottom-10">
					<li class="compose-btn">
							<a href="javascript:;" data-title="充值缴费" class="btn">
							<i class="fa fa-edit"></i> 充值缴费 </a>
					</li>
					<c:forEach var="product" items="${products}" varStatus="vs">
							<li class="" id="btn${product.productId}" name="productBtn"><a
							href="${pageContext.request.contextPath}/purchase/gotoFrame?productId=${product.productId}"
							class="btn" data-title="${product.productName}">${product.productName}</a>
							<b></b></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-md-10">
				<div class="inbox-header">
					<h1 class="pull-left">&nbsp;</h1>
				</div>
				<div class="inbox-content">
					<c:if test="${consumables == null || fn:length(consumables) == 0}">
						<div>
							<font size="5" face="黑体">该产品下没有消费品!</font>
						</div>
					</c:if>
					<c:if test="${fn:length(consumables) != 0}">
						<form id="myForm" role="form" class="form-horizontal"
							action="${pageContext.request.contextPath}/purchase/gotoPay"
							method="post">
							<div class="form-body">
								<input type="hidden" name="productId"
									value="${consumables[0].productId}" /> <input type="hidden"
									name="consumableId" id="consumableId" /> <input type="hidden"
									name="consumableName" id="consumableName" /> <input
									type="hidden" name="consumableNumber" id="consumableNumber" />
								<input type="hidden" name="consumablePrice" id="consumablePrice" />
								<input type="hidden" name="consumableResource"
									id="consumableResource" />

								<c:forEach var="row" items="${consumables}">
									<div class="col-sm-5">
										<div class="portlet light bordered">
											<div class="portlet-body form">
												<div class="form-group form-md-line-input has-info">
													<input type="text" class="text-center form-control"
														readonly value="${row.consumablePrice}元"
														id="form_control_1" placeholder="Placeholder...">
													<textarea class="text-center form-control" rows="2"
														readonly placeholder="${row.consumableName}"></textarea>
													<div class="input-group input-group-sm">
														<span class="input-group-btn btn-left">
															<button class="btn red-intense" type="button"
																onclick="subtract('${row.consumableId}')">-</button>
														</span>
														<div class="input-group-control">
															<input type="text"
																class="text-center form-control input-sm"
																placeholder="在此输入购买数量..."
																onchange="validNum('${row.consumableId}')" name="num"
																id="consumableNum${row.consumableId}" />
															<div class="form-control-focus"></div>
														</div>
														<span class="input-group-btn btn-right">
															<button class="btn green-haze" type="button"
																onclick="add('${row.consumableId}')">+</button>
														</span>
													</div>
												</div>
												<br /> <input type="hidden" id="name${row.consumableId}"
													value="${row.consumableName}" /> <input type="hidden"
													id="price${row.consumableId}"
													value="${row.consumablePrice}" /> <input type="hidden"
													id="resource${row.consumableId}"
													value="${row.consumeResource}" />
												<div class="md-radio col-sm-offset-6 ">
													<input type="radio" class="md-radiobtn"
														id="radio${row.consumableId}" name="consumable"
														value="${row.consumableId}"
														onclick="calculateTotalPrice('${row.consumableId}');" />
													<label for="radio${row.consumableId}"> <span></span>
														<span class="check"></span> <span class="box"></span>
													</label>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
							<div class="form-actions noborder">
								<div class="row">
									<div class="form-md-line-input">
										<label class="col-sm-3 control-label"
											for="consumableTotalPrice">合计:</label>
										<div class="col-sm-2">
											<input type="text" class=" form-control" readonly
												id="consumableTotalPrice" placeholder="0.00">
											<div class="form-control-focus"></div>
										</div>
										<button type="button" class="btn blue col-sm-1"
											onclick="checkMyForm()">购买</button>
									</div>
								</div>
							</div>
						</form>
					</c:if>
				</div>
			</div>
		</div>
	</c:if>
</div>
</div>
<!-- END CONTENT -->
</div>

<%@ include file="../common/footer.jsp"%>