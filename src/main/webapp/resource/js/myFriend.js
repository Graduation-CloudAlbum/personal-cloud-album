function selectOnde(permissionType) {
    if (permissionType==("我的好友")){
        window.location.href="/pca/friend/selectMyFriend"
    }else if (permissionType==("我的家人")){
        window.location.href="/pca/friend/selectMyFamily"
    } else if (permissionType==("我的同事")){
        window.location.href="/pca/friend/selectMyColleague"
    } else if (permissionType==("我的同学")){
        window.location.href="/pca/friend/selectMyClassmate"
    } else {
        window.location.href="/pca/friend/selectMyStranger"
    }
}
