<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/jslib/jquery-1.8.0.min.js"></script>
<script src="${pageContext.request.contextPath}/jslib/knockout-3.2.0.js"></script>
<style>
#menu{width:100%; overflow:hidden; margin:20px auto;border:0px solid;}
#menu #nav {display:block;width:100%;padding:0;margin:0;list-style:none;}
#menu #nav li {float:left;width:50%;}
#menu #nav li a {display:block;line-height:27px;text-decoration:none;padding:0 0 0 5px; text-align:center; color:#333;}
#menu_con{ width:85%;  border-top:none}
.tag{ padding:10px; overflow:hidden;}
.unselected{background:#e0dada; color:#fff;}
.selected{background:#28c6ee; color:#fff;}
</style>
<script type="text/javascript">
function saveSum(){
	var inputVal = $("#invoiceSum").val();
	$("#hddenInvoiceSum").val(inputVal);
	document.getElementById("tag1").style.display="none";
	document.getElementById("m1").className="unselected";
	document.getElementById("tag2").style.display="block";
	document.getElementById("m2").className="selected";
}

var APP = {};
APP.viewModel = function() {
	var self = this;
	this.canEdit = ko.dependentObservable(function(){
		if('${canEdit}'=='true'){
			return true;
		}else{
			return false;
		}
	});
	
	
}

$(function() {
    APP.vm = new APP.viewModel();
    ko.applyBindings(APP.vm);
});
</script>
</head>
<body>
  <h3 style="background-color: #e0dada;">
发票索取</h3>
<form action="saveRecord" method="post">
<!--代码部分begin-->
<div id="menu">
<!--tag标题-->
    <ul id="nav">
        <li><a id="m1" href="#" class="selected">1.开票订单、月结算单选择</a></li>
        <li><a id="m2" href="#" class="unselected">2.确定发票信息和地址</a></li>
    </ul>
<!--二级菜单-->
    <div id="menu_con">
        <div id="tag1" class="tag" style="display:block">
            <table border="0" style="margin: 1em; padding: 1em; border-collapse: collapse;  width: 100%;">
   <colgroup>
     <col></col>
     <col></col>
     <col></col>
   </colgroup>
   <tbody>
     <tr>
       <td style="text-align: right;">
         待开发票金额:</td>
       <td>
         ${maxInvoiceNum }</td>
       <td>
         &nbsp;</td>
     </tr>
     <tr>
       <td style="text-align: right;">
         开票金额:</td>
       <td>
         &nbsp;<input name="invoiceSum" ></input>
</td>
       <td>
         &nbsp;<input type="button" value="索取发票" onclick="saveSum()" data-bind="visible : canEdit">
</td>
     </tr>
   </tbody>
 </table>
         </div> 
        <div id="tag2" class="tag" style="display:none">
            <table border="0" style="border-collapse: collapse; table-layout: fixed; width: 100%;">
   <colgroup>
     <col></col>
     <col></col>
     <col></col>
   </colgroup>
   <tbody>
   <tr>
       <td style="text-align: right;" class="right">
         邮寄地址:</td>
       <td>
         <input type="hidden" id="hddenInvoiceSum">
         <select name="addressId">
             <c:forEach var="address" items="${addressList }"> 
               <option value=${address.id}>${address.mailAddress}</option>
             </c:forEach>
            </select>
       </td>
       <td>
         &nbsp;</td>
     </tr>
     <tr>
       <td style="text-align: right;" class="right">
         开具类型:</td>
       <td>
         <span>${invoiceInfo.invoiceKind.desc }</span>
       </td>
       <td>
         &nbsp;</td>
     </tr>
     <tr>
       <td style="text-align: right;" class="right">
         发票抬头:</td>
       <td>
       </div>
         <span>${invoiceInfo.invoiceTitle }</span>
       </div>
       </td>
       <td>
       </td>
     </tr>
     <tr>
       <td style="text-align: right;" class="right">
         发票类型:</td>
       <td>
          <span>${invoiceInfo.invoiceType.desc }</span>
         </td>
       <td>
</td>
     </tr>
     <c:if test="${ invoiceInfo.invoiceType.value==1}">
     <tr>
       <td style="text-align: right;" class="right">
         税务登记证号:</td>
       <td>
         <span>${invoiceInfo.taxRegistrationNumber }</span>
</td>
       <td>
         &nbsp;</td>
     </tr>
     <tr>
       <td style="text-align: right;" class="right">
         基本开户银行名称:</td>
       <td>
         <span>${invoiceInfo.basicAccountBankName }</span>
       </td>
       <td>
         &nbsp;</td>
     </tr>
     <tr>
       <td style="text-align: right;" class="right">
         基本开户账号:</td>
       <td>
         <span>${invoiceInfo.basicAccountNumber }</span>
       </td>
       <td>
         &nbsp;</td>
     </tr>
     <tr>
       <td style="text-align: right;" class="right">
         注册场所地址:</td>
       <td>
         <span>${invoiceInfo.registerPlaceAddress }</span>
       </td>
       <td>
         &nbsp;</td>
     </tr>
     <tr>
       <td style="text-align: right;" class="right">
         注册固定电话:</td>
       <td>
         <span>${invoiceInfo.registerTel }</span>
</td>
       <td>
         &nbsp;</td>
     </tr>
     <tr>
       <td style="text-align: right;" class="right">
         营业执照复印件:</td>
       <td>
       <a href="${pageContext.request.contextPath}/invoice/preview/b" >预览</a>
</td>
       <td>
         &nbsp;</td>
     </tr>
     <tr>
       <td style="text-align: right;" class="right">
         税务登记复印件:</td>
       <td>
       <a href="${pageContext.request.contextPath}/invoice/preview/t" >预览</a>
</td>
       <td>
         &nbsp;</td>
     </tr>
     <tr>
       <td style="text-align: right;" class="right">
         一般纳税人资格认证复印件:</td>
       <td>
       <a href="${pageContext.request.contextPath}/invoice/preview/g" >预览</a>
</td>
       <td>
         &nbsp;</td>
     </tr>
     </c:if>
     <tr>
       <td>
         &nbsp;</td>
       <td>
         &nbsp;<input type="submit"  value="提交" data-bind="visible : canEdit"></input>
</td>
       <td>
         &nbsp;</td>
     </tr>
   </tbody>
 </table>
         </div> 
   </div>
</div>
</form>
<script>
var tabs=function(){
    function tag(name,elem){
        return (elem||document).getElementsByTagName(name);
    }
    //获得相应ID的元素
    function id(name){
        return document.getElementById(name);
    }
    function first(elem){
        elem=elem.firstChild;
        return elem&&elem.nodeType==1? elem:next(elem);
    }
    function next(elem){
        do{
            elem=elem.nextSibling;  
        }while(
            elem&&elem.nodeType!=1  
        )
        return elem;
    }
    return {
        set:function(elemId,tabId){
            var elem=tag("li",id(elemId));
            var tabs=tag("div",id(tabId));
            var listNum=elem.length;
            var tabNum=tabs.length;
            for(var i=0;i<listNum;i++){
                    elem[i].onclick=(function(i){
                        return function(){
                            for(var j=0;j<tabNum;j++){
                                if(i==j){
                                    tabs[j].style.display="block";
                                    //alert(elem[j].firstChild);
                                    elem[j].firstChild.className="selected";
                                }
                                else{
                                    tabs[j].style.display="none";
                                    elem[j].firstChild.className="unselected";
                                }
                            }
                        }
                    })(i)
           }
        }
    }
}();
tabs.set("nav","menu_con");//执行
</script>
<!--代码部分end-->
<h>${msg }</h>
<h><font color="red">${err }</font>
<h><font color="red">${invoiceInfo==null?"您还没有配置发票信息!":"" }</font></h>

</body>
</html>