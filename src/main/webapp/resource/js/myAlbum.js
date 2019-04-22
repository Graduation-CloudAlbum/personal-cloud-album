var myAlbumContent = document.getElementById('myAlbum-content');
var myAlbumContent2 = document.getElementById('myAlbum-content2');
var myAlbumLiDel=myAlbumContent.getElementsByTagName('li');
var myAlbumLi = myAlbumContent.getElementsByTagName('span');
var myAlbumMenu1 = document.getElementById('myAlbum-menu1');
var myAlbumMenu2 = document.getElementById('myAlbum-menu2');
var open = document.getElementById('open');
var open2 = document.getElementById('open2');

var uploadPhoto1 = document.getElementById('uploadPhoto1');
var uploadPhoto3 = document.getElementById('uploadPhoto3');
var iconChacha1 = document.getElementById('icon-chacha1');
var popLayer = document.getElementById('popLayer');//upload-photos-choose

var uploadPhoto6 = document.getElementById('uploadPhoto6');
var myAlbumContent2Span = myAlbumContent2.getElementsByTagName('span');
var myAlbumContent2Li = myAlbumContent2.getElementsByTagName('div');
var adminButtonMenu = document.getElementById('admin-button-menu');
var adminButtonMenuLi = adminButtonMenu.getElementsByTagName('li');
var chooseGroup = document.getElementById('choose-group');
var button2 = document.getElementById('button2');
var iconChacha11 = document.getElementById('iconChacha11');
var deleteGroupButton1 = document.getElementById('delete-group-button1');
var idArray = new Array();
var ImaNameArray = new Array();

//在首页点击上传照片
uploadPhoto1.onclick = function () {
    document.getElementById('upload-photos').style.display = "block";
    document.getElementById('popLayer').style.display = "block";
    document.getElementById('popLayer2').style.display = "block";
    document.getElementById('upload-photos-choose').style.display = "block";
}
//在相册中点击上传照片
uploadPhoto3.onclick = function () {
    document.getElementById('upload-photos').style.display = "block";
    document.getElementById('popLayer').style.display = "block";
    // document.getElementById('popLayer2').style.display="block";
    // document.getElementById('upload-photos-choose').style.display="block";
}

var uploadPhotosLeft = document.getElementById('upload-photos-left');
var uploadPhotosRight = document.getElementById('upload-photos-right');
var uploadPhotosGroup = document.getElementById('upload-menu-group');
var uploadPhotosGroupLi = uploadPhotosGroup.getElementsByTagName('li');

var bLi = "";
var chooseName = "";
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
        async: false,
        type: "post",
        url: "/pca/album/albumInfo",
        dataType: "json",
        success: function (data) {
            uploadPhotosGroup.style.display = "block"
            var h = "";
            for (var i = 0; i < data.album.length; i++) {
                var albumName = data.album[i].albumName;
                h += "<li class='upload-menu-group-li'>" + albumName + "</li>"
            }
            $("#upload-menu-group").html(h);
            for (var i = 0; i < uploadPhotosGroupLi.length; i++) {
                uploadPhotosGroupLi[i].index = i;
                uploadPhotosGroupLi[i].onclick = function () {
                    str = (function (i) {
                        bLi = uploadPhotosGroupLi[i].innerHTML;
                        uploadPhotosLeft.innerHTML = bLi;
                        return uploadPhotosLeft.innerHTML;
                    })(this.index);
                    uploadPhotosGroup.style.display = "none"
                    uploadPhotosLeft.innerHTML = str;
                    chooseName = str;
                    return chooseName;
                }

            }
        }
    });

});
$("#select-button").click(function () {
    $("#upload-album-choose").html("<span>上传照片至：" + chooseName + "</span>");
    $.ajax({
        type: "post",
        url: "/pca/image/goUpload",
        data: {"albumName": chooseName},
        dataType: "json",
        success: function (data) {

        }
    });
    $("#icon-chacha1").click(function () {
        $("#upload-album-choose").html("<span>上传照片至：</span>");
    });

});
//在相册中点击“上传照片按钮”
$("#uploadPhoto3").click(function () {
    // alert("点击的是："+aName);
    $.ajax({
        type: "post",
        url: "/pca/image/goUpload",
        data: {"albumName": aName},
        dataType: "json",
        success: function (data) {
        }
    });
});

