var friendsVerification=document.getElementById('friends-Verification');
//点击消息
friendsVerification.onclick = function(){
    $.ajax({
        async : false,
        type: "post",
        url: "/pca/friend/selectAllFriendVerification",
        dataType: "json",
        success: function (data) {
            //加载相册 到album页面
            //收到的验证消息
            var h = "";
            for (var i = 0; i < data.friendVerifications.length; i++) {
                h += "<tr>"
                    +" <td>"+data.friendVerifications[i].friend.nickName+"</td>"
                    + "<td>"+data.friendVerifications[i].note+"</td>"
                    + "<td><button class='btn delete'>接受</button>   <button class='btn delete'>拒绝</button></td>"
                    +"</tr>"
            }
            $("#receiveFriendVerifications").html(h);
            //发送的验证消息
            var f = "";
            for (var i = 0; i < data.friendVerificationsTwo.length; i++) {
                f += "<tr>"
                    +" <td>"+data.friendVerificationsTwo[i].friend.nickName+"</td>"
                    + "<td>"+data.friendVerificationsTwo[i].note+"</td>"
                    +"<td>"+data.friendVerificationsTwo[i].state+"</td>"
                    + "<td><button class='btn  delete'>删除</button></td>"
                    +"</tr>"
            }
            $("#sandFriendVerifications").html(f);
        }
    });
	document.getElementById('Verification').style.display="block";
	document.getElementById('popLayer2').style.display="block";

}

//	color: #000;
//	border-bottom: 2px solid #D84C31;
//关闭消息
var iconChacha10=document.getElementById('iconChacha10');
iconChacha10.onclick = function(){
	document.getElementById('Verification').style.display="none";
	document.getElementById('popLayer2').style.display="none";

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