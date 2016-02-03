<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp"%>
<script src="${pageContext.request.contextPath}/jslib/addressManage.js"></script>
<script>
var APPpath = "${pageContext.request.contextPath}";
</script>
<!-- BEGIN PAGE CONTAINER -->
    <!-- BEGIN PAGE CONTENT -->
            <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
            <!-- BEGIN PAGE CONTENT INNER -->
            <div class="row">
                <div class="col-md-12">
                    <!-- BEGIN EXAMPLE TABLE PORTLET-->
                    <div class="portlet light">
                    <div class="page-bar" id="centerNav">
<!-- 	                   <ul class="page-breadcrumb"> -->
<!-- 		              <li> -->
<!-- 			            <i class="fa fa-home"></i> -->
<!-- 			            <a href="index.html">寄送地址管理</a> -->
<!-- 			            <i class="fa fa-angle-right"></i> -->
<!-- 		              </li> -->
<!-- 		               <li> -->
<!-- 			             <a href="#"></a> -->
<!-- 		               </li> -->
<!-- 	                  </ul> -->
                     </div>
<!--                         <div class="portlet-title"> -->
<!--                             <div class="caption"> -->
<!--                                 <i class="fa fa-cogs font-green-sharp"></i> -->
<!--                                 <span class="caption-subject font-green-sharp bold uppercase">发票邮寄地址管理</span> -->
<!--                             </div> -->
<!--                             <div class="tools"> -->
<!--                                 <a href="javascript:;" class="collapse"> -->
<!--                                 </a> -->
<!--                             </div> -->
<!--                         </div> -->
                        <div class="portlet-body">
                            <div class="table-toolbar">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="btn-group">
                                            <button id="sample_editable_1_new" class="btn green">
                                                添加地址 <i class="fa fa-plus"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <table class="table table-striped table-hover table-bordered" id="sample_editable_1">
                                <thead>
                                <tr>
                                    <th>
                                        收件人姓名
                                    </th>
                                    <th>
                                        电话号码
                                    </th>
                                    <th>
                                        地址
                                    </th>
                                    <th>
                                        邮编
                                    </th>

                                    <th>
                                        修改
                                    </th>
                                    <th>
                                        删除
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="address" items="${list}">
                                    <tr  data-addressId="${address.id}">
                                        <td>
                                                ${address.mailName}
                                        </td>
                                        <td>
                                                ${address.phoneNumber}
                                        </td>
                                        <td>
                                                ${address.mailAddress}
                                        </td>
                                        <td>
                                                ${address.postalCode}
                                        </td>
                                        <td>
                                            <a class="edit" href="">
                                                修改 </a>
                                        </td>
                                        <td>
                                            <a class="delete" href="">
                                                删除 </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- END EXAMPLE TABLE PORTLET-->
                </div>
            </div>
            <!-- END PAGE CONTENT -->
    <!-- END PAGE CONTENT -->
<!-- END PAGE CONTAINER -->
<div class="scroll-to-top">
    <i class="icon-arrow-up"></i>
</div>
<!-- END FOOTER -->


<script>
    function addAddress(mailName) {
        alert(mailName);
        <%--window.location.href = '${pageContext.request.contextPath}/mailAddress/addMailAddress?mailName=' + mailName--%>
                <%--+ '&phoneNumber=' + phoneNumber--%>
                <%--+ '&mailAddress=' + mailAddress--%>
                <%--+ '&postalCode=' + postalCode;--%>
    }

</script>
<%@ include file="../common/footer.jsp"%>
<script>
  jQuery(document).ready(function() {
	  usercenter.nav("centerNav", [{
			title : "首页",
			href : '${pageContext.request.contextPath}/index'
		}, {
			title : "发票管理"
		}, {
			title : "寄送地址管理"
		}]);
	  TableEditable.init();
  });
</script>