//关闭上传照片
iconChacha1.onclick = function () {
    document.getElementById('upload-photos').style.display = "none";
    document.getElementById('popLayer').style.display = "none";
    uploadPhotosLeft.innerHTML = "我的相册";
    nextTime.style.display = "block";
    nowTime.style.display = "none";
    logOutTime.style.display = "none";

}
//关闭选择相册弹出框
var iconChacha2 = document.getElementById('iconChacha2');
iconChacha2.onclick = function () {
    document.getElementById('upload-photos-choose').style.display = "none";
    document.getElementById('popLayer2').style.display = "none";
    document.getElementById('upload-photos').style.display = "none";
    document.getElementById('popLayer').style.display = "none";
    uploadPhotosLeft.innerHTML = "我的相册";
}
//上传照片下一步
var selectButton = document.getElementById('select-button');
selectButton.onclick = function () {
    document.getElementById('upload-photos-choose').style.display = "none";
    document.getElementById('popLayer2').style.display = "none";
}
//创建相册
var uploadPhoto2 = document.getElementById('uploadPhoto2');//Create-Album
uploadPhoto2.onclick = function () {
    document.getElementById('popLayer2').style.display = "block";
    document.getElementById('Create-Album').style.display = "block";
}
$("input[type='radio']").removeAttr('checked');
$("#Create-Album-button2").click(function () {
    //取消单选框的默认选中
    var albumName = $.trim($("#Create-Album-input").val());
    var theme = $.trim($("#Create-Album-input2").val());
    var jurisdiction = $("input[type='radio']:checked").val();
    $.ajax({
        type: "post",
        url: "/pca/album/createAlbum",
        data: {"albumName": albumName, "theme": theme, "jurisdiction": jurisdiction},
        dataType: "json",
        success: function (data) {
            if (data == 1) {
                alert("新建成功");
                window.location.href = "/pca/user/myAlbum";
            } else {
                alert("该相册已存在，换个名称试试");
                //置空输入框的值
                $("#Create-Album-input").val("");
                $("#Create-Album-input2").val("");
                //取消单选框的默认选中
                $("input[type='radio']").removeAttr('checked');
            }
        }
    });
});
//关闭创建相册
var iconChacha3 = document.getElementById('iconChacha3');
iconChacha3.onclick = function () {
    document.getElementById('popLayer2').style.display = "none";
    document.getElementById('Create-Album').style.display = "none";
}
var CreateAlbumButton1 = document.getElementById('Create-Album-button1');
CreateAlbumButton1.onclick = function () {
    document.getElementById('popLayer2').style.display = "none";
    document.getElementById('Create-Album').style.display = "none";
}

