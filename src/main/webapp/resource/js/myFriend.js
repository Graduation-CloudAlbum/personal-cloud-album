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
//点击添加分组
var menuFrends1 = document.getElementById('menu-frends1');
var CreateFriendsButton1 = document.getElementById('Create-friends-button1');
var iconChacha4 = document.getElementById('iconChacha4');
menuFrends1.onclick=function(){
    document.getElementById('Create-friends').style.display="block";
    document.getElementById('popLayer2').style.display="block";
}
iconChacha4.onclick=function(){
    document.getElementById('Create-friends').style.display="none";
    document.getElementById('popLayer2').style.display="none";
}
CreateFriendsButton1.onclick=function(){
    document.getElementById('Create-friends').style.display="none";
    document.getElementById('popLayer2').style.display="none";
}
//添加好友Create-for-friends
var menuFrends2 = document.getElementById('menu-frends2');
var CreateForFriendsButton1 = document.getElementById('Create-for-friends-button1');
var iconChacha5 = document.getElementById('iconChacha5');
menuFrends2.onclick=function(){
    document.getElementById('Create-for-friends').style.display="block";
    document.getElementById('popLayer2').style.display="block";
}
iconChacha5.onclick=function(){
    document.getElementById('Create-for-friends').style.display="none";
    document.getElementById('popLayer2').style.display="none";
}
CreateForFriendsButton1.onclick=function(){
    document.getElementById('Create-for-friends').style.display="none";
    document.getElementById('popLayer2').style.display="none";
}