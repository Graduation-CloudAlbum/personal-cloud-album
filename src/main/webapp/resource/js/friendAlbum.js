//点击相册
//myAlbum-menu1
var friendAlbumContent=document.getElementById('friendAlbum-content');
var friendAlbumContentLi=friendAlbumContent.getElementsByTagName('li');
var friendAlbumContent2=document.getElementById('friendAlbum-content2');
var open=document.getElementById('open');
var open2=document.getElementById('open2');
var a="";
for(var i=0;i<friendAlbumContentLi.length;i++){
	friendAlbumContentLi[i].onclick=function(){
		friendAlbumContent.style.display="none";
		friendAlbumContent2.style.display="block";
		open.style.display="none";
		open2.style.display="block";

	}
}


//首页点击的相册名
var aName="";
//动态加载首页相册
$().ready(function getAlbum() {
    $.ajax({
        async : false,
        type: "post",
        url: "/pca/album/albumInfo",
        dataType: "json",
        success: function (data){
            //加载相册 到album页面
            var h = "";
            var createtime="";
            var resource="/pca/resource/img/Album-cover1.jpg";
            for (var i = 0; i < data.album.length; i++) {
                var imageNum=data.imageNum[i];
                albumName=data.album[i].albumName;
                createtime=fmtDate(data.album[i].createTime);
                h += "<li class='content-about-li'>"
                    + "<img src='"+resource+"'>"
                    + "<div class='content-about-li-top'>"
                    + "<div class='content-about-li-top-a'>"
                    + "<a class='iconfont icon-huishouzhan1 icon1' title='删除相册'></a>"
                    + "<a class='iconfont icon-fenxiang1 icon2' title='编辑相册'></a>"
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
                    myAlbumMenu1.style.display="none";
                    myAlbumContent.style.display="none";
                    open.style.display="none";

                    myAlbumMenu2.style.display="block";
                    myAlbumContent2.style.display="block";
                    open2.style.display="block";

                    str = (function(i){
                        aLi=i;
                        return aLi;
                    })(this.index);
                    aLi=str;

                    var aP = this.getElementsByTagName('p');
                    aName=aP[0].innerHTML;

                }

            }

        }
    });
});
//点击相册，获取对应的相册名传递到后台，并将返回的数据展示到页面
$("#myAlbum-content").click(function () {
    var albumName=aName;
    $.ajax({
        type:"post",
        url:"/pca/image/getImage",
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

});
//在左侧导航栏点击“我的相册”时调用相册获取方法
$("#navMenu1").click(function () {
    getAlbum();
});