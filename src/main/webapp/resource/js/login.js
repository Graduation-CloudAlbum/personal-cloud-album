$("#loginButton").click(function () {
    var username = $.trim($("#i-input-email").val());
    var password = $.trim($("#i-input-password").val());

    $.ajax({
        async: false,
        type: "post",
        url: "/pca/user/checkLogin",
        data: {"username": username, "password": password},
        dataType: "json",
        complete: function (result) {
            if (result.responseText == "success") {
                //进入相册
                window.location.href = "/pca/user/myAlbum";
            } else {
                alert("用户名或密码错误 请重试");
                $("#i-input-email").val("");
                $("#i-input-password").val("");
            }
        }
    });
});