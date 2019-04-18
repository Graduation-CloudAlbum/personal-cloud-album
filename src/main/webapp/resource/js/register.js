$("#register").click( function (){
    if ($("#i-input-email").val()==""||$("#i-input-password").val()=="") {
        alert("你输入的信息有误");
    }else {
            var username = $.trim($("#i-input-email").val());
            var password = $.trim($("#i-input-password").val());
        $.ajax({
            type:"post",
            url:"/pca/user/doRegister",
            data:{"username":username,"password":password},
            dataType: "json",
            complete:function (result) {
                if (result.responseText=="success") {
                    alert("注册成功，请进入邮箱激活账号");
                    window.location.href="/pca/user/login";
                } else {
                    alert("注册失败,请重试");
                    $("#i-input-password").val("");
                    $("#i-input-email").val("");
                }
            }
        });
    }
});

$(function() {
    jQuery.fn.extend({

        cbEmail: function() {
            var str = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
            var msg = "请输入正确的邮箱";
            blurTest(str, this, msg);
            nullTest(this, msg);
            return this;
        },
        cbPassword: function() {
            var str =/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
            var msg = "请输入正确的密码,6-12位的数字加字母的组合";
            passwordTest(str, this, msg);
            return this;
        }
    });

    function blurTest(str, baseThis, msg) {
        baseThis.each(function() {
            $(this).blur(function() {
                var _thisValue = $(this).val();
                    if(str.test(_thisValue) == false||_thisValue == "" ) {
                        $(this).val("");
                        $(this).attr("placeholder", msg);
                    }

            });
        });

    }

    function nullTest(baseThis, msg) {
        baseThis.each(function() {
            $(this).blur(function() {
                var _thisValue = $(this).val();
                if(_thisValue == "") {
                        $(this).attr("placeholder", msg);
                }
            });
        });

    }

    function passwordTest(str, baseThis, msg) {
        baseThis.each(function() {
            $(this).blur(function() {
                var _thisValue = $(this).val();
                    if(_thisValue == ""||str.test(_thisValue) == false||_thisValue.length<6||_thisValue.length>12) {
                        $(this).val("");
                        $(this).attr("placeholder", msg);
                    }
            });
        });

    }

    })
