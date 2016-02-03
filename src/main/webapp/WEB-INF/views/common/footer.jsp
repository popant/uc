<%--
  Created by IntelliJ IDEA.
  User: 宁
  Date: 2016/1/26
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
</div>
</div>
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="page-footer">
  <div class="page-footer-inner">
    青牛（北京）技术有限公司© 版权所有 京ICP备10016421号-3
  </div>
  <div class="scroll-to-top">
    <i class="icon-arrow-up"></i>
  </div>
</div>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<!--<script src="${pageContext.request.contextPath}/assets/global/plugins/respond.min.js"></script>-->
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/excanvas.min.js"></script>--%>
<![endif]-->
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>--%>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>--%>
<script src="${pageContext.request.contextPath}/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery.pulsate.min.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-daterangepicker/moment.min.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js" type="text/javascript"></script>--%>
<!-- IMPORTANT! fullcalendar depends on jquery-ui.min.js for drag & drop support -->
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js" type="text/javascript"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>--%>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/jquery-validation/js/additional-methods.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<%-- <script src="${pageContext.request.contextPath}/assets/admin/pages/scripts/table-editable.js"></script> --%>
<%-- <script src="${pageContext.request.contextPath}/assets/admin/pages/scripts/form-wizard.js"></script> --%>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-wizard/jquery.bootstrap.wizard.min.js" type="text/javascript" ></script>
<%-- <script src="${pageContext.request.contextPath}/assets/admin/pages/scripts/inbox.js" type="text/javascript"></script> --%>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.js" type="text/javascript" ></script>
<script src="${pageContext.request.contextPath}/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<%--<script src="${pageContext.request.contextPath}/assets/admin/layout/scripts/demo.js" type="text/javascript"></script>--%>
<script src="${pageContext.request.contextPath}/assets/admin/pages/scripts/index.js" type="text/javascript"></script>
<%--<script src="${pageContext.request.contextPath}/assets/admin/pages/scripts/tasks.js" type="text/javascript"></script>--%>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
  jQuery(document).ready(function() {
    Metronic.init(); // init metronic core componets
    Layout.init(); // init layout
    QuickSidebar.init(); // init quick sidebar
//    Demo.init(); // init demo features
    Index.init();
//    Index.initDashboardDaterange();
//    Index.initJQVMAP(); // init index page's custom scripts
//    Index.initCalendar(); // init index page's custom scripts
//    Index.initCharts(); // init index page's custom scripts
//    Index.initChat();
//    Index.initMiniCharts();
//    Tasks.initDashboardWidget();
//     TableEditable.init();
//     FormWizard.init();
//     Inbox.init();
//      修改默认的校验提示信息
      $.extend($.validator.messages, {
          required: "必选字段",
          remote: "请修正该字段",
          email: "请输入正确格式的电子邮件",
          url: "请输入合法的网址",
          date: "请输入合法的日期",
          dateISO: "请输入合法的日期 (ISO).",
          number: "请输入合法的数字",
          digits: "只能输入整数",
          creditcard: "请输入合法的信用卡号",
          equalTo: "请再次输入相同的值",
          accept: "请输入拥有合法后缀名的字符串",
          maxlength: $.validator.format("请输入一个长度最多是 {0} 的字符串"),
          minlength: $.validator.format("请输入一个长度最少是 {0} 的字符串"),
          rangelength: $.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
          range: $.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
          max: $.validator.format("请输入一个最大为 {0} 的值"),
          min: $.validator.format("请输入一个最小为 {0} 的值")
      });
  });
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