//点击相册
//myAlbum-menu1
// var myAlbumContent=document.getElementById('myAlbum-content');
// var myAlbumContent2=document.getElementById('myAlbum-content2');
// var myAlbumLi=myAlbumContent.getElementsByTagName('li');
// var myAlbumMenu1=document.getElementById('myAlbum-menu1');
// var myAlbumMenu2=document.getElementById('myAlbum-menu2');
// var open=document.getElementById('open');
// var open2=document.getElementById('open2');
var aLi = "";
//首页点击的相册名
var aName = "";
//动态加载首页相册
$().ready(function getAlbum() {
    $.ajax({
        async: false,
        type: "post",
        url: "/pca/album/albumInfo",
        dataType: "json",
        success: function (data) {
            //加载相册 到album页面
            var h = "";
            for (var i = 0; i < data.album.length; i++) {
                var imageNum = data.imageNum[i];
                var albumName = data.album[i].albumName;
                var theme = data.album[i].albumType;
                var coverImg = data.coverList[i].url;
                var createtime = fmtDate(data.album[i].createTime);
                var h4=[];
                var h1="<span class='icon iconfont icon-bukejian quanxian'></span></p>";
                var h2="<span class='icon iconfont icon-kaifangtouming quanxian'></span></p>";
                var h3="<span class='icon iconfont icon-bukejian quanxian'></span></p>";

                if("1"==data.album[i].status){
                	h4[i]=h2;
                }
                else{
                	h4[i]=h1;
                }
                h += "<li class='content-about-li'>"
                    + "<img src='" + coverImg + "'>"
                    + "<div class='content-about-li-top'>"
                    + "<div class='content-about-li-top-a'>"
                    + "<a class='iconfont icon-huishouzhan1 icon1 deleteA'  title='删除相册'></a>"
                   // + "<a class='iconfont icon-fenxiang1 icon2' title='分享相册'></a>"
                    + "<a class='iconfont iconfont icon-point icon1 modeA' title='相册信息'></a>"
                    + "</div>"
                    + "<div class='bottun-title'>"
                    + "<span class='bottun-title-p1' >" + albumName + "</span>"
                    + "<p class='theme'>("+theme+")</p>"
                    + "<p class='bottun-title-p2'>" + createtime + "<i class='iconfont icon-vertical_line'></i>" + imageNum + "图"+h4[i]+"</p>"
                    + "</div>"
                    + "</div>"
                    + "</li>"
                $("#open").html("共" + data.album.length + "个相册");

            }
            $("#myAlbum-content").html(h);
          //删除相册
            var deleteAlbum = document.getElementById('delete-album');
            //var delAlbum2 = document.getElementById('del-album2');
            var deleteAlbumButton1 = document.getElementById('delete-album-button1');
            var iconChacha12 = document.getElementById('iconChacha12');
            $(".deleteA").click(function(){
            	 var text=$(this).parent().siblings().find('span');
            	//获取相册名 alert(text.text())
            	 $("#delete-album").css({ display: "block" });
            	 $("#popLayer2").css({ display: "block" });
            	 var delAlbumName=text.text();
                alert(delAlbumName)
                $.ajax({
                    async: false,
                    type: "post",
                    url: "/pca/album/deleteAlbum",
                    data: {albumName: delAlbumName},
                    dataType: "json",
                    success: function (data) {
                        if (data) {
                            alert("删除成功")
                            // window.location.href="myAlbum";
                            window.location.href = window.location.href;
                        }

                    }
                });
            	});           
            //取消删除
            deleteAlbumButton1.onclick = function(){
            	deleteAlbum.style.display="none";
            	popLayer2.style.display="none";
            }
            //关闭按钮
            iconChacha12.onclick = function(){
            	deleteAlbum.style.display="none";
            	popLayer2.style.display="none";

            }
          //编辑相册
            var modAlbum = document.getElementById('mod-album');
            //var uploadPhoto4 = document.getElementById('uploadPhoto4');
            var closeMod = document.getElementById('close-mod');
            $(".modeA").click(function(){
            	 var text=$(this).parent().siblings().find('span');
            	//获取相册名 alert(text.text())
            	 $("#mod-album").css({ display: "block" });
            	 $("#popLayer2").css({ display: "block" });
            	});   

            closeMod.onclick = function () {
                modAlbum.style.display = "none"; 
                popLayer2.style.display = "none";
            }
            var modifyAlbum = document.getElementById('modifyAlbum');
            var modText = document.getElementById('mod-text');
            var modText2 = document.getElementById('mod-text2');
            var flage=1;
            modifyAlbum.onclick = function(){
            	if(flage==1){
            		modText2.style.display="block";
            		modText.style.display="none";
            		flage=0;
            	}
            	else{
            		modText2.style.display="none";
            		modText.style.display="block";
            		flage=1;
            	}
            }

            
            //点击相册
            for (var i = 0; i < myAlbumLi.length; i++) {
                myAlbumLi[i].index = i;
                myAlbumLi[i].onclick = function () {
                    myAlbumMenu1.style.display = "none";
                    myAlbumContent.style.display = "none";
                    open.style.display = "none";

                    myAlbumMenu2.style.display = "block";
                    myAlbumContent2.style.display = "block";
                    open2.style.display = "block";

                    // str = (function (i) {
                    //     aLi = i;
                    //     return aLi;
                    // })(this.index);
                    // aLi = str;
                    //
                    // var aP = this.getElementsByTagName('p');
                    aName = this.innerHTML;
                    
                    
                    var albumName = aName;
                    $.ajax({
                        async: false,
                        type: "post",
                        url: "/pca/image/getImage",
                        data: {"albumName": albumName},
                        dataType: "json",
                        success: function (data) {
                            var h = "";
                            for (var i = 0; i < data.imageList.length; i++) {
                                var imgUrl = data.imageList[i].url;
                                var imgId = data.imageList[i].id;
                                var imageName = data.imageList[i].imageName;
                                h +=
                                    "<div class='content-about2-li' id='" + imgId + "'>"
                                    + "<form id='image-download-form' action='/pca/image/download'>"
                                    + "<input id='hidden-input' type='hidden' name='image' value='' >"
                                    + "<span id='" + imgId + "' class='icon iconfont photo-admin'name='" + imgUrl + "'>&#xe627;</span>"
                                    + "<a href='" + imgUrl + "' ><img src='" + imgUrl + "'/></a>"
                                    + "</form>"
                                    + "</div>"

                            }
                            $("#open2").html("共" + data.imageList.length + "张照片");
                            $("#myAlbum-content2").html(h);


                            (function ($) {
                                $('body').append('<div id="zoom"><a class="close"></a><a href="#previous" class="previous"></a><a href="#next" class="next"></a><div class="content loading"></div></div>');

                                var zoom = $('#zoom').hide(),
                                    zoomContent = $('#zoom .content'),
                                    overlay = '<div class="overlay"></div>',
                                    zoomedIn = false,
                                    openedImage = null,
                                    windowWidth = $(window).width(),
                                    windowHeight = $(window).height();

                                function open(event) {
                                    if (event) {
                                        event.preventDefault();
                                    }
                                    var link = $(this),
                                        src = link.attr('href');
                                    if (!src) {
                                        return;
                                    }
                                    var image = $(new Image()).hide();
                                    $('#zoom .previous, #zoom .next').show();
                                    if (link.hasClass('zoom')) {
                                        $('#zoom .previous, #zoom .next').hide();
                                    }
                                    if (!zoomedIn) {
                                        zoomedIn = true;
                                        zoom.show();
                                        $('body').addClass('zoomed');
                                    }
                                    zoomContent.html(image).delay(100).addClass('loading');
                                    zoomContent.prepend(overlay);
                                    image.load(render).attr('src', src);
                                    openedImage = link;

                                    function render() {
                                        var image = $(this),
                                            borderWidth = parseInt(zoomContent.css('borderLeftWidth')),
                                            maxImageWidth = windowWidth - (borderWidth * 2),
                                            maxImageHeight = windowHeight - (borderWidth * 2),
                                            imageWidth = image.width(),
                                            imageHeight = image.height();
                                        if (imageWidth == zoomContent.width() && imageWidth <= maxImageWidth && imageHeight == zoomContent.height() && imageHeight <= maxImageHeight) {
                                            show(image);
                                            return;
                                        }
                                        if (imageWidth > maxImageWidth || imageHeight > maxImageHeight) {
                                            var desiredHeight = maxImageHeight < imageHeight ? maxImageHeight : imageHeight,
                                                desiredWidth = maxImageWidth < imageWidth ? maxImageWidth : imageWidth;
                                            if (desiredHeight / imageHeight <= desiredWidth / imageWidth) {
                                                image.width(Math.round(imageWidth * desiredHeight / imageHeight));
                                                image.height(desiredHeight);
                                            } else {
                                                image.width(desiredWidth);
                                                image.height(Math.round(imageHeight * desiredWidth / imageWidth));
                                            }
                                        }
                                        zoomContent.animate({
                                            width: image.width(),
                                            height: image.height(),
                                            marginTop: -(image.height() / 2) - borderWidth,
                                            marginLeft: -(image.width() / 2) - borderWidth
                                        }, 200, function () {
                                            show(image);
                                        });

                                        function show(image) {
                                            image.show();
                                            zoomContent.removeClass('loading');
                                        }
                                    }
                                }

                                function openPrevious() {
                                    var prev = openedImage.parent('div').prev();
                                    if (prev.length == 0) {
                                        prev = $('.gallery div:last-child');
                                    }
                                    prev.find('a').trigger('click');
                                }

                                function openNext() {
                                    var next = openedImage.parent('div').next();
                                    if (next.length == 0) {
                                        next = $('.gallery div:first-child');
                                    }
                                    next.children('a').trigger('click');
                                }

                                function close(event) {
                                    if (event) {
                                        event.preventDefault();
                                    }
                                    zoomedIn = false;
                                    openedImage = null;
                                    zoom.hide();
                                    $('body').removeClass('zoomed');
                                    zoomContent.empty();
                                }

                                function changeImageDimensions() {
                                    windowWidth = $(window).width();
                                    windowHeight = $(window).height();
                                }

                                (function bindNavigation() {
                                    zoom.on('click', function (event) {
                                        event.preventDefault();
                                        if ($(event.target).attr('id') == 'zoom') {
                                            close();
                                        }
                                    });

                                    $('#zoom .close').on('click', close);
                                    $('#zoom .previous').on('click', openPrevious);
                                    $('#zoom .next').on('click', openNext);
                                    $(document).keydown(function (event) {
                                        if (!openedImage) {
                                            return;
                                        }
                                        if (event.which == 38 || event.which == 40) {
                                            event.preventDefault();
                                        }
                                        if (event.which == 27) {
                                            close();
                                        }
                                        if (event.which == 37 && !openedImage.hasClass('zoom')) {
                                            openPrevious();
                                        }
                                        if (event.which == 39 && !openedImage.hasClass('zoom')) {
                                            openNext();
                                        }
                                    });

                                    if ($('.gallery a').length == 1) {
                                        $('.gallery a')[0].addClass('zoom');
                                    }
                                    $('.zoom, .gallery a').on('click', open);
                                })();

                                (function bindChangeImageDimensions() {
                                    $(window).on('resize', changeImageDimensions);
                                })();

                                (function bindScrollControl() {
                                    $(window).on('mousewheel DOMMouseScroll', function (event) {
                                        if (!openedImage) {
                                            return;
                                        }
                                        event.stopPropagation();
                                        event.preventDefault();
                                        event.cancelBubble = false;
                                    });
                                })();
                            })(jQuery);

                            uploadPhoto6.onclick = function () {

                                if (uploadPhoto6.style.color != "rgb(0, 0, 0)") {
                                    uploadPhoto6.style.color = "#000";
                                    uploadPhoto6.style.borderBottom = "2px solid #D84C31";
                                    document.getElementById('admin-button').style.display = "block";
                                    for (var i = 0; i < myAlbumContent2Span.length; i++) {
                                        myAlbumContent2Span[i].style.display = "block";

                                    }
                                    for (var j = 0; j < myAlbumContent2Li.length; j++) {
                                        myAlbumContent2Li[j].style.background = "#000";
                                        myAlbumContent2Li[j].style.opacity = "0.9";

                                    }
                                } else {
                                    uploadPhoto6.style.color = "#9999A6";
                                    uploadPhoto6.style.borderBottom = "";
                                    document.getElementById('admin-button').style.display = "none";
                                    for (var i = 0; i < myAlbumContent2Span.length; i++) {
                                        myAlbumContent2Span[i].style.background = "rgb(255, 255, 255)";
                                        myAlbumContent2Span[i].style.color = "#8b8be8";
                                        myAlbumContent2Span[i].style.display = "none";
                                    }
                                    for (var j = 0; j < myAlbumContent2Li.length; j++) {
                                        myAlbumContent2Li[j].style.background = "";
                                        myAlbumContent2Li[j].style.opacity = "";

                                    }

                                }

                            }
                            //选中

                            for (var i = 0; i < myAlbumContent2Span.length; i++) {
                                myAlbumContent2Span[i].onclick = function () {
                                    //选中照片的id
                                    var id = $(this).attr("id");
                                    //移动的目标相册名
                                    var imageName = $(this).attr("name");
                                    if (this.style.background == "rgb(216, 76, 49)") {
                                        this.style.background = "rgb(255, 255, 255)";
                                        this.style.color = "#8b8be8";
                                        //通过当前下标移除照片id
                                        idArray.splice(i, 1);
                                        ImaNameArray.splice(i, 1)

                                    } else {
                                        this.style.background = "#D84C31";
                                        this.style.color = "rgb(255, 255, 255)";
                                        idArray.push(id);
                                        ImaNameArray.push(imageName);

                                    }
                                }
                            }

                            for (var i = 0; i < adminButtonMenuLi.length; i++) {
                                adminButtonMenuLi[i].onclick = function () {
                                    //alert(this.innerHTML)
                                    document.getElementById('popLayer2').style.display = "block";
                                    document.getElementById('choose-group').style.display = "block";
                                    document.getElementById('choose-group-span').innerHTML = this.innerHTML;
                                }
                            }
                            //移动照片
                            var iconChacha9 = document.getElementById('iconChacha9');
                            iconChacha9.onclick = function () {
                                document.getElementById('popLayer2').style.display = "none";
                                document.getElementById('choose-group').style.display = "none";
                            }
                            var chooseGroupButton1 = document.getElementById('choose-group-button1');
                            chooseGroupButton1.onclick = function () {
                                document.getElementById('popLayer2').style.display = "none";
                                document.getElementById('choose-group').style.display = "none";
                            }
                            //点击删除选中

                            button2.onclick = function () {
                                document.getElementById('popLayer2').style.display = "block";
                                document.getElementById('delete-group').style.display = "block";
                            }
                            iconChacha11.onclick = function () {
                                document.getElementById('popLayer2').style.display = "none";
                                document.getElementById('delete-group').style.display = "none";
                            }
                            deleteGroupButton1.onclick = function () {
                                document.getElementById('popLayer2').style.display = "none";
                                document.getElementById('delete-group').style.display = "none";
                            }
                        }
                    });

                    
                    
                }
                
            }
        }
    });
});
//点击相册，获取对应的相册名传递到后台，并将返回的数据展示到页面

