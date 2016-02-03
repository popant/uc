<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML >
<html>
<head>
<!--     <meta charset="utf-8"> -->
<!--     <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->


<!--     <title>申请短信秘钥</title> -->

<%--     <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.4.0" rel="stylesheet"> --%>
<%--     <link href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.3.0" rel="stylesheet"> --%>
    <link href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min.css?v=3.2.0" rel="stylesheet">

</head>

<body>
<div class="row">
    <div class="col-sm-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>申请短信秘钥</h5>
            </div>
            <div class="ibox-content">
                <form method="get" class="form-horizontal">
                    <c:if test="${reqStatus=='1'||reqStatus==null}">
                        <td>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">api key：</label>
                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <input id="apikey" disabled="" type="text" class="form-control" value=${apikey}>
                                    </div>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                        </td>
                        <td>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">当前密钥：</label>

                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <input id="secretkey" disabled="" type="text" class="form-control" value=${secretkey}>
                                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-primary"
                                                    onclick="javascript:toApplyagain();">重新申请
                                            </button> </span>
                                    </div>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                        </td>
                    </c:if>
                    <c:if test="${reqStatus=='0'}">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">配置短信密钥：</label>

                            <div class="col-sm-10">
                                <div class="input-group">
                                    <input id="secretkey_new" type="text" class="form-control" value=${secretkey}>
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-primary" onclick="javascript:toApply();">
                                            申请密钥
                                        </button>
                                    </span>
                                </div>
                                <br>
                            </div>
                        </div>
                    </c:if>

                </form>
            </div>
        </div>
    </div>
</div>
</div>
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

    function toApplyagain() {
        window.location.href = '${pageContext.request.contextPath}/msgSecretkey/queryMsgSecretkey?reqStatus=0';
    }
    function toApply() {
        window.location.href = '${pageContext.request.contextPath}/msgSecretkey/toApply?reqStatus=1&secretkey='+$('#secretkey_new').val();
    }
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/msgsignature/MsgSignature.js"></script>
</body>
</html>
