 $("#add_friend").click(function () {
    var nickname="张三";
    var permisssion_type=1;
    $.ajax({
        type: "post",
        async: false,
        url: "/friend/addFriend/"+ nickname,
        data:{"permisssion_type":permisssion_type},
        dataType: "json",
        success: function (data) {
            var question = data.nickName;
        }
    });
});