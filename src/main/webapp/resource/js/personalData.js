
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
        url:"/pca/user/modifyingData",
        data:{"nickName":nick_name,"synopsis":synopsis},
        dataType: "json",
        complete:function(result) {
            if (result.responseText=="success") {
                alert("修改成功");
                window.location.href="/pca/user/personalData";
                // window.location.href = window.location.href;
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
//点击“更换头像”(点击按钮)
var image = '';
function selectImage(file) {
    if (!file.files || !file.files[0]) {
        return;
    }
    var reader = new FileReader();
    reader.onload = function (evt) {
        document.getElementById('image').src = evt.target.result;
        image = evt.target.result;
    }
    reader.readAsDataURL(file.files[0]);
}
$("#img0").change(function () {
    var oFiles = document.getElementById("img0").files;
    var params = new FormData();
    params.append('file',oFiles[0]);
    $.ajax({
        type:'post',
        async:false,
        url:'/pca/user/changeIcon',
        data:params,
        cache: false,
        contentType: false,
        processData: false,
        success:function(data){
            window.location.href="/pca/user/personalData";
            window.location.href = window.location.href;
        }
    });

});
//点击更换头像（点击头像）
var image2 = '';
function selectImage2(file) {
    if (!file.files || !file.files[0]) {
        return;
    }
    var reader = new FileReader();
    reader.onload = function (evt) {
        document.getElementById('image2').src = evt.target.result;
        image2 = evt.target.result;
    }
    reader.readAsDataURL(file.files[0]);
}
//在个人信息页面点击“头像”实现更换头像
$("#img2").change(function () {
    var oFiles = document.getElementById("img2").files;
    var params = new FormData();
    params.append('file',oFiles[0]);
    $.ajax({
        type:'post',
        async:false,
        url:'/pca/user/changeIcon',
        data:params,
        cache: false,
        contentType: false,
        processData: false,
        success:function(data){
            window.location.href="/pca/user/personalData";
            window.location.href = window.location.href;
        }
    });

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
//确定修改密码
$(".Change-Password-button2").click(function () {
    var oldPassword=$.trim($("#input1").val());
    var newPassword1=$.trim($("#input2").val());
    var newPassword2=$.trim($("#input3").val());
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
                    $("#input1").val("");
                    $("#input2").val("");
                    $("#input3").val("");
                }
            }
        });
    } else {
        alert("您输入的两次密码不一致，请重试");
        $("#input1").val("");
        $("#input2").val("");
        $("#input3").val("");
    }
});
//扩充空间
var Expansion = document.getElementById('Expansion');
Expansion.onclick=function(){
    document.getElementById('Buy-Expansion').style.display="block";
    document.getElementById('popLayer2').style.display="block";
    // $("input[type='radio']").removeAttr('checked');
}
//自定义购买
var BuyExpansion2 = document.getElementById('Buy-Expansion2');
var custom = document.getElementById('custom');
var standard = document.getElementById('standard');
var BuyExpansion = document.getElementById('Buy-Expansion');
custom.onclick=function(){
	BuyExpansion2.style.display="block";
	BuyExpansion.style.display="none";
}
standard.onclick=function(){
	BuyExpansion2.style.display="none";
	BuyExpansion.style.display="block";
}



function sum(obj) {
	var z = document.getElementById("z");  
	var value=z.value;
    var min=1;
    var max=999;
    if(parseInt(value)<min||parseInt(value)>max){
        alert('最大输入为800G');
        z.value=1;
    }
	if(z.value>=100){
		all.value=parseInt(z.value)*0.5;
	}  
	else if(z.value>=50){
		all.value=parseInt(z.value)*0.7;
	}
	else{
		all.value=parseInt(z.value);
	}

	
//	if(a.value!='')
//	{
//	y.value=parseInt(a.value);
//	h.value=parseInt(z.value)-parseInt(a.value);
//	}
//	if(a.value!=''&&b.value!='')
//	{
//	y.value=parseInt(b.value)+parseInt(a.value);
//	h.value=parseInt(z.value)-parseInt(a.value)-parseInt(b.value);
//	}
//	if(a.value!=''&&b.value!=''&&c.value!='')
//	{
//	y.value=parseInt(b.value)+parseInt(a.value)+parseInt(c.value);
//	h.value=parseInt(z.value)-parseInt(a.value)-parseInt(b.value)-parseInt(c.value);
//	}
 }
//自定义购买
function purchase(){
    var z = document.getElementById("z");
    var all = document.getElementById("all");
    // var meal=z.value;
    // var fee=all.value;
    var meal=z.value+"&"+all.value;
    window.location.href="/pca/alipay/goConfirm/"+meal;
}



//获取用户选择的套餐
$("#Buy-Expansion-button2").click(function () {
    var meal=$("input[type='radio']:checked").val();
    window.location.href="/pca/alipay/goConfirm/"+meal;
});
//关闭扩充空间
var iconChacha6	= document.getElementById('iconChacha6');
iconChacha6.onclick	=function(){
    document.getElementById('popLayer2').style.display="none";
    document.getElementById('Buy-Expansion').style.display="none";

}
var iconChacha7	= document.getElementById('iconChacha7');
iconChacha7.onclick	=function(){
    document.getElementById('popLayer2').style.display="none";
    document.getElementById('Buy-Expansion2').style.display="none";

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
    $.ajax({
        async:false,
        type:"POST",
        url:"/pca/sapce/getSpace",
        dataType: "json",
        success:function(data) {
            var h = "";
                h += "<p><span>全部空间："+data.allSpace+"</span><span>(含扩充空间)</span></p>"
                        +"<p><span>已用空间："+data.usedSpace+"</span></p>"
                        +"<p><span>剩余空间："+data.availableSpace+"</span></p>"
                         +"<p><span>已用占比："+data.percent+"%</span></p>"

            $("#content-about-info-no3").html(h);
        }

    });
}//时间格式处理，将时间戳转换成yyyy-mm-dd格式
function fmtDate(obj){
    var date =  new Date(obj);
    var y = 1900+date.getYear();
    var m = "0"+(date.getMonth()+1);
    var d = "0"+date.getDate();
    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
}

