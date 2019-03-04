package cn.yznu.pca.controller;
import cn.yznu.pca.model.Album;
import cn.yznu.pca.model.User;
import cn.yznu.pca.service.AlbumService;
import cn.yznu.pca.service.ImageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    @Autowired
    private ImageService imageService;

    /**
     * 首页展示的相册（查看相册）
     * @return
     */
    @RequestMapping("/albumInfo")
    @ResponseBody
    public  Map<String,Object>   AlbumInfo( HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        List albumlist =albumService.getAlbum(user.getId());
        Map<String,Object> map=new HashMap<>();
        int albumId=0;
        List list=new ArrayList();
        for(int i = 0; i < albumlist.size() ; i++) {
            Album album= (Album) albumlist.get(i);
             albumId=album.getId();
             //用户某个相册下照片数量
            int imageNum=imageService.imageNum(user.getId(),albumId);
            list.add(imageNum);
        }
        //所有相册数量
        //int allAlbumNum=albumService.getAlbumNum(user.getId());
        //所有照片数量
        //int allImageNum=imageService.getAllImageNum(user.getId());
        map.put("album",albumlist);
        map.put("imageNum",list);
        //map.put("allAlbumNum",allAlbumNum);
        //map.put("allImageNum",allImageNum);
        return  map;

    }

    /**
     * 新建相册
     * @param albumName 相册名
     * @param request
     * @return
     */
    @RequestMapping("/createAlbum")
    @ResponseBody
    public int createAlbum(@Param("albumName") String albumName, HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        int userId=user.getId();
        Album album=new Album();
        album.setAlbumName(albumName);
        album.setUserId(userId);
        List albumlist=albumService.selectAlbumByName(userId,albumName);
        //大于0表示相册名已存在
        if (albumlist.size()>0){
            return 0;
        }else{
            //创建相册
            albumService.createAlbum(album);
            return 1;
        }

    }

    /**
     * 删除相册，采用逻辑删除方式，删除后置于回收站
     * @param albumName
     * @param request
     * @return
     */
    @RequestMapping("/deleteAlbum")
    @ResponseBody
    public int deleteAlbum(@Param("albumName") String albumName, HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        List albumlist =albumService.getAlbum(user.getId());
        Album album= (Album) albumlist.get(0);
        int albumId=album.getId();




        return 0;
    }

    /**
     * 相册重命名
     * @param newAlbumName
     * @param request
     * @return
     */
    @RequestMapping("/updateAlbum")
    @ResponseBody
    public int updateAlbum(@Param("newAlbumName") String newAlbumName, HttpServletRequest request){
        return 0;
    }
}
