//点击好友分组显示各分组下好友
function selectOnde(permissionType) {
    if (permissionType==("我的好友")){
        window.location.href="/pca/friend/selectMyFriend"
    }else if (permissionType==("我的家人")){
        window.location.href="/pca/friend/selectMyFamily"
    } else if (permissionType==("我的同事")){
        window.location.href="/pca/friend/selectMyColleague"
    } else if (permissionType==("我的同学")){
        window.location.href="/pca/friend/selectMyClassmate"
    } else {
        window.location.href="/pca/friend/selectMyStranger"
    }
}
//为空
$(document).ready(function(){
	if($(".friends-content-li").length>0){
		$(".friends-content").css({ display: "block" });
		$(".friends1").css({ display: "none" });
	}
	else{
		$(".friends-content").css({ display: "none" });
		$(".friends1").css({ display: "block" });
	}
});


//点击添加分组
var menuFrends1 = document.getElementById('menu-frends1');
var CreateFriendsButton1 = document.getElementById('Create-friends-button1');
var CreateFriendsButton2 = document.getElementById('Create-friends-button2');
var iconChacha4 = document.getElementById('iconChacha4');
menuFrends1.onclick=function(){
    document.getElementById('Create-friends-group').style.display="block";
    document.getElementById('popLayer2').style.display="block";
}
var selectFirst = document.getElementById('select-first');
var selectRight = document.getElementById('select-right');
var menuGroup = document.getElementById('menu-group');
var menuGroupLi = menuGroup.getElementsByTagName('li');
var aLi="";
var groupName;
selectRight.onclick = function(){
    menuGroup.style.display="block"
}
for(var i=0;i<menuGroupLi.length;i++){
    menuGroupLi[i].index = i;
    menuGroupLi[i].onclick = function(){
        str = (function(i){
            aLi=menuGroupLi[i].innerHTML;
            selectFirst.innerHTML=aLi;
            return selectFirst.innerHTML;
        })(this.index);
        menuGroup.style.display="none"
        selectFirst.innerHTML=str
        groupName=str
    }
}
iconChacha4.onclick=function(){
    document.getElementById('Create-friends-group').style.display="none";
    document.getElementById('popLayer2').style.display="none";
    selectFirst.innerHTML="选择分组";
}
CreateFriendsButton1.onclick=function(){
    document.getElementById('Create-friends-group').style.display="none";
    document.getElementById('popLayer2').style.display="none";
    selectFirst.innerHTML="选择分组";
}
CreateFriendsButton2.onclick=function () {
    $.ajax({
        async : false,
        type: "post",
        url: "/pca/friend/createFriendGroup",
        data:{"groupName":groupName},
        dataType: "json",
        success: function (data) {
            if(data){
                alert("添加成功")
                window.location.href="/pca/friend/myFriend"
            }
            else {
                alert("您已有该分组，不可重复添加")
                window.location.href="/pca/friend/myFriend"
            }
        }

    });

}
//添加好友Create-for-friends
var menuFrends2 = document.getElementById('menu-frends2');
var iconChacha5 = document.getElementById('iconChacha5');
menuFrends2.onclick = function(){
    document.getElementById('create-friends').style.display="block";
    document.getElementById('popLayer').style.display="block";
}
iconChacha5.onclick = function(){
    document.getElementById('create-friends').style.display="none";
    document.getElementById('popLayer').style.display="none";
    document.getElementById('search-content').style.display="none";
};
////搜索
var searchI = document.getElementById('search-i');
var friendName;
searchI.onclick = function(){
    friendName=$("#Create-friends-input").val();
    var h="";
    $.ajax({
        async : false,
        type: "post",
        url: "/pca/friend/searchFriends",
        data:{"friendName":friendName},
        dataType: "json",
        success: function (data) {
            if(data.users.length!=0){
                for(var i=0;i<data.users.length;i++){
                    h+= "<li class='search-content-li'>"
                        +"<img src='"+data.users[i].userIcon+"'>"
                        + "<p class='search-content-name'>"+data.users[i].nickName+"</p>"
                        + "<p class='search-content-name2'>"+data.users[i].userName+"</p>"
                        + "<div class='Create-friends-button2 create-jia' onclick='selectUser(\""+data.users[i].userName+"\",\""+data.users[i].nickName+"\")'><p>加好友</p></div>"
                        +"</li>"
                    $("#search-content").html(h);
                }
                document.getElementById('search-content').style.display="block";
            }
            else {
                alert("您查找的用户不存在")
            }
        }
    });
}
var searchContent = document.getElementById('search-content');
var searchContentLi=searchContent.getElementsByTagName('li');
for(var i=0;i<searchContentLi.length;i++){
    searchContentLi[i].onclick = function(){
        document.getElementById('popLayer2').style.display="block";
        document.getElementById('friendVerification').style.display="block";
        document.getElementById('Verification-text').style.display="block";

    }
}

var VerificationGroup = document.getElementById('Verification-group');
var friendVerificationRight = document.getElementById('friendVerification-right');
var friendVerificationLeft = document.getElementById('friendVerification-left');
var friendVerificationGroup = document.getElementById('friendVerification-group');
var friendVerificationGroupLi = friendVerificationGroup.getElementsByTagName('li');