//在左侧导航栏点击“我的相册”时调用相册获取方法
$("#navMenu1").click(function () {
    getAlbum();
});

//上传图片
var uploadPhotosPopContentButton = document.getElementById('upload-photos-pop-content-button');
uploadPhotosPopContentButton.onclick = function () {
    document.getElementById('upload-photos-pop-content-button').style.display = "none";
    document.getElementById('upload-photos-pop-content-footer').style.display = "none";
    document.getElementById('upload-photos-pop-content-footer2').style.display = "block";
}
var magId = 0;

function setImagePreviews() {
    var docobj = document.getElementById("doc" + magId);
    var dd = document.getElementById("dd");
    var fileList = docobj.files;
    for (var i = 0; i < fileList.length; i++) {
        magId++;
        $(dd).append("<div class='img-wrap' imgid='img" + (magId - 1) + "'><img id='img" + (magId - 1) + "'/><span class='closeimg" + (magId - 1) + " close'>×</span><div class='img-button'><p>adhg.jpg</p></div></div>");
        $(".fileinput-wrap [imgid=img" + (magId - 1) + "]")[0].style.position = "absolute";
        $(".fileinput-wrap").append('<input class="inputfile" type="file" name="files" id="doc' + magId + '" imgid="img' + magId + '" onchange="javascript:setImagePreviews()" />');
        $(".fileinput-wrap").append('<label for="doc' + magId + '" class="btn btn-default footer-button1">继续添加</label> ');

        $(".closeimg" + (magId - 1)).on("click", function (e) {
            var id = $(this).parents(".img-wrap").attr("imgid");
            $(this).parent().remove();
            $(".fileinput-wrap input[imgid=" + id + "]").remove();
        })
        var imgObjPreview = document.getElementById("img" + (magId - 1));
        if (docobj.files && docobj.files[i]) {
            imgObjPreview.style.display = "block";
            imgObjPreview.src = window.URL.createObjectURL(docobj.files[i]);
        } else {
            docobj.select();
            var imgsrc = document.selection.createRange().text;
            var localImageId = document.getElementById("img" + (magId - 1));
            try {
                localIamgeId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                localIamgeId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgsrc;
            } catch (e) {
                alert("上传图片出错")
                return false;
            }
            imgObjPreview.style.display = "none";
            document.selection.empty();
        }
    }
    return true;
}

