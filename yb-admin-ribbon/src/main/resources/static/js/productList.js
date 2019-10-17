$(function () {
    //设置类别
    $.ajax({
        type: "POST",
        url: "/category/findList.html",
        data: {
            storeId: 1
        },
        cache: false,
        timeout: 600000,
        dataType: 'json',
        success: function (data) {
            console.log(data);
            var categoryMasterList = data.categoryMasterList;
            if (categoryMasterList) {
                for (var i = 0; i < categoryMasterList.length; i++) {
                    var categoryEntity = categoryMasterList[i];
                    var categoryId = categoryEntity.categoryId;
                    var categoryName = categoryEntity.categoryName;
                    var optionHtml = '<option value="' + categoryId + '">' + categoryName + '</option>';
                    $("#categoryName").append(optionHtml);
                }
            }
            $("#categoryName").val("1");
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
})

//自动编码点击事件
$("#systemCode").change(function () {
    var checkBox = $("#systemCode").is(':checked');
    if (checkBox) {
        $("#customCode").val("123456789");
        $("#customCode").attr("disabled", true);
    } else {
        $("#customCode").val("");
        $("#customCode").attr("disabled", false);
    }
});