    $("#logout").confirm({
        title: '',
        content: '确定要退出吗',
        // btnClass: 'btn-blue',
        buttons: {
            确定:function () {
                return $.ajax({
                    url: '/pca/user/logOut',
                    dataType: 'json',
                    method: 'get'
                }).done(function () {
                    location.href = "/pca/user/index";
                }).fail(function(){
                    location.href = "/pca/user/index";
                });
            },
            取消:function () {

            }
        }
    });
