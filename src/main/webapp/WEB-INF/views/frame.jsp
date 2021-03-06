<%--
  Created by IntelliJ IDEA.
  User: 宁
  Date: 2016/1/8
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>用户中心</title>
  <link href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
  <script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/jslib/knockout-3.2.0.js"></script>
  <style>
    #main-nav {
      margin-left: 1px;
    }

    #main-nav.my-nav-tabs.nav-stacked > li > a {
      padding: 10px 8px;
      font-size: 12px;
      font-weight: 600;
      color: #4A515B;
      background: #E9E9E9;
      background: -moz-linear-gradient(top, #FAFAFA 0%, #E9E9E9 100%);
      background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#FAFAFA), color-stop(100%,#E9E9E9));
      background: -webkit-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
      background: -o-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
      background: -ms-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
      background: linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
      filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9');
      -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9')";
      border: 1px solid #D5D5D5;
      border-radius: 4px;
    }

    #main-nav.my-nav-tabs.nav-stacked > li > a > span {
      color: #4A515B;
    }

    #main-nav.my-nav-tabs.nav-stacked > li.active > a, #main-nav.my-nav-tabs.nav-stacked > li > a:hover {
      color: #FFF;
      background: #3C4049;
      background: -moz-linear-gradient(top, #4A515B 0%, #3C4049 100%);
      background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#4A515B), color-stop(100%,#3C4049));
      background: -webkit-linear-gradient(top, #4A515B 0%,#3C4049 100%);
      background: -o-linear-gradient(top, #4A515B 0%,#3C4049 100%);
      background: -ms-linear-gradient(top, #4A515B 0%,#3C4049 100%);
      background: linear-gradient(top, #4A515B 0%,#3C4049 100%);
      filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#4A515B', endColorstr='#3C4049');
      -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#4A515B', endColorstr='#3C4049')";
      border-color: #2B2E33;
    }

    #main-nav.my-nav-tabs.nav-stacked > li.active > a, #main-nav.my-nav-tabs.nav-stacked > li > a:hover > span {
      color: #FFF;
    }

    #main-nav.my-nav-tabs.nav-stacked > li {
      margin-bottom: 4px;
    }

    /*定义二级菜单样式*/
    .secondmenu a {
      font-size: 10px;
      color: #4A515B;
      text-align: center;
    }

    .navbar-static-top {
      background-color: #212121;
      margin-bottom: 5px;
    }

    .navbar-brand {
      background: url('') no-repeat 10px 8px;
      display: inline-block;
      vertical-align: middle;
      padding-left: 50px;
      color: #fff;
    }
    .main-right {
      position : absolute;
      top : 50px;
      left : 220px;
      right : 0px;
      bottom : 0;
    }
    iframe {
      border : 0;
      height : 99%;
      width : 100%;
    }
  </style>
  <script type="text/javascript">
//    var menuList = eval([
//      {id:1,menuName:'用户管理',menuHost:'http://www.baidu.com',menuUrl:'/',subMenuList:[{id:1,menuName:'子菜单1',menuHost:'http://www.baidu.com',menuUrl:'/'}]},
//      {id:2,menuName:'用户管理1',menuHost:'http://www.baidu.com',menuUrl:'/',subMenuList:[{id:2,menuName:'子菜单1',menuHost:'http://www.baidu.com',menuUrl:'/'}]},
//      {id:3,menuName:'用户管理2',menuHost:'http://www..baiducom',menuUrl:'/',subMenuList:[]}
//    ]);
    var menuList = eval(${menuList});
    jQuery(function(){
      var MenuModel = function(){
        var that = this;
        this.currentLeftMenu = ko.observable();
        this.items = ko.observableArray(menuList);
        this.clickLogout = function(data, event) {
          window.location.href = contextPath+"/privilege/loginController/loginout.do";
        };
        this.clickLeftMenu = function(data) {
          that.currentLeftMenu(data);
          var url = data.menuHost + data.menuUrl;
          $("#right iframe").attr("src", url);
        };
      }
      ko.applyBindings(new MenuModel());
    });
function handleAttr(id){
      return '#'+id;
    }
  </script>
</head>
<body>
<div class="navbar navbar-duomi navbar-static-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#" id="logo">此处乃是官网导航栏
      </a>
    </div>
  </div>
</div>
<div class="container-fluid">
  <%--此处是左侧菜单栏--%>
  <div class="row">
    <div class="col-md-2">
      <ul id="main-nav" data-bind="foreach:{ data: items,as:'menu'}" class="nav my-nav-tabs nav-stacked" style="">
        <li>
          <a data-bind="attr:{href:handleAttr(menu.menuId)}" class="nav-header collapsed" data-toggle="collapse">
            <i class="glyphicon glyphicon-cog"></i>
            <span data-bind="text: menu.menuName"></span>
            <!-- ko if: menu.subMenuList && menu.subMenuList.length>0 -->
            <span data-bind="if: menu.subMenuList" class="pull-right glyphicon glyphicon-chevron-down"></span>
            <!-- /ko -->
          </a>
          <ul  data-bind="foreach:{ data: menu.subMenuList,as : 'subMenu'},attr:{id:menu.menuId}" class="nav nav-list collapse secondmenu" style="height: 0px;">
            <li data-bind="click:$root.clickLeftMenu"><a href="#"><i data-bind="text:subMenu.menuName" class="glyphicon glyphicon-user"></i></a></li>
          </ul>
        </li>
      </ul>
      <a href="${pageContext.request.contextPath}/logout">登出</a>
      <!--<ul id="main-nav" class="nav my-nav-tabs nav-stacked" style="">-->
      <!--<li class="active">-->
      <!--<a href="#">-->
      <!--<i class="glyphicon glyphicon-th-large"></i>-->
      <!--首页-->
      <!--</a>-->
      <!--</li>-->
      <!--<li>-->
      <!--<a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">-->
      <!--<i class="glyphicon glyphicon-cog"></i>-->
      <!--系统管理-->
      <!--<span class="pull-right glyphicon glyphicon-chevron-down"></span>-->
      <!--</a>-->
      <!--<ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">-->
      <!--<li><a href="#"><i class="glyphicon glyphicon-user"></i>用户管理</a></li>-->
      <!--<li><a href="#"><i class="glyphicon glyphicon-th-list"></i>菜单管理</a></li>-->
      <!--<li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>角色管理</a></li>-->
      <!--<li><a href="#"><i class="glyphicon glyphicon-edit"></i>修改密码</a></li>-->
      <!--<li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>日志查看</a></li>-->
      <!--</ul>-->
      <!--</li>-->
      <!--<li>-->
      <!--<a href="./plans.html">-->
      <!--<i class="glyphicon glyphicon-credit-card"></i>-->
      <!--物料管理-->
      <!--</a>-->
      <!--</li>-->

      <!--<li>-->
      <!--<a href="./grid.html">-->
      <!--<i class="glyphicon glyphicon-globe"></i>-->
      <!--分发配置-->
      <!--<span class="label label-warning pull-right">5</span>-->
      <!--</a>-->
      <!--</li>-->

      <!--<li>-->
      <!--<a href="./charts.html">-->
      <!--<i class="glyphicon glyphicon-calendar"></i>-->
      <!--图表统计-->
      <!--</a>-->
      <!--</li>-->
      <!--<li>-->
      <!--<a href="#">-->
      <!--<i class="glyphicon glyphicon-fire"></i>-->
      <!--关于系统-->
      <!--</a>-->
      <!--</li>-->

      <!--</ul>-->
    </div>
    <div id="right" class="main-right">
      <iframe src=""></iframe>
    </div>
  </div>
</div>
</body>
</html>
