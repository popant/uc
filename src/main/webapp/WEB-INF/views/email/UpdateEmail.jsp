<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML >
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>修改绑定邮箱</title>

<%--     <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.4.0" rel="stylesheet"> --%>
<%--     <link href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.3.0" rel="stylesheet"> --%>
    <link href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min.css?v=3.2.0" rel="stylesheet">

</head>

<body>
<div class="portlet light" >
<!-- BEGIN PAGE HEADER-->
<div class="page-bar">
    <ul class="page-breadcrumb">
        <li><i class="fa fa-home"></i> <a href="index.html">修改绑定邮箱</a> <i
                class="fa fa-angle-right"></i></li>
        <li><a href="#"></a></li>
    </ul>
</div>
<!-- END PAGE HEADER-->
<div class="row">
    <div class="col-sm-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>修改绑定邮箱</h5>
            </div>
            <div class="ibox-content">
                <form method="get" class="form-horizontal">
                    <td>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">原邮箱：</label>

                            <div class="col-sm-10">
                                <div class="input-group">
                                    <input disabled="" type="text" class="form-control" value=${email}>
                                </div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                    </td>

                    <td>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">新邮箱：</label>

                            <div class="col-sm-10">
                                <div class="input-group">
                                    <input id="receiver" type="text" class="form-control">
                                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-primary"
                                                    onclick="javascript:updateEmail();">确认修改
                                            </button> </span>
                                </div>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                    </td>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
<a href="${pageContext.request.contextPath}"></a>
<!-- 全局js -->
<%-- <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script> --%>
<%-- <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script> --%>

<!-- iCheck -->
<script src="${pageContext.request.contextPath}/js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });

    function updateEmail() {
        window.location.href = '${pageContext.request.contextPath}/sendEmail/send?receiver=' + $('#receiver').val();
    }
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/msgsignature/MsgSignature.js"></script>
</body>
</html>
<%@ include file="../common/footer.jsp" %>