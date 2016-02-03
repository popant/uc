<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE HTML >
<html>
	<head>

<!-- 	<meta charset="utf-8"> -->
<!--         <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->


<!--         <title>发送记录信息</title> -->

<%--         <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.4.0" rel="stylesheet"> --%>
<%--         <link href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.3.0" rel="stylesheet"> --%>

<!--         jqgrid -->
        <link href="${pageContext.request.contextPath}/css/plugins/jqgrid/ui.jqgrid.css@0820" rel="stylesheet">

        <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.min.css?v=3.2.0" rel="stylesheet">

        <script type="text/javascript" >
            var contextPath = "${pageContext.request.contextPath}";
        </script>

        <style>
            /* Additional style to fix warning dialog position */

            #alertmod_table_list_2 {
                top: 900px !important;
            }
        </style>
	</head>

	<body>
		<body class="gray-bg">
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>发送记录信息</h5>
                            </div>
                            <div class="ibox-content">
                                <p>&nbsp;</p>
                                <h4 class="m-t">发送记录信息</h4>


                                <div class="jqGrid_wrapper">
                                    <table id="table_list_2"></table>
                                    <div id="pager_list_2"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 全局js -->
<%--             <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script> --%>
<%--             <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script> --%>

            <!-- Peity -->
            <script src="${pageContext.request.contextPath}/js/plugins/peity/jquery.peity.min.js"></script>

            <!-- jqGrid -->
            <script src="${pageContext.request.contextPath}/js/plugins/jqgrid/i18n/grid.locale-cn.js@0820"></script>
            <script src="${pageContext.request.contextPath}/js/plugins/jqgrid/jquery.jqGrid.min.js@0820"></script>

            <!-- 自定义js -->
            <%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/message/MsgSendRecord.js"></script>--%>

	</body>
</html>
