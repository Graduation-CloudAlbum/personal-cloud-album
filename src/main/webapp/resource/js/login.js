$("#login_btn").click(function(){
        var username = $.trim($("#username").val());
        var password = $.trim($("#password").val());
        $.ajax({
            type:"post",
            url:"/pca/user/checkLogin",
            data:{"username":username,"password":password},
            dataType: "json",
            complete:function(result) {
                if (result.responseText=="success") {
                    window.location.href="/pca/album/albumInfo";
                } else {
                    alert("用户名或密码错误 请重试");
                    $("#username").val("");
                    $("#password").val("");
                }
            }
        });
});