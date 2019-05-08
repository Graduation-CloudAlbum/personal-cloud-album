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

                    document.getElementById('photo-header').style.display="block";
                    document.getElementById('photo-header1').innerHTML="相册:"+aName

               
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
                                        //为空
                                      //为空
                                       //$(".content-about-li").click(function(){
                                        	
                                    		if($(".content-about2-li").length>0){
                                    			//alert($(".content-about2-li").length)
                                    			//$(".myAlbum-content2").css({ display: "block" });
                                        		$(".photo1").css({ display: "none" });
                                        		$("#open2").css({ display: "block" });
                                        		$(".content-button-fenge").css({ display: "block" });
                                    		}
                                    		else{
                                    			//alert($(".content-about2-li").length)
                                    			//$(".myAlbum-content2").css({ display: "none" });
                                        		$(".photo1").css({ display: "block" });
                                        		$("#open2").css({ display: "none" });
                                        		$(".content-button-fenge").css({ display: "none" });
                                    		}
                                    	//})
                                       
                                    
                                        (function($) {
                                            $('body').append('<div id="zoom"><a class="close"></a><a href="#previous" class="previous"></a><a href="#next" class="next"></a><div class="content loading"></div></div>');

                                            var zoom = $('#zoom').hide(),
                                                zoomContent = $('#zoom .content'),
                                                overlay = '<div class="overlay"></div><i style="position: absolute;bottom: 5px;left: 5px;font-size: 20px; color: #fff;">1024Album</i>',
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
                                                            desiredWidth  = maxImageWidth  < imageWidth  ? maxImageWidth  : imageWidth;
                                                        if ( desiredHeight / imageHeight <= desiredWidth / imageWidth ) {
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
                                                    }, 200, function() {
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
                                                zoom.on('click', function(event) {
                                                    event.preventDefault();
                                                    if ($(event.target).attr('id') == 'zoom') {
                                                        close();
                                                    }
                                                });

                                                $('#zoom .close').on('click', close);
                                                $('#zoom .previous').on('click', openPrevious);
                                                $('#zoom .next').on('click', openNext);
                                                $(document).keydown(function(event) {
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
                                                $(window).on('mousewheel DOMMouseScroll', function(event) {
                                                    if (!openedImage) {
                                                        return;
                                                    }
                                                    event.stopPropagation();
                                                    event.preventDefault();
                                                    event.cancelBubble = false;
                                                });
                                            })();
                                        })(jQuery);


                                    }
                                });
                            }else{
                                alert("对不起，您没有权限！");
                            }
                        }
                    });




                }
            }
            
	          $("#photo-header2").click(function(){
	        	$("#myAlbum-content2").css({ display: "none" });
        		$("#myAlbum-content").css({ display: "block" });
        		$("#open2").css({ display: "none" });
        		$("#open").css({ display: "block" });
        		$(".photo1").css({ display: "none" });
        		$("#photo-header").css({ display: "none" });
        		$(".content-button-fenge").css({ display: "block" });
	    		
	    	})
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



//移动好友
var deleteFriendsButton2 = document.getElementById('delete-friends-button2');
var moveFriendsButton2 = document.getElementById('move-friends-button2');
var moveFriendsGroup = document.getElementById('moveFriends-group');
var moveFriends = document.getElementById('move-friends');
var friendGroup = document.getElementById('friend-group');
var friendGroupLi = friendGroup.getElementsByTagName('li');
var moveFriendsButton1 = document.getElementById('move-friends-button1');
var iconChacha11 = document.getElementById('iconChacha11');
var fLi=""
var friendsGroupName="";
for(var i=0; i<friendGroupLi.length;i++){
    friendGroupLi[i].index = i;
    friendGroupLi[i].onclick = function(){
        moveFriends.style.display="block";
        popLayer2.style.display="block";
        str = (function(i){
            fLi=friendGroupLi[i].innerHTML;
            moveFriendsGroup.innerHTML=fLi;
            return moveFriendsGroup.innerHTML;
        })(this.index);
        moveFriendsGroup.innerHTML=str
        friendsGroupName=str;
    }
}
//删除好友
deleteFriendsButton2.onclick = function(){
    window.location.href="/pca/friend/deleteFriends";
    alert("删除成功！");
}
//移动好友
moveFriendsButton2.onclick = function(){
    $.ajax({
        type: "post",
        url:"/pca/friend/moveFriends",
        data: {"friendsGroupName": friendsGroupName},
        dataType: "json",
        success: function (data) {
            alert("移动好友成功");
            moveFriends.style.display="none";
            popLayer2.style.display="none";
        }
    });
}
moveFriendsButton1.onclick = function(){
    moveFriends.style.display="none";
    popLayer2.style.display="none";
}
iconChacha11.onclick = function(){
    moveFriends.style.display="none";
    popLayer2.style.display="none";
}

//删除好友
var deleteFriends = document.getElementById('delete-friends');
var deleteFriendsPop = document.getElementById('delete-friends-pop');
var deleteFriendsButton1 = document.getElementById('delete-friends-button1');
var iconChacha12 = document.getElementById('iconChacha12');
deleteFriends.onclick = function(){
    deleteFriendsPop.style.display = "block";
    popLayer2.style.display="block";
}
deleteFriendsButton1.onclick = function(){
    deleteFriendsPop.style.display="none";
    popLayer2.style.display="none";
}
iconChacha12.onclick = function(){
    deleteFriendsPop.style.display="none";
    popLayer2.style.display="none";
}