//时间格式处理，将时间戳转换成yyyy-mm-dd格式
function fmtDate(obj) {
    var date = new Date(obj);
    var y = 1900 + date.getYear();
    var m = "0" + (date.getMonth() + 1);
    var d = "0" + date.getDate();
    return y + "-" + m.substring(m.length - 2, m.length) + "-" + d.substring(d.length - 2, d.length);
}


//相册排序
var albumSort = document.getElementById('album-sort');
var albumSortLi = albumSort.getElementsByTagName('li');
var albumSortWay = "";
for (var i = 0; i < albumSortLi.length; i++) {
    albumSortLi[i].onclick = function () {
        albumSortWay = this.innerHTML;
        var url = "";
        if (albumSortWay == "按相册名称排序") {
            url = "/pca/album/sortByName";
        } else if (albumSortWay == "按相册主题排序") {
            url = "/pca/album/sortByTheme";
        } else if (albumSortWay == "按更新时间排序") {
            url = "/pca/album/sortByTime";
        } else {
            url = "/pca/album/albumInfo";
        }
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            success: function (data) {
                //加载相册 到album页面
                var h = "";
                for (var i = 0; i < data.album.length; i++) {
                    var imageNum = data.imageNum[i];
                    var albumName = data.album[i].albumName;
                    var theme = data.album[i].albumType;
                    var coverImg = data.coverList[i].url;
                    var createtime = fmtDate(data.album[i].createTime);
                    var h4=[];
                    var h1="<span class='icon iconfont icon-bukejian quanxian'></span></p>";
                    var h2="<span class='icon iconfont icon-kaifangtouming quanxian'></span></p>";
                    var h3="<span class='icon iconfont icon-bukejian quanxian'></span></p>";
                    if("1"==data.album[i].status){
                        h4[i]=h2;
                    }
                    else{
                        h4[i]=h1;
                    }
                    h += "<li class='content-about-li'>"
                        + "<img src='" + coverImg + "'>"
                        + "<div class='content-about-li-top'>"
                        + "<div class='content-about-li-top-a'>"
                        + "<a  class='iconfont icon-huishouzhan1 icon1' onclick='delAlbum2()' title='删除相册'></a>"
                        //+ "<a class='iconfont icon-fenxiang1 icon2' title='分享相册'></a>"
                        + "<a class='iconfont iconfont icon-point icon1' onclick='uploadPhoto4()' title='相册信息'></a>"
                        + "</div>"
                        + "<div class='bottun-title'>"
                        + "<span class='bottun-title-p1'>" + albumName + "</span>"
                        + "<p class='theme'>("+theme+")</p>"
                        + "<p class='bottun-title-p2'>" + createtime + "<i class='iconfont icon-vertical_line'></i>" + imageNum + "图"+h4[i]+"</p>"
                        + "</div>"
                        + "</div>"
                        + "</li>"
                    $("#open").html("共" + data.album.length + "个相册");

                }
                $("#myAlbum-content").html(h);
                
                for (var i = 0; i < myAlbumLi.length; i++) {
                    myAlbumLi[i].index = i;
                    myAlbumLi[i].onclick = function () {
                        myAlbumMenu1.style.display = "none";
                        myAlbumContent.style.display = "none";
                        open.style.display = "none";

                        myAlbumMenu2.style.display = "block";
                        myAlbumContent2.style.display = "block";
                        open2.style.display = "block";

                        // str = (function (i) {
                        //     aLi = i;
                        //     return aLi;
                        // })(this.index);
                        // aLi = str;
                        //
                        // var aP = this.getElementsByTagName('p');
                        //aName = this.innerHTML;
                    }

                }
               
            }
        });
    }
}


