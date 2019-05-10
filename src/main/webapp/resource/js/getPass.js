function resetPass() {
    var email = $.trim($("#i-input-email").val());
    $.ajax({
        // async: false,
        type: "post",
        url: "/pca/user/resetPass",
        data: {"email": email},
        dataType: "json",
        complete: function (result) {
            if (result.responseText == "success") {
                alert("success")
                // $("#i-input-email").val("");
                // alert("重置密码已发送至您的邮箱，请注意查看");
                // window.location.href = "login";
            } else {
                alert("该邮箱不存在，请重试");
                $("#i-input-email").val("");
            }
        }
    });
};