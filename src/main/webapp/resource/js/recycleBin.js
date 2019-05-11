var recycleTable = document.getElementById('recycle-table');
var recycleTableTr = recycleTable.getElementsByTagName('tr');
//点击勾勾

function dianjigou() {
    var flag = document.getElementById("all").checked;
    var cks = document.getElementsByName("photo"); 
    if (flag) { 
        for ( var i = 0; i < cks.length; i++) { 
            cks[i].checked = true;  
        }
        document.getElementById('table-header5').style.display="block";
    }
    else {
        for ( var i = 0; i < cks.length; i++) { 
            cks[i].checked = false;       
        }
        document.getElementById('table-header5').style.display="none";
    }  
    
    for(var i=0;i<recycleTableTr.length;i++){
        //var aInput=this.document.getElementsByTagName('input')
    	var aInput=this.document.getElementsByName('photo')
        for(var j=0;j<aInput.length;j++){
            aInput[j].onchange = function(){
                document.getElementById('table-header5').style.display="block";
            }
        }
    }
}

//清空回收站
var deleteAll = document.getElementById('deleteAll');
deleteAll.onclick = function(){
    document.getElementById('delete-recycle').style.display="block";
    document.getElementById('popLayer2').style.display="block";
}
//删除选中
var button2 = document.getElementById('button2');
button2.onclick = function(){
    document.getElementById('delete-recycle2').style.display="block";
    document.getElementById('popLayer2').style.display="block";
}
//删除选中 -> 取消
var iconChacha3 = document.getElementById('iconChacha3');
var deleteRecycleButton3 = document.getElementById('delete-recycle-button3');
iconChacha3.onclick = function(){
    document.getElementById('delete-recycle2').style.display="none";
    document.getElementById('popLayer2').style.display="none";
    document.getElementById("delete-recycle-input2").value="";
}
deleteRecycleButton3.onclick = function(){
    document.getElementById('delete-recycle2').style.display="none";
    document.getElementById('popLayer2').style.display="none";
    document.getElementById("delete-recycle-input2").value="";
}
//清空回收站 -> 取消
var iconChacha1 = document.getElementById('iconChacha1');
var deleteRecycleButton1 = document.getElementById('delete-recycle-button1');
iconChacha1.onclick = function(){
    document.getElementById('delete-recycle').style.display="none";
    document.getElementById('popLayer2').style.display="none";
    document.getElementById("delete-recycle-input").value="";
}
deleteRecycleButton1.onclick = function(){
    document.getElementById('delete-recycle').style.display="none";
    document.getElementById('popLayer2').style.display="none";
    document.getElementById("delete-recycle-input").value="";
}
//还原回收站
var updateAll = document.getElementById('updateAll');
updateAll.onclick = function(){
    document.getElementById('update-recycle').style.display="block";
    document.getElementById('popLayer2').style.display="block";
}
var iconChacha2 = document.getElementById('iconChacha2');
var updateRecycleButton1 = document.getElementById('update-recycle-button1');
//还原回收站 ->取消

iconChacha2.onclick = function(){
    document.getElementById('update-recycle').style.display="none";
    document.getElementById('popLayer2').style.display="none";
    document.getElementById('select-jiantou').style.color="#E0E0E0";
}
updateRecycleButton1.onclick = function(){
    document.getElementById('update-recycle').style.display="none";
    document.getElementById('popLayer2').style.display="none";
    document.getElementById('select-jiantou').style.color="#E0E0E0";
}
//还原选中
var button1 = document.getElementById('button1');
button1.onclick = function(){
    document.getElementById('update-recycle2').style.display="block";
    document.getElementById('popLayer2').style.display="block";
}
//还原选中 -> 取消
var iconChacha4 = document.getElementById('iconChacha4');
var updateRecycleButton2 = document.getElementById('update-recycle-button2');


