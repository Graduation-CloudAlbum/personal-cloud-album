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

for(var i=0;i<myAlbumLi.length;i++){
	myAlbumLi[i].onclick=function(){
		myAlbumMenu1.style.display="none";
		myAlbumMenu2.style.display="block";
		myAlbumContent.style.display="none";
		myAlbumContent2.style.display="block";
		open.style.display="none";
		open2.style.display="block";
	}
}

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