// //时间控件
// function nextTimes(){
var myDate = new Date(), Y = myDate.getFullYear(), M = myDate.getMonth() + 1, D = myDate.getDate(),
    H = myDate.getHours(), S = myDate.getMinutes();
var M2 = M + 1;
//处理月是一位的情况
if ((M + '').length == 1) {
    M = '0' + (M + '');
}
if ((M2 + '').length == 1) {
    M2 = '0' + (M2 + '');
}
//处理日是一位的情况
if ((D + '').length == 1) {
    D = '0' + (D + '')
}
var curDay = Y + '-' + M + '-' + D;
var curDay2 = Y + '-' + M2 + '-' + D;
var hou = H + ':' + S;
// console.log(curDay2)
$('#logOutTime').val(curDay + 'T' + hou)
$("#logOutTime").attr("min", curDay + 'T' + hou)
$("#logOutTime").attr("max", curDay2 + 'T' + hou)


//选择上传
var sendStyleLi1 = document.getElementById('send-style-li1');
var sendStyleLi2 = document.getElementById('send-style-li2');
var logOutTime = document.getElementById('logOutTime');
var nowTime = document.getElementById('nowTime');
var nextTime = document.getElementById('nextTime');
//定时上传
sendStyleLi1.onclick = function () {
    nextTime.style.display = "none";
    nowTime.style.display = "block";
    logOutTime.style.display = "block";
}
$("#nowTime").click(function () {
    $("#upload-form").submit();
});
//实时上传
sendStyleLi2.onclick = function () {
    nextTime.style.display = "block";
    nowTime.style.display = "none";
    logOutTime.style.display = "none";
}

