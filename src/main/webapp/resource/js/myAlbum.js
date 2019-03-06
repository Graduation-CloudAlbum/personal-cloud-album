var uploadPhoto1 = document.getElementById('uploadPhoto1');
var uploadPhoto3 = document.getElementById('uploadPhoto3');
var iconChacha1 = document.getElementById('icon-chacha1');
var popLayer = document.getElementById('popLayer');//upload-photos-choose
//在首页点击上传照片
uploadPhoto1.onclick=function(){
    document.getElementById('upload-photos').style.display="block";
    document.getElementById('popLayer').style.display="block";
    document.getElementById('popLayer2').style.display="block";
    document.getElementById('upload-photos-choose').style.display="block";
}
//在相册中点击上传照片
uploadPhoto3.onclick=function(){
    document.getElementById('upload-photos').style.display="block";
    document.getElementById('popLayer').style.display="block";
    // document.getElementById('popLayer2').style.display="block";
    // document.getElementById('upload-photos-choose').style.display="block";
}

var uploadPhotosLeft = document.getElementById('upload-photos-left');
var uploadPhotosRight = document.getElementById('upload-photos-right');
var uploadPhotosGroup = document.getElementById('upload-menu-group');
var uploadPhotosGroupLi = uploadPhotosGroup.getElementsByTagName('li');

var bLi="";
var chooseName="";
// uploadPhotosRight.onclick = function(){
//     uploadPhotosGroup.style.display="block"
// }
// for(var i=0;i<uploadPhotosGroupLi.length;i++){
//     uploadPhotosGroupLi[i].index = i;
//     uploadPhotosGroupLi[i].onclick = function(){
//         str = (function(i){
//             bLi=uploadPhotosGroupLi[i].innerHTML;
//             uploadPhotosLeft.innerHTML=bLi;
//             return uploadPhotosLeft.innerHTML;
//         })(this.index);
//         uploadPhotosGroup.style.display="none"
//         uploadPhotosLeft.innerHTML=str
//     }
// }

//在主页点击“上传照片”按钮，动态加载可选择的相册
$("#upload-photos-right").click(function () {
    $.ajax({
        async : false,
        type: "post",
        url: "/pca/album/albumInfo",
        dataType: "json",
        success: function (data){
            uploadPhotosGroup.style.display="block"
            var h = "";
            for (var i = 0; i < data.album.length; i++) {
                var albumName=data.album[i].albumName;
                h += "<li class='upload-menu-group-li'>"+albumName+"</li>"
            }
            $("#upload-menu-group").html(h);
            for(var i=0;i<uploadPhotosGroupLi.length;i++){
                uploadPhotosGroupLi[i].index = i;
                uploadPhotosGroupLi[i].onclick = function(){
                    str= (function(i){
                        bLi=uploadPhotosGroupLi[i].innerHTML;
                        uploadPhotosLeft.innerHTML=bLi;
                        return uploadPhotosLeft.innerHTML;
                    })(this.index);
                    uploadPhotosGroup.style.display="none"
                    uploadPhotosLeft.innerHTML=str;
                     chooseName=str;
                    return chooseName;
                }

            }
         }
    });

});
$("#select-button").click(function () {
    $("#upload-album-choose").html("<span>上传照片至："+chooseName+"</span>");
    $.ajax({
        type: "post",
        url: "/pca/image/goUpload",
        data: {"albumName": chooseName},
        dataType: "json",
        success: function (data){

        }
    });


    $("#icon-chacha1").click(function () {
        $("#upload-album-choose").html("<span>上传照片至：</span>");
    });

});