iconChacha4.onclick = function(){
    document.getElementById('update-recycle2').style.display="none";
    document.getElementById('popLayer2').style.display="none";
}
updateRecycleButton2.onclick = function(){
    document.getElementById('update-recycle2').style.display="none";
    document.getElementById('popLayer2').style.display="none";
}
//恢复选中
var updateRecycleButton3=document.getElementById("update-recycle-button3");
updateRecycleButton3.onclick = function(){
    obj=document.getElementsByName("photo")
    check_val=[];
    for (k in obj){
        if(obj[k].checked){
            check_val.push(obj[k].value);
        }
    }

    $.ajax({
        async :false,
        type: "post",
        url: "/pca/recycleBin/someImageRecovery",
        data:{check_val:check_val},
        dataType: "json",
        success: function (data) {
            if(data){
                alert("还原成功！")
                window.location.href="/pca/recycleBin/myRecycleBin"
            }else {
                alert("还原所需空间不足，还原失败！")
                window.location.href="/pca/recycleBin/myRecycleBin"
            }

        }
    });
}
//删除选中
var deleteRecycleInput2 ;
var updateRecycleButton4=document.getElementById("delete-recycle-button4");
updateRecycleButton4.onclick = function(){
    deleteRecycleInput2=$("#delete-recycle-input2").val();
    obj=document.getElementsByName("photo")
    check_val=[];
    for (k in obj){
        if(obj[k].checked){
            check_val.push(obj[k].value);
        }
    }
    $.ajax({
        async :false,
        type: "post",
        url: "/pca/recycleBin/deleteSomeRecycleBin/"+deleteRecycleInput2,
        data:{check_val:check_val},
        dataType: "json",
        success: function (data) {
            if (data){
                alert("删除成功！")
                window.location.href="/pca/recycleBin/myRecycleBin"
            }
            else{
                alert("密码错误，请重新输入")
            }
        }
    });
}


var deleteRecycleInput;
var updateRecycleButton5=document.getElementById("delete-recycle-button5");
updateRecycleButton5.onclick = function(){
    deleteRecycleInput=$("#delete-recycle-input").val();
    $.ajax({
        async :false,
        type: "post",
        url: "/pca/recycleBin/deleteAllRecycleBin/"+deleteRecycleInput,
        dataType: "json",
        success: function (data) {
            if (data==true){
                alert("清空回收站成功！")
                window.location.href="/pca/recycleBin/myRecycleBin"
            }
            else{
                alert("密码错误，请重新输入")
            }
        }
    });
}


var updateRecycleButton6=document.getElementById("recover-recycle-button6");
updateRecycleButton6.onclick = function(){
    $.ajax({
        async :false,
        type: "post",
        url: "/pca/recycleBin/recoverAllRecycleBin",
        dataType: "json",
        success: function (data) {
            if(data==true){
                alert("还原成功！")
                window.location.href="/pca/recycleBin/myRecycleBin"
            }else {
                alert("还原所需空间不足，还原失败！")
                window.location.href="/pca/recycleBin/myRecycleBin"
            }
        }
    });
}


//查看大图
$(function(){  
    $(".pimg").click(function(){  
        var _this = $(this);//将当前的pimg元素作为_this传入函数  
        imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);  
    });   
});  
$(function(){    
    $(".pimg2").click(function(){  
        var _this = $(this).parent().siblings().find(".pimg");//将当前的pimg元素作为_this传入函数  
        imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);  
    });  
}); 
function imgShow(outerdiv, innerdiv, bigimg, _this){  
    var src = _this.attr("src");//获取当前点击的pimg元素中的src属性  
    $(bigimg).attr("src", src);//设置#bigimg元素的src属性  
  
        /*获取当前点击图片的真实大小，并显示弹出层及大图*/  
    $("<img/>").attr("src", src).load(function(){  
        var windowW = $(window).width();//获取当前窗口宽度  
        var windowH = $(window).height();//获取当前窗口高度  
        var realWidth = this.width;//获取图片真实宽度  
        var realHeight = this.height;//获取图片真实高度  
        var imgWidth, imgHeight;  
        var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放  
          
        if(realHeight>windowH*scale) {//判断图片高度  
            imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放  
            imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度  
            if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度  
                imgWidth = windowW*scale;//再对宽度进行缩放  
            }  
        } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度  
            imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放  
                        imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度  
        } else {//如果图片真实高度和宽度都符合要求，高宽不变  
            imgWidth = realWidth;  
            imgHeight = realHeight;  
        }  
                $(bigimg).css("width",imgWidth);//以最终的宽度对图片缩放  
          
        var w = (windowW-imgWidth)/2;//计算图片与窗口左边距  
        var h = (windowH-imgHeight)/2;//计算图片与窗口上边距  
        $(innerdiv).css({"top":h, "left":w});//设置#innerdiv的top和left属性  
        $(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg  
    });  
      
    $(outerdiv).click(function(){//再次点击淡出消失弹出层  
        $(this).fadeOut("fast");  
    });  
}  
//为空
$(document).ready(function(){
	if($("#recycle-table tr").length>1){
		$(".recycle-table").css({ display: "block" });
		$(".content-about5").css({ display: "none" });
	}
	else{
		$(".recycle-table").css({ display: "none" });
		$(".content-about5").css({ display: "block" });
	}
});
