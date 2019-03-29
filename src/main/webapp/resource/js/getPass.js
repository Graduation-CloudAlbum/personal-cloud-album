$("#getPass").click(function () {
    var email = $.trim($("#i-input-email").val());
    // var password = $.trim($("#i-input-password").val());

    $.ajax({
        async: false,
        type: "post",
        url: "/pca/user/toGetPass",
        data: {"toMail": email},
        dataType: "json",
        complete: function (result) {
            if (result.responseText == "success") {
                // window.location.href = "/pca/user/myAlbum";
                alert("重置邮件已发送到该邮箱，请注意查看");
                $("#i-input-email").val("");
            } else {
                alert("该邮箱不存在，请重试");
                $("#i-input-email").val("");
            }
        }
    });
});