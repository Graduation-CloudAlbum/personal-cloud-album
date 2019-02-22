package cn.yznu.pca.controller;
import cn.yznu.pca.model.User;
import cn.yznu.pca.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ResponseBody
    public  Map<String,Object>   AlbumInfo(HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        List albumlist =albumService.getAlbumInfo(user.getId());
        Map<String,Object> map=new HashMap<String, Object>();
        //for(int i = 0 ; i < albumlist.size() ; i++) {
        //    Album album= (Album) albumlist.get(i);
        //    System.out.println(album.getAlbumName());
        //    request.getSession().setAttribute("album",album);
        //}
        map.put("album",albumlist);
        return  map;

    }
}
