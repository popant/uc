<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML >
<html>
<head>
<!--     <meta charset="utf-8"> -->
<!--     <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->


<!--     <title>短信签名</title> -->

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
                <h5>短信签名管理</h5>
            </div>
            <div class="ibox-content">
                <form method="get" class="form-horizontal">
                    <input type="hidden" id="msgSignatureId" value='${msgSignatureId}'/>
                    <input type="hidden" id="msgSignatureInfo" value='${msgSignatureInfo}'/>
                    <input type="hidden" id="auditStatus" value='${auditStatus}'/>
                    <input type="hidden" id="enterpriseId" value='${enterpriseId}'/>
                    <c:if test="${auditStatus==null}">
                        <td>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">短信签名：</label>

                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <input id="msgSignatureInfo1" type="text" class="form-control">
                                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-primary"
                                                    onclick="javascript:toAudit();">提交审核
                                            </button> </span>
                                    </div>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                        </td>
                    </c:if>

                    <c:if test="${auditStatus=='2'}">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">短信签名：</label>
                            <div class="col-sm-10">
                                <input type="text" disabled="" placeholder=${msgSignatureInfo} class="form-control"><br>
                                <span class="help-block m-b-none">审核中</span>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                    </c:if>

                    <c:if test="${auditStatus=='1'}">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">短信签名：</label>
                            <div class="col-sm-10">
                                <input type="text" disabled="" placeholder=${msgSignatureInfo} class="form-control"><br>
                                <span class="help-block m-b-none">审核通过</span>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                    </c:if>

                    <c:if test="${auditStatus=='0'}">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">短信签名：</label>

                            <div class="col-sm-10">
                                <div class="input-group">
                                    <input id="msgSignatureInfo2" type="text" class="form-control" value=${msgSignatureInfo}> <span
                                        class="input-group-btn"> <button type="button" class="btn btn-primary"
                                                                         onclick="javascript:toAuditAgain();">提交审核
                                </button> </span>
                                </div>
                                <br>
                                <span class="help-block m-b-none">审核失败：您的短信签名与企业认证信息不符，请修改后再提交。</span>
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

    function toAudit() {
        window.location.href = '${pageContext.request.contextPath}/msgSignature/toAudit?msgSignatureInfo=' + $('#msgSignatureInfo1').val();
    }
    function toAuditAgain() {
        window.location.href = '${pageContext.request.contextPath}/msgSignature/toAudit?msgSignatureInfo=' + $('#msgSignatureInfo2').val();
    }
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/msgsignature/MsgSignature.js"></script>
</body>
</html>
