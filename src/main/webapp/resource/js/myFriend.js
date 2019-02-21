function selectOnde(permissionType) {

    alert(permissionType);
    // if (permissionType==0){
    //     url="/pca/friend/selectMyFriend";
    //     alert(url);
    // }else if (permissionType==1){
    //     url="/pca/friend/selectMyFamily"
    //     alert(url);
    // } else if (permissionType==2){
    //     url="/pca/friend/selectMyClassmate";
    //     alert(url);
    // } else {
    //     url="/pca/friend/selectMyStranger";
    //     alert(url);
    // }
    $.ajax({
        type:"POST",
        // url:url,
        url:"/pca/friend"+"/"+permissionType,
        data:{"permissionType":permissionType},
        dataType: "json",
        complete:function(result) {

        }
    });

}