$("#button1").click(function () {
    $.ajax({
        async: false,
        type: "post",
        url: "/pca/album/albumInfo",
        dataType: "json",
        success: function (data) {
            uploadPhotosGroup.style.display = "block"
            var h = "";
            for (var i = 0; i < data.album.length; i++) {
                var albumName = data.album[i].albumName;
                h += "<li id='batch-button' class='album-sort-li'>" + albumName + "</li>"
            }
            $("#admin-button-menu").html(h);
        }

    });
});


$("#admin-button-menu").on('mouseenter', function () {
    $(".album-sort-li").click(function () {
        if (idArray.length == 0) {
            alert("您还未选择照片");
        } else {

            var Uarry = $("#admin-button-menu li");
            var count = $(this).index();
            var album = Uarry.eq(count).text();
            $("#choose-group-span").html(album);
            document.getElementById('choose-group').style.display = "block";
            $(".Create-Album-button2").click(function () {
                $.ajax({
                    async: false,
                    type: "post",
                    url: "/pca/image/moveImage",
                    //true传递数组
                    traditional: true,
                    data: {imageId: idArray, albumName: album},
                    dataType: "json",
                    success: function (data) {
                        if (data) {
                            alert("移动成功")
                            document.getElementById('choose-group').style.display = "none";
                            window.location.href = window.location.href;
                        } else {
                            alert("移动失败")
                            document.getElementById('choose-group').style.display = "none";
                            window.location.href = window.location.href;
                        }
                    }

                });
            });
        }
    })

});

