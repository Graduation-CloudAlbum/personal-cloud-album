 $("#add_friend").click(function () {
    var username="qwe123";
    var permisssion_type=1;
    var note="请问加个好友可以嘛";
    $.ajax({
        type: "post",
        async: false,
        url: "/friend/addFriend/"+ username,
        data:{"permisssion_type":permisssion_type,"note":note},
        dataType: "json",
        success: function (data) {
            var question = data.username;
        }
    });
});