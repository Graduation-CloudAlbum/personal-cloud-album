$("#i-input-email").focusout (function(){
    // $("#i-input-email").css("background-color","#FFFFCC");

    var username = $.trim($("#i-input-email").val());
    var password = $.trim($("#i-input-password").val());
    var reg1 = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/gi;
    var reg2=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
    //非空验证
    if (username== ""||username==null) {
        $("#i-input-email").html("请输入电子邮箱").css("background-color","#FF0000");
        return false;
    }
    //邮箱格式验证
     else if (!reg1.test(username)) {
        // alert("邮件格式不正确，请重新输入!");
        $("#i-input-email").val("邮件格式不正确，请重新输入").css("background-color","#FF0000");
        return false;
    }

   // else if(!reg2.test(password)||password.length<6||password.length>12) {
   //      // alert("密码必须为6-12位的数字和字母的组合");
   //      $("#i-input-password").val("密码必须为6-12位的数字和字母的组合").css("background-color","#FF0000");
   //      return false;
   //  }
   // else{
   //
   //  }

});
$("#i-input-password").focusout(function(){
    var password = $.trim($("#i-input-password").val());
    var reg2=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
    if(!reg2.test(password)||password.length<6||password.length>12) {
        // alert("密码必须为6-12位的数字和字母的组合");
        $("#i-input-password").val("密码必须为6-12位的数字和字母的组合").css("background-color","#FF0000");
        return false;
    }
});
    function register(){
        var username = $.trim($("#i-input-email").val());
        var password = $.trim($("#i-input-password").val());
           $.ajax({
               type:"post",
               sync:false,
               url:"/pca/user/doRegister",
               data:{"username":username,"password":password},
               dataType: "json",
               success:function(data) {
                   if (data=="success") {
                       alert("注册成功,请到邮箱内激活账号");
                        window.location.href="/pca/user/login";
                   } else {
                       alert("注册失败,该邮箱已被注册");
                       $("#i-input-password").val("");
                       $("#i-input-email").val("");
                   }
               }
           });
    }

// click
// $("#reg").click(function(){
//     if(user_Boolean && password_Boolean && varconfirm_Boolean == true){
//         var username = $.trim($("#username").val());
//         var password = $.trim($("#password").val());
//             $.ajax({
//                 type:"POST",
//                 url:"/pca/user/doRegister",
//                 data:{"username":username,"password":password},
//                 dataType: "json",
//                 success:function(data) {
//                     alert(data);
//                     if (data=="success") {
//                        alert("注册成功");
//                         window.location.href="/pca/user/login";
//                     } else {
//                       alert("注册失败,该用户名已存在");
//                       //$("#alertMessage").show();
//                         $("#username").html("");
//                         $("#password").html("");
//                         $("#password_2").html("");
//                     }
//                 }
//             });
//     }
//     // else {
//     //     alert("请完善信息");
//     // }
// });