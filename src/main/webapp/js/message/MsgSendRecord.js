var a=[];
$.ajax({
    type: "POST",
    url: contextPath+"/msgSend/msgSendRecord.do",
    dataType: "json",
    success: function(data) {
        if (data.success) {
            a=data.rows;
            $(document).ready(function(){
                $.jgrid.defaults.styleUI="Bootstrap";
                $("#table_list_2").jqGrid({
                    data: data.rows,
                    datatype: "local",
                    height: 450,
                    autowidth: true,
                    shrinkToFit: true,
                    rowNum: 20,
                    rowList: [10, 20, 30],
                    colNames:
                        ["验证码记录","短信模板","目标号码","下发时间"],
                    colModel:
                        [{name:"verifyCode",index:"verifyCode",editable:true,width:60,sorttype:"int",search:true},
                        {name:"messageTemplate",index:"messageTemplate",editable:true,width:100},
                        {name:"targetNumber",index:"phoneNumber",editable:true,width:80},
                        {name:"sendTime",index:"sendTime",editable:true,width:80}],
                    pager:"#pager_list_2",viewrecords:true,caption:"短信发送记录列表",add:true,edit:true,addtext:"Add",edittext:"Edit",hidegrid:false});
                $("#table_list_2").setSelection(8, true);
                $("#table_list_2").jqGrid("navGrid", "#pager_list_2", {
                    edit: true,
                    add: true,
                    del: true,
                    search: true
                }, {height: 200, reloadAfterSubmit: true});
                $(window).bind("resize", function () {
                    var b = $(".jqGrid_wrapper").width();
                    $("#table_list_2").setGridWidth(b)
                })
            });
        }
        //$.messager.show({
        //    title : '提示',
        //    msg : data.msg
        //});
    }
});

