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
    //设置供应商
    $.ajax({
        type: "POST",
        url: "/supplier/findList.html",
        data: {
            storeId: 1
        },
        cache: false,
        timeout: 600000,
        dataType: 'json',
        success: function (data) {
            console.log(data);
            var supplierMasterList = data.supplierMasterList;
            if (supplierMasterList) {
                for (var i = 0; i < supplierMasterList.length; i++) {
                    var supplierEntity = supplierMasterList[i];
                    var supplierId = supplierEntity.supplierId;
                    var supplierName = supplierEntity.supplierName;
                    var optionHtml = '<option value="' + supplierId + '">' + supplierName + '</option>';
                    $("#supplierName").append(optionHtml);
                }
            }
            $("#supplierName").val("1");
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
    //设置单位
    $.ajax({
        type: "POST",
        url: "/unit/findList.html",
        data: {
            storeId: 1
        },
        cache: false,
        timeout: 600000,
        dataType: 'json',
        success: function (data) {
            console.log(data);
            var unitMasterList = data.unitMasterList;
            if (unitMasterList) {
                for (var i = 0; i < unitMasterList.length; i++) {
                    var unitEntity = unitMasterList[i];
                    var unitId = unitEntity.unitId;
                    var unitName = unitEntity.unitName;
                    var optionHtml = '<option value="' + unitId + '">' + unitName + '</option>';
                    $("#unitName").append(optionHtml);
                }
            }
            $("#unitName").val("1");
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
    //设置颜色
    $.ajax({
        type: "POST",
        url: "/color/findList.html",
        data: {
            storeId: 1
        },
        cache: false,
        timeout: 600000,
        dataType: 'json',
        success: function (data) {
            console.log(data);
            var colorMasterList = data.colorMasterList;
            if (colorMasterList) {
                for (var i = 0; i < colorMasterList.length; i++) {
                    var colorEntity = colorMasterList[i];
                    var colorId = colorEntity.colorId;
                    var colorName = colorEntity.colorName;
                    var optionHtml = '<option value="' + colorId + '">' + colorName + '</option>';
                    $("#colorName").append(optionHtml);
                }
            }
            $("#colorName").val("1");
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
    //设置尺码
    $.ajax({
        type: "POST",
        url: "/size/findList.html",
        data: {
            storeId: 1
        },
        cache: false,
        timeout: 600000,
        dataType: 'json',
        success: function (data) {
            console.log(data);
            var sizeMasterList = data.sizeMasterList;
            if (sizeMasterList) {
                for (var i = 0; i < sizeMasterList.length; i++) {
                    var sizeEntity = sizeMasterList[i];
                    var sizeId = sizeEntity.sizeId;
                    var sizeName = sizeEntity.sizeName;
                    var optionHtml = '<option value="' + sizeId + '">' + sizeName + '</option>';
                    $("#sizeName").append(optionHtml);
                }
            }
            $("#sizeName").val("1");
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
    //设置品牌
    $.ajax({
        type: "POST",
        url: "/brand/findList.html",
        data: {
            storeId: 1
        },
        cache: false,
        timeout: 600000,
        dataType: 'json',
        success: function (data) {
            console.log(data);
            var brandMasterList = data.brandMasterList;
            if (brandMasterList) {
                for (var i = 0; i < brandMasterList.length; i++) {
                    var brandEntity = brandMasterList[i];
                    var brandId = brandEntity.brandId;
                    var brandName = brandEntity.brandName;
                    var optionHtml = '<option value="' + brandId + '">' + brandName + '</option>';
                    $("#brandName").append(optionHtml);
                }
            }
            $("#brandName").val("1");
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

});


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

//编码校验
function checkCoding() {
    var customCodeStr = $("#customCode").val();
    if (customCodeStr.length > 0) {
        //请求验证
        $.ajax({
            type: "POST",
            url: "/product/findList.html",
            data: {
                storeId: 1,
                customCode: customCodeStr
            },
            cache: false,
            timeout: 600000,
            dataType: 'json',
            success: function (data) {
                console.log(data);
                var productMasterList = data.productMasterList;
                if (productMasterList != null && productMasterList.length > 0) {
                    alert("校验失败")
                } else {
                    alert("校验通过")
                }
            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });
    } else {
        alert("商品编码不能为空")
    }

}

//提交
function submit() {
    var categoryId = $("#categoryName").val();
    var supplierId = $("#supplierName").val();
    var unitId = $("#unitName").val();
    var colorId = $("#colorName").val();
    var sizeId = $("#sizeName").val();
    var brandId = $("#brandName").val();

    var customCode = $("#customCode").val();
    var productName = $("#productName").val();
    var integralCheckBox = $("#isIntegral").is(':checked');
    var isIntegral = integralCheckBox ? "Y" : "N";
    var discountCheckBox = $("#isDiscount").is(':checked');
    var isDiscount = discountCheckBox ? "Y" : "N";
    var productStatus = parseInt($('input[name=status][checked]').val());
    var seasonName = $("#season").val();
    var years = $("#years").val();
    var productionTime = $("#productionTime").val();
    var purchasePrice = $("#purchasePrice").val();
    var retailPrice = $("#retailPrice").val();
    var memberPrice = $("#memberPrice").val();
    var transferPrice = $("#transferPrice").val();
    var websitePrice = $("#websitePrice").val();
    var wholesalePrice = $("#wholesalePrice").val();

    //设置品牌
    $.ajax({
        type: "POST",
        url: "/product/doInsert",
        data: {
            categoryId: categoryId,
            storeId: 1,
            customCode: customCode,
            supplieId: supplierId,
            productName: productName,
            unitId: unitId,
            isIntegral: isIntegral,
            isDiscount: isDiscount,
            productStatus: productStatus,
            colorId: colorId,
            sizeId: sizeId,
            brandsId: brandId,
            seasonName: seasonName,
            productionTime: productionTime,
            purchasePrice: purchasePrice,
            retailPrice: retailPrice,
            memberPrice: memberPrice,
            transferPrice: transferPrice,
            websitePrice: websitePrice,
            wholesalePrice: wholesalePrice
        },
        cache: false,
        timeout: 600000,
        dataType: 'json',
        success: function (data) {
            console.log(data);
            var productId = data.productId;
            if (productId > 0) {
                alert("添加成功")
            } else {
                alert(data.message)
            }
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

}