//关闭上传照片
iconChacha1.onclick=function(){
    document.getElementById('upload-photos').style.display="none";
    document.getElementById('popLayer').style.display="none";
    uploadPhotosLeft.innerHTML="我的相册";

}
//关闭选择相册弹出框
var iconChacha2 = document.getElementById('iconChacha2');
iconChacha2.onclick=function(){
    document.getElementById('upload-photos-choose').style.display="none";
    document.getElementById('popLayer2').style.display="none";
    document.getElementById('upload-photos').style.display="none";
    document.getElementById('popLayer').style.display="none";
    uploadPhotosLeft.innerHTML="我的相册";
}
//上传照片下一步
var selectButton = document.getElementById('select-button');
selectButton.onclick=function(){
    document.getElementById('upload-photos-choose').style.display="none";
    document.getElementById('popLayer2').style.display="none";
}
//创建相册
var uploadPhoto2 = document.getElementById('uploadPhoto2');//Create-Album
uploadPhoto2.onclick=function(){
    document.getElementById('popLayer2').style.display="block";
    document.getElementById('Create-Album').style.display="block";
}
$("#Create-Album-button2").click(function () {
    var albumName=$.trim($("#Create-Album-input").val());
    $.ajax({
        type:"post",
        url:"/pca/album/createAlbum",
        data: {"albumName": albumName},
        dataType: "json",
        success: function (data) {
            if (data==1){
                alert("新建成功");
                window.location.href="/pca/user/myAlbum";
            }else{
                alert("该相册已存在，换个名称试试");
                $("#Create-Album-input").val("");
               }
            }
    });
});
//关闭创建相册
var iconChacha3 = document.getElementById('iconChacha3');
iconChacha3.onclick=function(){
    document.getElementById('popLayer2').style.display="none";
    document.getElementById('Create-Album').style.display="none";
}
var CreateAlbumButton1 = document.getElementById('Create-Album-button1');
CreateAlbumButton1.onclick=function(){
    document.getElementById('popLayer2').style.display="none";
    document.getElementById('Create-Album').style.display="none";
}

//点击相册
//myAlbum-menu1
var myAlbumContent=document.getElementById('myAlbum-content');
var myAlbumContent2=document.getElementById('myAlbum-content2');
var myAlbumLi=myAlbumContent.getElementsByTagName('li');
var myAlbumMenu1=document.getElementById('myAlbum-menu1');
var myAlbumMenu2=document.getElementById('myAlbum-menu2');
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
                    + "<a class='iconfont icon-fenxiang1 icon2' title='重命名相册'></a>"
                    + "<a class='iconfont iconfont icon-point icon1' title='相册信息'></a>"
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

//上传图片
var uploadPhotosPopContentButton =document.getElementById('upload-photos-pop-content-button');
uploadPhotosPopContentButton.onclick=function(){
    document.getElementById('upload-photos-pop-content-button').style.display="none";
    document.getElementById('upload-photos-pop-content-footer').style.display="none";
    document.getElementById('upload-photos-pop-content-footer2').style.display="block";
}
var magId=0;
function setImagePreviews(){
    var docobj=document.getElementById("doc"+magId);
    var dd=document.getElementById("dd");
    var fileList=docobj.files;
    for( var i=0;i<fileList.length;i++){
        magId++;
        $(dd).append("<div class='img-wrap' imgid='img"+(magId-1)+"'><img id='img"+(magId-1)+"'/><span class='closeimg"+(magId-1)+" close'>×</span><div class='img-button'><p>adhg.jpg</p></div></div>");
        $(".fileinput-wrap [imgid=img"+(magId-1)+"]")[0].style.position="absolute";
        $(".fileinput-wrap").append('<input class="inputfile" type="file" name="files" id="doc'+magId+'" imgid="img'+magId+'" onchange="javascript:setImagePreviews()" />');
        $(".fileinput-wrap").append('<label for="doc'+magId+'" class="btn btn-default footer-button1">继续添加</label> ');

        $(".closeimg"+(magId-1)).on("click",function(e){
            var id=$(this).parents(".img-wrap").attr("imgid");
            $(this).parent().remove();
            $(".fileinput-wrap input[imgid="+id+"]").remove();
        })
        var imgObjPreview=document.getElementById("img"+(magId-1));
        if(docobj.files&&docobj.files[i]){
            imgObjPreview.style.display="block";
            imgObjPreview.src=window.URL.createObjectURL(docobj.files[i]);
        }else{
            docobj.select();
            var imgsrc=document.selection.createRange().text;
            var localImageId=document.getElementById("img"+(magId-1));
            try{
                localIamgeId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                localIamgeId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src=imgsrc;
            }catch(e){
                alert("上传图片出错")
                return false;
            }
            imgObjPreview.style.display="none";
            document.selection.empty();
        }
    }
    return true;
}
//时间格式处理，将时间戳转换成yyyy-mm-dd格式
function fmtDate(obj){
    var date =  new Date(obj);
    var y = 1900+date.getYear();
    var m = "0"+(date.getMonth()+1);
    var d = "0"+date.getDate();
    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
}



