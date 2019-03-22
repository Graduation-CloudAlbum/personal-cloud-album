//点击相册
//myAlbum-menu1
var myAlbumContent=document.getElementById('myAlbum-content');
var myAlbumContent2=document.getElementById('myAlbum-content2');
var myAlbumLi=myAlbumContent.getElementsByTagName('li');
var open=document.getElementById('open');
var open2=document.getElementById('open2');
var aLi="";
//首页点击的相册名
var aName="";
//动态加载首页相册
$().ready(function getAlbum() {
    $.ajax({
        async : false,
        type: "post",
        url: "/pca/friend/inFriendSpace",
        dataType: "json",
        success: function (data){
            //加载相册 到album页面
            var h = "";
            var createtime="";
            var resource="/pca/resource/img/Album-cover1.jpg";
            for (var i = 0; i < data.album.length; i++) {
                var imageNum=data.imageNum[i];
                albumName=data.album[i].albumName;
                var coverImg=data.coverList[i].url;
                createtime=fmtDate(data.album[i].createTime);
                h += "<li class='content-about-li'>"
                    + "<img src='"+coverImg+"'>"
                    + "<div class='content-about-li-top'>"
                    + "<div class='content-about-li-top-a'>"
                    + "</div>"
                    + "<div class='bottun-title'>"
                    + "<p class='bottun-title-p1'>"+albumName+"</p>"
                    + " <p class='bottun-title-p2'>"+createtime+"<i class='iconfont icon-vertical_line'></i>"+imageNum+"图</p>"
                    + "</div>"
                    + "</div>"
                    + "</li>"
                $("#open").html("共"+data.album.length+"个相册");
            }
            $("#myAlbum-content").html(h);
            for(var i=0;i<myAlbumLi.length;i++){
                myAlbumLi[i].index = i;

                myAlbumLi[i].onclick=function(){
                    str = (function(i){
                        aLi=i;
                        return aLi;
                    })(this.index);
                    aLi=str;
                    var aP = this.getElementsByTagName('p');
                    aName=aP[0].innerHTML;


                    var albumName=aName;
                    $.ajax({
                        type:"post",
                        url:"/pca/friend/checkFriendPower",
                        data: {"albumName": albumName},
                        dataType: "json",
                        success: function (data) {
                            if(data){
                                myAlbumContent.style.display="none";
                                open.style.display="none";
                                myAlbumContent2.style.display="block";
                                open2.style.display="block";
                                $.ajax({
                                    type:"post",
                                    url:"/pca/friend/checkAlbumPower",
                                    data: {"albumName": albumName},
                                    dataType: "json",
                                    success: function (data) {
                                        var h = "";
                                        for (var i = 0; i < data.imageList.length; i++) {
                                            var url=data.imageList[i].url;
                                            h +="<div class='content-about2-li'>"

                                                +"<a href='"+url+"'>"
                                                +"<img src='"+url+"'/></a>"
                                                + "</div>"
                                            $("#open2").html("共"+ data.imageList.length+"张照片");
                                        }
                                        $("#myAlbum-content2").html(h);
                                    }
                                });
                            }else{
                                alert("对不起，您没有权限！");
                            }
                        }
                    });




                }
            }
        }
    });
});
//点击相册，获取对应的相册名传递到后台，并将返回的数据展示到页面
// $("#myAlbum-content").click(function () {
//     var albumName=aName;
//     $.ajax({
//         type:"post",
//         url:"/pca/friend/checkFriendPower",
//         data: {"albumName": albumName},
//         dataType: "json",
//         success: function (data) {
//             alert(data);
//             if(data){
//                 $.ajax({
//                     type:"post",
//                     url:"/pca/friend/checkAlbumPower",
//                     data: {"albumName": albumName},
//                     dataType: "json",
//                     success: function (data) {
//                         var h = "";
//                         for (var i = 0; i < data.imageList.length; i++) {
//                             var url=data.imageList[i].url;
//                             h +="<div class='content-about2-li'>"
//
//                                 +"<a href='"+url+"'>"
//                                 +"<img src='"+url+"'/></a>"
//                                 + "</div>"
//                             $("#open2").html("共"+ data.imageList.length+"张照片");
//                         }
//                         $("#myAlbum-content2").html(h);
//                     }
//                 });
//             }else{
//                     alert("对不起，您没有权限！");
//             }
//         }
//     });
//
//
// });
//时间格式处理，将时间戳转换成yyyy-mm-dd格式
function fmtDate(obj){
    var date =  new Date(obj);
    var y = 1900+date.getYear();
    var m = "0"+(date.getMonth()+1);
    var d = "0"+date.getDate();
    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
}
