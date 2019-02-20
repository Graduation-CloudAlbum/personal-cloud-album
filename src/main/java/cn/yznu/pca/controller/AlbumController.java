package cn.yznu.pca.controller;
import cn.yznu.pca.model.Album;
import cn.yznu.pca.model.User;
import cn.yznu.pca.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author yangbaiwan
 * @date 2018-09-28
 */
@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    /**
     * 相册相关信息
     * @return
     */
    @RequestMapping("/albumInfo")
    public  String   AlbumInfo(HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        List albumlist =albumService.getAlbumInfo(user.getId());
       // System.out.println("albumSize"+albumlist.size()+albumlist.listIterator());
        for(int i = 0 ; i < albumlist.size() ; i++) {
           // System.out.println(albumlist.get(i));
            Album album= (Album) albumlist.get(i);
            System.out.println(album.getAlbumName());
            request.getSession().setAttribute("album",album);
        }

        return  "myAlbum";
    }
}
