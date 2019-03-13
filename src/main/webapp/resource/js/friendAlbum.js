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