var friendNumber=document.getElementById('friendNumber');
if(friendNumber.value>0){
	friendNumber.style.display="block";
	if(friendNumber.value>99){
		friendNumber.value="n"
	}
}
else{
	friendNumber.style.display="none";
}







var friendsVerification=document.getElementById('friends-Verification');

//拒绝好友请求
function refusedfriendVerifications(userId,friendVerifications_id,friendId) {
    $.ajax({
        async : false,
        type: "post",
        url: "/pca/friend/refusedfriendVerifications",
        data:{"userId":userId,"friendVerifications_id":friendVerifications_id,"friendId":friendId},
        dataType: "json",
        dataType: "json",
        success: function (data) {
            alert("拒绝成功！")
            document.getElementById('Verification').style.display="none";
            document.getElementById('popLayer').style.display="none";
            friendsVerification.click();
        }
    });
}

//删除已发送的验证消息
function deleteFriendVerifications(friendVerifications_id) {
    $.ajax({
        async : false,
        type: "post",
        url: "/pca/friend/deleteFriendVerifications",
        data:{"friendVerifications_id":friendVerifications_id},
        dataType: "json",
        dataType: "json",
        success: function (data) {
            alert("删除成功！")
            document.getElementById('Verification').style.display="none";
            document.getElementById('popLayer').style.display="none";
            friendsVerification.click();
        }
    });
}

//点击消息
friendsVerification.onclick = function(){
    $.ajax({
        async : false,
        type: "post",
        url: "/pca/friend/selectAllFriendVerification",
        dataType: "json",
        success: function (data) {
            console.log(data)
            //加载相册 到album页面
            //收到的验证消息
            var h = "";
            for (var i = 0; i < data.friendVerifications.length; i++) {
                h += "<tr>"
                    +" <td>"+data.friendVerifications[i].friend.nickName+"</td>"
                    + "<td>"+data.friendVerifications[i].note+"</td>"
                    + "<td><button class='btn delete acceptF' onclick='acceptfriendsbutton(\""+data.friendVerifications[i].id+"\")'>接受</button>   <button class='btn delete' onclick='refusedfriendVerifications(\""+data.friendVerifications[i].userId+"\",\""+data.friendVerifications[i].id+"\",\""+data.friendVerifications[i].friendId+"\")'>拒绝</button></td>"
                    +"</tr>"
            }
            $("#receiveFriendVerifications").html(h);
            //发送的验证消息
            var f = "";
            var status=[];
            for (var i = 0; i < data.friendVerificationsTwo.length; i++) {
            	if(data.friendVerificationsTwo[i].state==0){
            		status[i]="未审核";
            	}
            	else if(data.friendVerificationsTwo[i].state==1){
            		status[i]="通过";
            	}
            	else if(data.friendVerificationsTwo[i].state==2){
            		status[i]="拒绝";
            	}
            	
                f += "<tr>"
                    +" <td>"+data.friendVerificationsTwo[i].friend.nickName+"</td>"
                    + "<td>"+data.friendVerificationsTwo[i].note+"</td>"
                    +"<td>"+status[i]+"</td>"
                    + "<td><button class='btn  delete' onclick='deleteFriendVerifications(\""+data.friendVerificationsTwo[i].id+"\")'>删除</button></td>"
                    +"</tr>"
            }
            $("#sandFriendVerifications").html(f);
            console.log(data.friendVerificationsTwo.length)
          //为空
           // $(document).ready(function(){
            	if(data.friendVerificationsTwo.length>0){
            		$("#accept-Verification").css({ display: "block" });
            		$(".table1").css({ display: "none" });
            		$(".table2").css({ display: "none" });
            	}
            	else{
            		$("#accept-Verification").css({ display: "none" });
            		$(".table1").css({ display: "block" });
            		$(".table2").css({ display: "none" });
            	}
          //  });
        }
    });
	document.getElementById('Verification').style.display="block";
	document.getElementById('popLayer').style.display="block";

}

//	color: #000;
//	border-bottom: 2px solid #D84C31;
//关闭消息
var iconChacha10=document.getElementById('iconChacha10');
iconChacha10.onclick = function(){
	document.getElementById('Verification').style.display="none";
	document.getElementById('popLayer').style.display="none";

}

