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
}
for(var i=0;i<recycleTableTr.length;i++){
    var aInput=this.document.getElementsByTagName('input')
    for(var j=1;j<aInput.length;j++){
        aInput[j].onchange = function(){
            document.getElementById('table-header5').style.display="block";
        }
    }
}

// for(var i=1; i<recycleTableTr.length; i++){
//     var recycleTableTrButton1 = recycleTableTr[i].getElementsByTagName('td');
//     var recycleTableTrButton = recycleTableTrButton1[6].getElementsByTagName('button');
//     //点击查看
//     recycleTableTrButton[0].onclick = function(){
//         document.getElementById('see-photo').style.display="block";
        
//     }
//     //点击删除
//     recycleTableTrButton[1].onclick = function(){

//     }
//     //点击还原
//     recycleTableTrButton[2].onclick = function(){

//     }
// }
// var iconChacha3 = document.getElementById('iconChacha3');
// iconChacha3.onclick = function(){
//     document.getElementById('see-photo').style.display="none";
//     document.getElementById('popLayer2').style.display="block";
// }
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
            alert("还原成功")
            window.location.href="/pca/recycleBin/myRecycleBin"
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
            if (data){
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
            if (data){
                alert("还原成功！")
                window.location.href="/pca/recycleBin/myRecycleBin"
            }
            else{
                alert("还原失败！")
            }
        }
    });
}
