function login(){
        var username = $.trim($("#i-input-email").val());
        var password = $.trim($("#i-input-password").val());

    $.ajax({
            async : false,
            type:"post",
            url:"/pca/user/checkLogin",
            data:{"username":username,"password":password},
            dataType: "json",
            complete:function(result) {
                if (result.responseText=="success") {
                    window.location.href="/pca/user/myAlbum";
                }else {
                    alert("用户名或密码错误 请重试");
                    $("#username").val("");
                    $("#password").val("");
                }
            }
        });
}