//收到消息
var accept=document.getElementById('accept');
accept.style.color="#000";
accept.style.borderBottom="2px solid #D84C31";
accept.onclick = function(){
	document.getElementById('accept-Verification').style.display="block";
	document.getElementById('send-Verification').style.display="none";
	accept.style.color="#000";
	accept.style.borderBottom="2px solid #D84C31";

	send.style.color="#9999A6";
	send.style.borderBottom="";
	
	//为空

	$(document).ready(function(){
		if($("#accept-Verification tr").length>1){
			$("#accept-Verification").css({ display: "block" });
			$(".table1").css({ display: "none" });
			$(".table2").css({ display: "none" });
		}
		else{
			$("#accept-Verification").css({ display: "none" });
			$(".table1").css({ display: "block" });
			$(".table2").css({ display: "none" });
		}
	});
}
//发出验证
var send=document.getElementById('send');
send.onclick = function(){
	document.getElementById('send-Verification').style.display="block";
	document.getElementById('accept-Verification').style.display="none";
	send.style.color="#000";
	send.style.borderBottom="2px solid #D84C31";

	accept.style.color="#9999A6";
	accept.style.borderBottom="";
	
	$(document).ready(function(){
		if($("#send-Verification tr").length>1){
			$("#send-Verification").css({ display: "block" });
			$(".table2").css({ display: "none" });
			$(".table1").css({ display: "none" });
		}
		else{
			$("#send-Verification").css({ display: "none" });
			$(".table2").css({ display: "block" });
			$(".table1").css({ display: "none" });
		}
	});
}
// var VerificationMenu=document.getElementById('Verification-menu');
// var VerificationMenuLi = VerificationMenu.getElementsByTagName('li');
// for(var i=0; i < VerificationMenuLi.length; i++){
// 	VerificationMenuLi[i].onclick = function(){
// 		var aL = this.getElementsByTagName('a');
// 		alert(aL.length)
// 		aL[0].style.color="#000";
// 		//aL[0].style.borderBottom="2px solid #D84C31";
// 	}
// }	color: #9999A6;

var acceptFriends = document.getElementById('accept-friends');
var acceptFriendsButton1 = document.getElementById('accept-friends-button1');
var iconChacha30 = document.getElementById('iconChacha30');
var acceptFriendsButton2 = document.getElementById('accept-friends-button2');
var acceptFriendsGroup = document.getElementById('accept-friends-group');
var acceptFriendsGroupLi = acceptFriendsGroup.getElementsByTagName('li');
var acceptFriendsLeft = document.getElementById('accept-friends-left');
var acceptFriendsRight = document.getElementById('accept-friends-right');


//验证消息点击取消按钮
acceptFriendsButton1.onclick = function(){
	acceptFriends.style.display="none";
	document.getElementById('popLayer2').style.display="none";
}


iconChacha30.onclick = function(){
	acceptFriends.style.display="none";
	document.getElementById('popLayer2').style.display="none";
}

var acceptLi="";
var acceptGroupName="";
acceptFriendsRight.onclick = function(){
	acceptFriendsGroup.style.display="block"
}
for(var i=0;i<acceptFriendsGroupLi.length;i++){
	acceptFriendsGroupLi[i].index = i;
	acceptFriendsGroupLi[i].onclick = function(){
		str = (function(i){
			acceptLi=acceptFriendsGroupLi[i].innerHTML;
			acceptFriendsLeft.innerHTML=acceptLi;
			return acceptFriendsLeft.innerHTML;
		})(this.index);
		acceptFriendsGroup.style.display="none"
		acceptFriendsLeft.innerHTML=str
        acceptGroupName=str;
	}
}

var friendVerifications_id_Two="";
//添加好友至某分组
acceptFriendsButton2.onclick = function(){
    $.ajax({
        async: false,
        type: "post",
        url: "/pca/friend/acceptFriendsInformation",
        data:{"acceptGroupName":acceptGroupName,"friendVerifications_id_Two":friendVerifications_id_Two},
        dataType: "json",
        success: function (data) {
            acceptFriends.style.display="none";
            document.getElementById('popLayer2').style.display="none";
            alert("好友请求已通过！")
            document.getElementById('Verification').style.display="none";
            document.getElementById('popLayer').style.display="none";
            friendsVerification.click();
        }
    });
}
function acceptfriendsbutton(friendVerifications_id){
    friendVerifications_id_Two=friendVerifications_id;
    acceptFriends.style.display="block";
    document.getElementById('popLayer2').style.display="block";
}