function deleteImg() {
    $.ajax({
        async: false,
        type: "post",
        url: "/pca/image/deleteImage",
        data: {imageId: idArray, aName: aName},
        traditional: true,
        dataType: "json",
        success: function (data) {
            if (data) {
                alert("删除成功")
                // window.location.href="myAlbum";
                window.location.href = window.location.href;
            }

        }
    });
}

function downLoadImg() {
    var arr = new Array();
    $.each(ImaNameArray, function (index, value) {
        //拼接照片的完整路径
        var imagePath = "D:/demos" + value;
        arr.push(imagePath);
    });
    $("#hidden-input").val(arr);
    $("#image-download-form").submit();
    $("#uploadPhoto6").click();
}

//$("#mod-radio2").click(function () {
//    var type=$("input[type='radio']:checked").val();
//    if(type=="公开"){
//    	$("#part").css({ display: "block" });
//    }
//    else{
//    	$("#part").css({ display: "none" });
//    }
//});
//部分可见
//$("#part").click(function () {
//	$(".Partially-visible").css({ display: "block" });
//});
$("#selectStyle2").change(function(){
	alert($(this).children('option:selected').val()); 
	var text=$(this).children('option:selected').val();
	if(text=="部分可见"){
		$(".Partially-visible").css({ display: "block" });
		$(".Partially-visible-top-title").text("权限设置:部分可见");
		$(".allfrinedP2").text("当前部分可见");
	}
	else if(text=="部分不可见"){
		$(".Partially-visible").css({ display: "block" });
		$(".Partially-visible-top-title").text("权限设置:部分不可见");
		$(".allfrinedP2").text("当前部分不可见");
	}
})
$("#selectStyle").change(function(){
	alert($(this).children('option:selected').val()); 
	var text=$(this).children('option:selected').val();
	if(text=="部分可见"){
		$(".Partially-visible").css({ display: "block" });
		$(".Partially-visible-top-title").text("权限设置:部分可见");
		$(".allfrinedP2").text("当前部分可见");
	}
	else if(text=="部分不可见"){
		$(".Partially-visible").css({ display: "block" });
		$(".Partially-visible-top-title").text("权限设置:部分不可见");
		$(".allfrinedP2").text("当前部分不可见");
	}
})

//关闭部分可见
$(".Partially-visible-top1").click(function () {
	$(".Partially-visible").css({ display: "none" });
});
//点击部分可见全选
function PartiallyVisibleAll() {
    var flag = document.getElementById("allP").checked;
    var cks = document.getElementsByName("friend"); 
    if (flag) { 
        for ( var i = 0; i < cks.length; i++) { 
            cks[i].checked = true;  
        }
    }
    else {
        for ( var i = 0; i < cks.length; i++) { 
            cks[i].checked = false;       
        }
    }  
}
//选中封装数组
$(document).ready(function(){
	   $('.Partially-visible-top2').click(function(){
	        var checkID = [];//定义一个空数组 
	        $("input[name='friend']:checked").each(function(i){//把所有被选中的复选框的值存入数组
	            checkID[i] =$(this).val();
	        }); 
		   console.log(checkID);
	    })
	});

