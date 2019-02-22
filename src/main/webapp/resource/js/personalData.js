
//修改资料
//Modifying-data  ModifyingData
var ModifyingData = document.getElementById('ModifyingData');//
ModifyingData.onclick=function(){

    document.getElementById('Modifying-data').style.display="block";
    document.getElementById('popLayer2').style.display="block";

}
//关闭修改资料
var iconChacha4 = document.getElementById('iconChacha4');
iconChacha4.onclick=function(){
    document.getElementById('popLayer2').style.display="none";
    document.getElementById('Modifying-data').style.display="none";
}
var ModifyingDataButton1 = document.getElementById('Modifying-data-button1');
ModifyingDataButton1.onclick=function(){
    document.getElementById('popLayer2').style.display="none";
    document.getElementById('Modifying-data').style.display="none";
}
$(".Modifying-data-button2").click(function() {
    var nick_name=$.trim($("#Modifying-data-input").val());
    var synopsis=$.trim($("#Modifying-data-textarea").val());
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/pca/user/modifyingData",
        data:{"nickName":nick_name,"synopsis":synopsis},
        dataType: "json",
        complete:function(result) {
            if (result.responseText=="success") {
                alert("修改成功");
                window.location.href="http://localhost:8080/pca/user/personalData";
            } else {
                alert("修改失败 请重试");
                $("#Modifying-data-input").val("");
                $("#Modifying-data-textarea").val("");
            }
        }
    });
});
//更换头像
var ChangetheAvatar = document.getElementById('ChangetheAvatar');//
ChangetheAvatar.onclick=function(){
    document.getElementById('Change-the-Avatar').style.display="block";
    document.getElementById('popLayer2').style.display="block";
}
$(".Change-the-Avatar-button1").click(function () {

});
//关闭更换头像
var ChangetheAvatarButton2 = document.getElementById('Change-the-Avatar-button2');
ChangetheAvatarButton2.onclick=function(){
    document.getElementById('popLayer2').style.display="none";
    document.getElementById('Change-the-Avatar').style.display="none";
}
//修改密码
var ChangePassword = document.getElementById('ChangePassword');
ChangePassword.onclick=function(){
    document.getElementById('Change-Password').style.display="block";
    document.getElementById('popLayer2').style.display="block";
}
//关闭修改密码
var iconChacha5 = document.getElementById('iconChacha5');
iconChacha5.onclick=function(){
    document.getElementById('popLayer2').style.display="none";
    document.getElementById('Change-Password').style.display="none";
}
//取消更改密码
var cancel = document.getElementById('Change-Password-button1');
cancel.onclick=function(){
    document.getElementById('popLayer2').style.display="none";
    document.getElementById('Change-Password').style.display="none";
}
//确定更改
$(".Change-Password-button2").click(function () {
    var oldPassword=$.trim($("#Change-Password-input1").val());
    var newPassword1=$.trim($("#Change-Password-input2").val());
    var newPassword2=$.trim($("#Change-Password-input3").val());
    if (newPassword1==newPassword2){
        $.ajax({
            type:"POST",
            url:"/pca/user/changePassword",
            data:{"oldPassword":oldPassword,"newPassword1":newPassword1},
            dataType: "json",
            complete:function(result) {
                if (result.responseText=="success") {
                    alert("修改成功,您的新密码已生效,请重新登录");
                    window.location.href="/pca/user/login";
                } else {
                    alert("您输入的密码有误，请重试");
                    $("#Change-Password-input1").val("");
                    $("#Change-Password-input2").val("");
                    $("#Change-Password-input3").val("");
                }
            }
        });
    } else {
        alert("您输入的两次密码不一致，请重试");
        $("#Change-Password-input1").val("");
        $("#Change-Password-input2").val("");
        $("#Change-Password-input3").val("");
    }
});
//扩充空间
var Expansion = document.getElementById('Expansion');
Expansion.onclick=function(){
    document.getElementById('Buy-Expansion').style.display="block";
    document.getElementById('popLayer2').style.display="block";
}

//关闭扩充空间
var iconChacha6	= document.getElementById('iconChacha6');
iconChacha6.onclick	=function(){
    document.getElementById('popLayer2').style.display="none";
    document.getElementById('Buy-Expansion').style.display="none";
}
//个人简介 账户安全 空间容量
var menuLi1 = document.getElementById('menuLi1');
var menuLi2 = document.getElementById('menuLi2');
var menuLi3 = document.getElementById('menuLi3');
var contentAboutInfoNo1 = document.getElementById('content-about-info-no1');
var contentAboutInfoNo2 = document.getElementById('content-about-info-no2');
var contentAboutInfoNo3 = document.getElementById('content-about-info-no3');
menuLi1.onclick=function() {
    document.getElementById('menuLi1').style.color="#000";
    document.getElementById('menuLi1').style.borderTop="2px solid #D84C31";
    document.getElementById('menuLi2').style.color="#999";
    document.getElementById('menuLi2').style.borderTop="2px solid #fff";
    document.getElementById('menuLi3').style.color="#999";
    document.getElementById('menuLi3').style.borderTop="2px solid #fff";
    contentAboutInfoNo1.style.display="block";
    contentAboutInfoNo2.style.display="none";
    contentAboutInfoNo3.style.display="none";
}
menuLi2.onclick=function() {
    document.getElementById('menuLi2').style.color="#000";
    document.getElementById('menuLi2').style.borderTop="2px solid #D84C31";
    document.getElementById('menuLi1').style.color="#999";
    document.getElementById('menuLi1').style.borderTop="2px solid #fff";
    document.getElementById('menuLi3').style.color="#999";
    document.getElementById('menuLi3').style.borderTop="2px solid #fff";
    contentAboutInfoNo1.style.display="none";
    contentAboutInfoNo2.style.display="block";
    contentAboutInfoNo3.style.display="none";
}
menuLi3.onclick=function() {
    document.getElementById('menuLi3').style.color="#000";
    document.getElementById('menuLi3').style.borderTop="2px solid #D84C31";
    document.getElementById('menuLi2').style.color="#999";
    document.getElementById('menuLi2').style.borderTop="2px solid #fff";
    document.getElementById('menuLi1').style.color="#999";
    document.getElementById('menuLi2').style.borderTop="2px solid #fff";
    contentAboutInfoNo1.style.display="none";
    contentAboutInfoNo2.style.display="none";
    contentAboutInfoNo3.style.display="block";
}
