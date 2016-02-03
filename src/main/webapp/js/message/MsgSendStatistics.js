var a=[];
$.ajax({
    type: "POST",
    url: contextPath+"/mailAddress/queryMailAddressList.do",
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
                        ["序号","企业编号","电话号码","地址","邮编","姓名","创建时间","修改时间"],
                    colModel:
                        [{name:"id",index:"id",editable:true,width:60,sorttype:"int",search:true},
                        {name:"enterpriseId",index:"enterpriseId",editable:true,width:100},
                        {name:"phoneNumber",index:"phoneNumber",editable:true,width:80},
                        {name:"mailAddress",index:"mailAddress",editable:true,width:80},
                        {name:"postalCode",index:"postalCode",editable:true,width:80},
                        {name:"mailName",index:"mailName",editable:true,width:100,sortable:false},
                        {name:"createTime",index:"createTime",editable:true,width:90,sorttype:"date",formatter:"date"},
                        {name:"alterTime",index:"alterTime",editable:true,width:90,sorttype:"date",formatter:"date"}],
                    pager:"#pager_list_2",viewrecords:true,caption:"寄送地址信息列表",add:true,edit:true,addtext:"Add",edittext:"Edit",hidegrid:false});
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

