var uploadPhoto1 = document.getElementById('uploadPhoto1');
var uploadPhoto3 = document.getElementById('uploadPhoto3');
var iconChacha1 = document.getElementById('icon-chacha1');
var popLayer = document.getElementById('popLayer');//upload-photos-choose
//点击上传照片
uploadPhoto1.onclick=function(){
    document.getElementById('upload-photos').style.display="block";
    document.getElementById('popLayer').style.display="block";
    document.getElementById('popLayer2').style.display="block";
    document.getElementById('upload-photos-choose').style.display="block";
}
//点击上传照片
uploadPhoto3.onclick=function(){
    document.getElementById('upload-photos').style.display="block";
    document.getElementById('popLayer').style.display="block";
    // document.getElementById('popLayer2').style.display="block";
    // document.getElementById('upload-photos-choose').style.display="block";
}
//关闭上传照片
iconChacha1.onclick=function(){
    document.getElementById('upload-photos').style.display="none";
    document.getElementById('popLayer').style.display="none";
}
//关闭选择相册弹出框
var iconChacha2 = document.getElementById('iconChacha2');
iconChacha2.onclick=function(){
    document.getElementById('upload-photos-choose').style.display="none";
    document.getElementById('popLayer2').style.display="none";
    document.getElementById('upload-photos').style.display="none";
    document.getElementById('popLayer').style.display="none";
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
var aLi=""
//动态加载首页相册
$().ready(function getAlbum() {
    $.ajax({
        async : false,
        type: "post",
        url: "/pca/album/albumInfo",
        dataType: "json",
        success: function (data){
            //追加到album页面
            var h = "";
            var createtime="";
            var resource="/pca/resource/img/Album-cover1.jpg";
            for (var i = 0; i < data.album.length; i++) {
                var imageNum=data.imageNum[i];
                createtime=fmtDate(data.album[i].createTime);
                h += "<li class='content-about-li'>"
                    + "<img src='"+resource+"'>"
                    + "<div class='content-about-li-top'>"
                    + "<div class='content-about-li-top-a'>"
                    + "<a class='iconfont icon-huishouzhan1 icon1' title='删除相册'></a>"
                    + "<a class='iconfont icon-fenxiang1 icon2' title='分享相册'></a>"
                    + "<a class='iconfont iconfont icon-point icon1' title='相册信息'></a>"
                    + "</div>"
                    + "<div class='bottun-title'>"
                    + "<p class='bottun-title-p1'>"+data.album[i].albumName+"</p>"
                    + " <p class='bottun-title-p2'>"+createtime+"<i class='iconfont icon-vertical_line'></i>"+imageNum+"图</p>"
                    + "</div>"
                    + "</div>"
                    + "</li>"
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
                }
            }

        }
    });
});
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
//时间格式处理
function fmtDate(obj){
    var date =  new Date(obj);
    var y = 1900+date.getYear();
    var m = "0"+(date.getMonth()+1);
    var d = "0"+date.getDate();
    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
}




