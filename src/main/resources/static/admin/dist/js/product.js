// $(function () {
//     $("#jqGrid").jqGrid({
//         url: '/admin/products/list',
//         datatype: "json",
//         colModel: [
//             {label: '商品ID', name: 'productID', index: 'productID', width: 50, key: true},
//             {label: '商品名称', name: 'productName', index: 'productName', width: 140},
//             {label: '商品组ID', name: 'productGroupID', index: 'productGroupID', width: 120},
//             {label: '商品组名称', name: 'productGroupName', index: 'productGroupName', width: 60},
//             {label: '销售状态', name: 'salesStatus', index: 'salesStatus', width: 60},
//             {label: '开发员工工号', name: 'developerEmployeeNumber', index: 'developerEmployeeNumber', width: 60},
//             {label: '开发员工姓名', name: 'productDeveloper', index: 'productDeveloper', width: 90},
//             {label: '上架日期', name: 'listingDate', index: 'listingDate', width: 90},
//             {label: '市场ID', name: 'productMarketID', index: 'productMarketID', width: 90},
//             {label: '市场唯一ID', name: 'marketUniqueID', index: 'marketUniqueID', width: 90},
//             {label: '供应商ID', name: 'supplierID', index: 'supplierID', width: 90},
//             {label: '店铺ID', name: 'shopID', index: 'shopID', width: 90},
//         ],
//         height: 700,
//         rowNum: 10,
//         rowList: [10, 20, 50],
//         styleUI: 'Bootstrap',
//         loadtext: '信息读取中...',
//         rownumbers: false,
//         rownumWidth: 20,
//         autowidth: true,
//         multiselect: true,
//         pager: "#jqGridPager",
//         jsonReader: {
//             root: "data.list",
//             page: "data.currPage",
//             total: "data.totalPage",
//             records: "data.totalCount"
//         },
//         prmNames: {
//             page: "page",
//             rows: "limit",
//             order: "order",
//         },
//         gridComplete: function () {
//             //隐藏grid底部滚动条
//             $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
//         }
//     });
//
//     $(window).resize(function () {
//         $("#jqGrid").setGridWidth($(".card-body").width());
//     });
// });


$(function () {
    $("#jqGrid").jqGrid({
        url: '/admin/products/list',
        datatype: "json",
        colModel: [
            {label: '商品ID', name: 'productID', index: 'productID', width: 200, key: true},
            {label: '商品名称', name: 'productName', index: 'productName', width: 200},
            {label: '商品组ID', name: 'productGroupID', index: 'productGroupID', width: 200},
            {label: '商品组名称', name: 'productGroupName', index: 'productGroupName', width: 200},
            {label: '销售状态', name: 'salesStatus', index: 'salesStatus', width: 200},
            {label: '开发员工工号', name: 'developerEmployeeNumber', index: 'developerEmployeeNumber', width: 200},
            {label: '开发员工姓名', name: 'productDeveloper', index: 'productDeveloper', width: 200},
            {label: '上架日期', name: 'listingDate', index: 'listingDate', width: 200},
            {label: '市场ID', name: 'productMarketID', index: 'productMarketID', width: 200},
            {label: '市场唯一ID', name: 'marketUniqueID', index: 'marketUniqueID', width: 200},
            {label: '供应商ID', name: 'supplierID', index: 'supplierID', width: 200},
            {label: '店铺ID', name: 'shopID', index: 'shopID', width: 200},
        ],
        height: 700,
        rowNum: 10,
        width: $(".card-body").width(),
        rowList: [10, 20, 50],
        styleUI: 'Bootstrap',
        loadtext: '信息读取中...',
        rownumbers: false,
        rownumWidth: 20,
        autowidth: false, // Changed this to false
        shrinkToFit: false, // Added this line
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "data.list",
            page: "data.currPage",
            total: "data.totalPage",
            records: "data.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order",
        },
        gridComplete: function () {
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "scroll"}); // Changed this from "hidden" to "scroll"
        }
    });

    $(window).resize(function () {
        $("#jqGrid").setGridWidth($(".card-body").width());
    });
});


/**
 * 搜索功能
 */
function search() {
    //标题关键字
    var keyword = $('#keyword').val();
    if (!validLength(keyword, 20)) {
        swal("搜索字段长度过大!", {
            icon: "error",
        });
        return false;
    }
    //数据封装
    var searchData = {keyword: keyword};
    //传入查询条件参数
    $("#jqGrid").jqGrid("setGridParam", {postData: searchData});
    //点击搜索按钮默认都从第一页开始
    $("#jqGrid").jqGrid("setGridParam", {page: 1});
    //提交post并刷新表格
    $("#jqGrid").jqGrid("setGridParam", {url: '/admin/blogs/list'}).trigger("reloadGrid");
}

/**
 * jqGrid重新加载
 */
function reload() {
    var page = $("#jqGrid").jqGrid('getGridParam', 'page');
    $("#jqGrid").jqGrid('setGridParam', {
        page: page
    }).trigger("reloadGrid");
}

// function addBlog() {
//     window.location.href = "/admin/blogs/edit";
// }

// function editBlog() {
//     var id = getSelectedRow();
//     if (id == null) {
//         return;
//     }
//     window.location.href = "/admin/blogs/edit/" + id;
// }

// function deleteBlog() {
//     var ids = getSelectedRows();
//     if (ids == null) {
//         return;
//     }
//     swal({
//         title: "确认弹框",
//         text: "确认要删除数据吗?",
//         icon: "warning",
//         buttons: true,
//         dangerMode: true,
//     }).then((flag) => {
//             if (flag) {
//                 $.ajax({
//                     type: "POST",
//                     url: "/admin/blogs/delete",
//                     contentType: "application/json",
//                     data: JSON.stringify(ids),
//                     success: function (r) {
//                         if (r.resultCode == 200) {
//                             swal("删除成功", {
//                                 icon: "success",
//                             });
//                             $("#jqGrid").trigger("reloadGrid");
//                         } else {
//                             swal(r.message, {
//                                 icon: "error",
//                             });
//                         }
//                     }
//                 });
//             }
//         }
//     );
// }