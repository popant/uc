<%--
  Created by IntelliJ IDEA.
  User: 宁
  Date: 2016/1/26
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp"%>
<div class="page-bar">
  <ul class="page-breadcrumb">
    <li>
      <i class="fa fa-home"></i>
      <a href="${pageContext.request.contextPath}/index">首页</a>
    </li>
  </ul>
</div>
<div class="portlet light bg-inverse">
  <div class="portlet-title">
    <div class="caption font-purple-plum">
      <i class="icon-speech font-purple-plum"></i>
      <span class="caption-subject bold uppercase"> 开发人员名单</span>
      <span class="caption-helper">感谢他们的辛勤劳动~</span>
    </div>
    <div class="actions">
      <a class="btn btn-circle btn-icon-only btn-default fullscreen" href="javascript:;" data-original-title="" title="">
      </a>
    </div>
  </div>
  <div class="portlet-body">
    <div id="context" data-toggle="context" data-target="#context-menu">
      <p>安宁</p>
      <p>陈宇</p>
      <p>张辰熇</p>
      <p>肖迪</p>
      <p>贾学雷</p>
    </div>
    <!-- Your custom menu with dropdown-menu as default styling -->
    <div id="context-menu">
      <ul class="dropdown-menu" role="menu">
        <li>
          <a href="javascript:;">
            <i class="icon-user"></i> New User </a>
        </li>
        <li>
          <a href="javascript:;">
            <i class="icon-present"></i> New Event <span class="badge badge-success">4</span>
          </a>
        </li>
        <li>
          <a href="javascript:;">
            <i class="icon-basket"></i> New order </a>
        </li>
        <li class="divider">
        </li>
        <li>
          <a href="javascript:;">
            <i class="icon-flag"></i> Pending Orders <span class="badge badge-danger">4</span>
          </a>
        </li>
        <li>
          <a href="javascript:;">
            <i class="icon-users"></i> Pending Users <span class="badge badge-warning">12</span>
          </a>
        </li>
      </ul>
    </div>
  </div>
</div>
<script type="text/javascript">
  function runAnim(persion ,x) {
    persion.removeClass().addClass(x + ' animated').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
      $(this).removeClass();
    });
  };
  var a = 0;
  function iterRun(){
    var thisRun = $('#context').children().eq(a);
    runAnim(thisRun,'bounce');
    a = a+1;
    if(a ==5 ){
      a = 0;
    }
  }
  setInterval(iterRun,500);
</script>
<%@ include file="../common/footer.jsp"%>
