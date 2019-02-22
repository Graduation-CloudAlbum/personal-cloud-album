$("#login_btn").click(function(){
        var username = $.trim($("#username").val());
        var password = $.trim($("#password").val());

    // $.ajax({
    //     async : false,
    //     type: "post",
    //     url: "/pca/album/albumInfo",
    //     dataType: "json",
    //     success: function (data) {
    //         for(var i = 0; i<data.album.length; i++){
    //             alert(data.album[i].albumName);
    //         }
    //         alert(data.album.length);
    //         // window.location.href="/pca/user/myAlbum";
    //     }
    // });

    $.ajax({
            async : false,
            type:"post",
            url:"/pca/user/checkLogin",
            data:{"username":username,"password":password},
            dataType: "json",
            complete:function(result) {
                if (result.responseText=="success") {
                    $.ajax({
                        async : false,
                        type: "post",
                        url: "/pca/album/albumInfo",
                        dataType: "json",
                        success: function (data) {

                            // alert("45666666");
                            // var h = "";
                            // //追加到album页面
                            // alert("#myAlbum-content");
                            // for (var i = 0; i < data.album.length; i++) {
                            //     alert("进入内层循环体");
                            //     // alert(data.album[i].albumName);
                            //     // $("#bottun-title-p1").html(data.album[1].albumName);
                            //     // $("bottun-title-p1").append(data.album[1].albumName);
                            //     h += "<li class='content-about-li'>"
                            //         + "<img src='<%=basePath%>/resource/img/Album-cover1.jpg'>"
                            //         + "<div class='content-about-li-top'>"
                            //         + "<div class='content-about-li-top-a'>"
                            //         + "<a class='iconfont icon-huishouzhan1 icon1' title='删除相册'></a>"
                            //         + "<a class='iconfont icon-fenxiang1 icon2' title='分享相册'></a>"
                            //         + "<a class='iconfont iconfont icon-point icon1' title='相册信息'></a>"
                            //         + "</div>"
                            //         + "<div class='bottun-title'>"
                            //         + "<p class='bottun-title-p1'>"+data.album[i].albumName+"</p>"
                            //         + " <p class='bottun-title-p2'>"+data.album[i].creaTime+"<i class='iconfont icon-vertical_line'></i>23图</p>"
                            //         + "</div>"
                            //         + "</div>"
                            //         + "</li>"
                            // }
                            // $("#myAlbum-content").html(h);
                            //window.location.href="/pca/user/myAlbum?data="+data;
                            window.location.href="/pca/user/myAlbum";
                        }
                    });

                }else {
                    alert("用户名或密码错误 请重试");
                    $("#username").val("");
                    $("#password").val("");
                }
            }
        });
});