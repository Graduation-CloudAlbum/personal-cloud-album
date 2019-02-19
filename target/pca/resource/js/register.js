// user
    $("#alertMessage").hide();
    var user_Boolean = false;
    var password_Boolean = false;
    var varconfirm_Boolean = false;
    $("#username").blur(function(){
        var username = $.trim($("#username").val());
        if ((/^[a-z0-9_-]{4,8}$/).test($("#username").val())){
            $.ajax({
                type:"POST",
                url:"/user/isExist",
                data:{"username":username},
                dataType:"json",
                complete:function(result) {
                    if (result.responseText=="error") {
                        $("#user_hint").html("×").css("color","red");
                        user_Boolean = false;
                    } else {
                        $("#user_hint").html("✔").css("color","green");
                        user_Boolean = true;
                    }
                }
            });
        }else {
            $("#user_hint").html("×").css("color","red");
            user_Boolean = false;
        }
    });
// password
    $("#password").blur(function(){
        if ((/^[a-z0-9_-]{6,16}$/).test($("#password").val())){
            $("#password_hint").html("✔").css("color","green");
            password_Boolean = true;
        }else {
            $("#password_hint").html("×").css("color","red");
            password_Boolean = false;
        }
    });


// password_confirm
    $("#password_2").blur(function(){
        if (($("#password").val())!=("")&&($("#password").val())==($("#password_2").val())){
            $("#confirm_hint").html("✔").css("color","green");
            varconfirm_Boolean = true;
        }else {
            $("#confirm_hint").html("×").css("color","red");
            varconfirm_Boolean = false;
        }
    });


// click
$("#reg").click(function(){
    if(user_Boolean && password_Boolean && varconfirm_Boolean == true){
        var username = $.trim($("#username").val());
        var password = $.trim($("#password").val());
            $.ajax({
                type:"POST",
                url:"/user/doRegister",
                data:{"username":username,"password":password},
                dataType: "json",
                complete:function(result) {
                    if (result.responseText=="success") {
                       alert("注册成功");
                        window.location.href="/user/login";
                    } else {
                      alert("注册失败");
                      //$("#alertMessage").show();
                        $("#username").html("");
                        $("#password").html("");
                        $("#password_2").html("");
                    }
                }
            });
    }else {
        alert("请完善信息");
    }
});