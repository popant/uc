<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page language="java" import="com.channelsoft.usercenter.message.po.*,java.util.List" %>
<!DOCTYPE HTML >
<html>
<head>

<!--     <meta charset="utf-8"> -->
<!--     <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->


<!--     <title>短信模板管理</title> -->

<%--     <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.4.0" rel="stylesheet"> --%>
<%--     <link href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.3.0" rel="stylesheet"> --%>

    <!-- jqgrid-->
    <link href="${pageContext.request.contextPath}/css/plugins/jqgrid/ui.jqgrid.css@0820" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min.css?v=3.2.0" rel="stylesheet">

    <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>

    <style>
        /* Additional style to fix warning dialog position */

        #alertmod_table_list_2 {
            top: 900px !important;
        }
    </style>
    <%
        List<MessageTemplateInfo> list = (List<MessageTemplateInfo>) request.getAttribute("list");
    %>
</head>

<body>
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>短信模板管理</h5>

                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="table_foo_table.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="table_foo_table.html#">选项 01</a>
                            </li>
                            <li><a href="table_foo_table.html#">选项 02</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">

                    <table class="footable table table-stripped toggle-arrow-tiny" data-page-size="8">
                        <thead>
                        <tr>

                            <th>id</th>
                            <th>模板内容</th>
                            <th>审核信息</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <%
                            for (int i = 0; i < list.size(); i++) {
                        %>
                        <tbody>

                        <tr>
                            <td><%=list.get(i).getMsgtemplateId()%>
                            </td>
                            <td><%=list.get(i).getMessageTemplate()%>
                            </td>
                            <td><%=list.get(i).getAuditInfo()%>
                            </td>
                            <%
                                if(list.get(i).getAuditStatus()==0){

                                }
                            %>
                            <td><i class="fa fa-check text-navy" onclick=""></i> 提交审核</td>
                        </tr>
                        </tfoot>
                        <%
                            }
                        %>
                    </table>

                </div>
            </div>
        </div>
    </div>
</div>
<!-- 全局js -->
<!-- <script src="js/jquery-2.1.1.min.js"></script> -->
<!-- <script src="js/bootstrap.min.js?v=3.4.0"></script> -->
<script src="js/plugins/footable/footable.all.min.js"></script>

<script>
    $(document).ready(function () {

        $('.footable').footable();
        $('.footable2').footable();

    });

</script>

<script type="text/javascript" src="../../../tajs.qq.com/stats@sId=9051096.html" charset="UTF-8"></script>
<!--统计代码，可删除-->

</body>
</html>