var bLi="";
friendVerificationRight.onclick = function(){
    friendVerificationGroup.style.display="block"
}
for(var i=0;i<friendVerificationGroupLi.length;i++){
    friendVerificationGroupLi[i].index = i;
    friendVerificationGroupLi[i].onclick = function(){
        str = (function(i){
            aLi=friendVerificationGroupLi[i].innerHTML;
            friendVerificationLeft.innerHTML=aLi;
            return friendVerificationLeft.innerHTML;
        })(this.index);
        friendVerificationGroup.style.display="none"
        friendVerificationLeft.innerHTML=str
        groupName=str
    }
}
var friendVerificationButton1 = document.getElementById('friendVerification-button1');
var iconChacha6 = document.getElementById('iconChacha6');
iconChacha6.onclick = function(){
    document.getElementById('popLayer2').style.display="none";
    friendVerificationLeft.innerHTML="选择分组";
    friendVerificationGroup.style.display="none";
    document.getElementById('friendVerification').style.display="none";
    document.getElementById('Verification-group').style.display="none";
    document.getElementById('Verification-text').style.display="none";
    document.getElementById("textarea-txt").value="我是..."
};
friendVerificationButton1.onclick = function(){
    document.getElementById('Verification-text').style.display="block";
    VerificationGroup.style.display="none";
};


//点击输入验证信息下一步
var Validationmessage;
var VerificationNext = document.getElementById('Verification-next');
VerificationNext.onclick = function(){
    Validationmessage=$("#Validationmessage").val();
    document.getElementById('Verification-group').style.display="block";
    document.getElementById('Verification-text').style.display="none";

}


//输入验证信息
var userName2;
var nickName2;
function selectUser(userName,nickName) {
    userName2=userName;
    nickName2=nickName;
    if(userName!=null&&nickName!=null){
        var showNickname = document.getElementById('showNickname');
        showNickname.innerHTML = "添加好友—"+nickName+"("+userName+")";
        document.getElementById('popLayer2').style.display="block";
        document.getElementById('friendVerification').style.display="block";
        document.getElementById('Verification-text').style.display="block";
    }

}

var friendVerification_button2=document.getElementById('friendVerification_button2');
friendVerification_button2.onclick = function(){
    $.ajax({
        async :false,
        type: "post",
        url: "/pca/friend/addFriend",
        data:{"userName":userName2,"Validationmessage":Validationmessage,"groupName":groupName},
        dataType: "json",
        success: function (data) {
            if(data){
                alert("已发送好友验证请求，请等待对方验证")
                window.location.href="/pca/friend/myFriend"
            }
            else {
                alert("您已有该好友，不可重复添加")
            }
        }

    });
}

//点击删除分组
var menuFrends3 = document.getElementById('menu-frends3');
var ManageGroupButton1 = document.getElementById('Manage-group-button1');
var ManageGroupButton2 = document.getElementById('Manage-group-button2');
var iconChacha7 = document.getElementById('iconChacha7');
menuFrends3.onclick=function(){
    document.getElementById('Manage-friends-group').style.display="block";
    document.getElementById('popLayer2').style.display="block";
}
var selectManageFirst = document.getElementById('select-manage-first');
var selectManageRight = document.getElementById('select-manage-right');
var menuManageGroup = document.getElementById('menu-manage-group');
var menuManageGroupLi = menuManageGroup.getElementsByTagName('li');
selectManageRight.onclick = function(){
    menuManageGroup.style.display="block"
}
for(var i=0;i<menuManageGroupLi.length;i++){
    menuManageGroupLi[i].index = i;
    menuManageGroupLi[i].onclick = function(){
        str = (function(i){
            aLi=menuManageGroupLi[i].innerHTML;
            selectManageFirst.innerHTML=aLi;
            return selectManageFirst.innerHTML;
        })(this.index);
        menuManageGroup.style.display="none"
        selectManageFirst.innerHTML=str
        groupName=str
    }
}
iconChacha7.onclick=function(){
    document.getElementById('Manage-friends-group').style.display="none";
    document.getElementById('popLayer2').style.display="none";
    selectManageFirst.innerHTML="选择分组";
}
ManageGroupButton1.onclick=function(){
    document.getElementById('Manage-friends-group').style.display="none";
    document.getElementById('popLayer2').style.display="none";
    selectManageFirst.innerHTML="选择分组";
}
ManageGroupButton2.onclick=function () {
    if(groupName=="我的好友"||groupName=="陌生人"){
        alert("不可删除默认分组！")
    }else{
        $.ajax({
            async : false,
            type: "post",
            url: "/pca/friend/deleteFriendsGroup",
            data:{"groupName":groupName},
            dataType: "json",
            success: function (data) {
                if(data){
                    alert("删除分组成功")
                    window.location.href="/pca/friend/myFriend"
                }
                else {
                    alert("删除失败")
                    window.location.href="/pca/friend/myFriend"
                }
            }

        });
    }
}



function inFriendSpace(friend_id) {
    window.location.href="/pca/friend/inFriendSpace2/"+friend_id;
}