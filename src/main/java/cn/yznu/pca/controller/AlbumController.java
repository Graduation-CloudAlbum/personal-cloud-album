package cn.yznu.pca.controller;
import cn.yznu.pca.model.User;
import cn.yznu.pca.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangbaiwan
 * @date 2018-09-28
 */
@Controller
@RequestMapping("/album")
public class AlbumController {
    //@Autowired
    //private AlbumService albumService;
    //
    ///**
    // * 相册个数
    // * @return
    // */
    //@RequestMapping("/albumNum")
    //public  String   AlbumNum(){
    //    User user=new User();
    //    int mun=albumService.getAlbumNum(user.getId());
    //    return  "";
    //}
}
