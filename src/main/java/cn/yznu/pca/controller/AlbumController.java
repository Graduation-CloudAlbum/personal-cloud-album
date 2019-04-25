package cn.yznu.pca.controller;
import cn.yznu.pca.model.*;
import cn.yznu.pca.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

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
    @Autowired
    private UserService userService;
    @Autowired
    private RecycleBinService recycleBinService;
    @Autowired
    private UserPromissionService userPromissionService;

    /**
     * 首页展示的相册（查看相册）
     * @return
     */
    @RequestMapping("/albumInfo")
    @ResponseBody
    public  Map<String,Object>   AlbumInfo(HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        List albumlist=albumService.getAlbum(user.getId());
        Map<String,Object> map=new HashMap<>();
        int albumId=0;
        List list=new ArrayList();
        List coverList=new ArrayList();
        for(int i = 0; i < albumlist.size() ; i++) {
            Album album= (Album) albumlist.get(i);
            albumId=album.getId();
             //用户某个相册下照片数量
            int imageNum=imageService.imageNum(user.getId(),albumId);
            //获取每个相册下最近一张照片作为相册封面展示图
            Image coverImage=imageService.getFirstOne(user.getId(),albumId);
            //若该相册内没有照片，则使用系统默认相册封面图
            if (coverImage==null){
                coverImage=new Image();
                coverImage.setUrl("/upload/Album-cover3.jpg");
            }
            coverList.add(coverImage);
            list.add(imageNum);
        }

        map.put("album",albumlist);
        map.put("imageNum",list);
        map.put("coverList",coverList);
        return  map;
    }
    @ResponseBody
    @RequestMapping("selectOneAlbum")
    public Object selectOneAlbum(@Param("albumName") String albumName,HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        int userId=user.getId();
        List list=albumService.selectAlbumByName(userId,albumName);
        Album album=(Album) list.get(0);
        int albumId=album.getId();
        List<UserPromission> list1=userPromissionService.selectByAlbumId(albumId);
        if (list1.size()!=0){
            album.setStatus("3");
            System.out.println("status is :"+album.getStatus());
            return album;
        }else {
            return album;
        }

    }

    /**
     * 新建相册
     * @param albumName 相册名
     * @param theme 主题
     * @param theme 权限
     * @param request
     * @return
     */
    @RequestMapping("/createAlbum")
    @ResponseBody
    public int createAlbum(@Param("albumName") String albumName,@Param("theme") String theme,
                           @Param("jurisdiction") String  jurisdiction, HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        int userId=user.getId();
        String sta="";
        String jsd1="全部可见";
        String jsd2="仅自己可见";
        //String jsd3="部分可见";
        if (jurisdiction.equals(jsd1)){
             sta="0";
        }else if (jurisdiction.equals(jsd2)){
            sta="1";
        }
        Album album=new Album();
        album.setAlbumName(albumName);
        album.setUserId(userId);
        album.setStatus(sta);
        album.setAlbumType(theme);
        List albumlist=albumService.selectAlbumByName(userId,albumName);
        //大于0表示相册名已存在，不可使用，返回0
        if (albumlist.size()>0){
            return 0;
        }else{
            //否则表示相册名可用，创建相册，返回1
            albumService.createAlbum(album);
            return 1;
        }

    }

    /**
     * 部分好友新建相册
     * @param albumName 相册名
     * @param theme 主题
     * @param theme 权限
     * @param request
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/createAlbumTwo")
    @ResponseBody
    public int createAlbumTwo(@Param("albumName") String albumName,@Param("theme") String theme,
                           @Param("jurisdiction") String  jurisdiction,@RequestParam(value = "checkID[]")  Integer[]  friendId,
                              @Param("album_name") String album_name, HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        int userId=user.getId();
        String sta="";
        String jsd1="公开";
        String jsd2="私有";
        if (jurisdiction.equals(jsd1)){
            sta="0";
        }else if (jurisdiction.equals(jsd2)){
            sta="1";
        }
        Album album=new Album();
        album.setAlbumName(albumName);
        album.setUserId(userId);
        album.setStatus(sta);
        album.setAlbumType(theme);
        List albumlist=albumService.selectAlbumByName(userId,albumName);
        //大于0表示相册名已存在，不可使用，返回0
        if (albumlist.size()>0){
            return 0;
        }else{
            //否则表示相册名可用，创建相册，返回1
            int result= albumService.createAlbum(album);
            if(result==1){
                List<Integer>  list= Arrays.asList(friendId);
                int albumId=0;
                List<Album> albumTwo=albumService.selectAlbumByName(user.getId(),albumName);
                for(Album s:albumTwo){
                    albumId=s.getId();

                }
                albumService.setPerssonalPromission(user.getId(),albumId,list,0);
            }
            return 1;
        }

    }


    /**
     * 删除相册，采用逻辑删除方式，置于回收站
     * @param albumName
     * @param request
     * @return
     */
    @RequestMapping("/deleteAlbum")
    @ResponseBody
    public int deleteAlbum(@Param("albumName") String albumName, HttpServletRequest request){
        String status1="0";
        String status2="1";
        String status3="20";
        String status4="21";
        String status=null;
        User user= (User) request.getSession().getAttribute("user");
        int userId=user.getId();
        List albumlist =albumService.selectAlbumByName(userId,albumName);
        Album album= (Album) albumlist.get(0);
        int albumId=album.getId();
        /**
         * 删除整个相册时，先获取相册原来status
         * 若原status为0，则将新status置为20
         * 若原status为1，则将新status置为21
         * 其中20,21均代表回收站，方便还原相册时将相册状态重置
         */
        String albumStatus=album.getStatus();
        System.out.println("原来的albumStatus:"+albumStatus);
        if (albumStatus.equals(status1)){
            List<Image> list=imageService.getImage("0",userId,albumId);
            List<RecycleBin> recycleBinList=new ArrayList<>();
            //！=0表示该相册有照片，先把照片置于回收站，再把相册置于回收站
            if(list.size()!=0){
                for (int i=0;i<list.size();i++){
                    int imageId=list.get(i).getId();
                    RecycleBin recycleBin=new RecycleBin();
                    recycleBin.setAlbumId(albumId);
                    recycleBin.setImageId(imageId);
                    recycleBin.setUserId(userId);
                    recycleBinList.add(recycleBin);
                }
                recycleBinService.insertRecycleBin(recycleBinList);
                imageService.deleteImageByAlbumId(albumId);
                albumService.deleteAlbum(albumId,status3);
            }
            //否则，该相册为空，只修改相册状态即可
            else{
                albumService.deleteAlbum(albumId,status3);

            }
        return 1;
        } if (albumStatus.equals(status2)) {
            List<Image> list = imageService.getImage("0", userId, albumId);
            List<RecycleBin> recycleBinList = new ArrayList<>();
            //！=0表示该相册有照片，先把照片置于回收站，再把相册置于回收站
            if (list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    int imageId = list.get(i).getId();
                    RecycleBin recycleBin = new RecycleBin();
                    recycleBin.setAlbumId(albumId);
                    recycleBin.setImageId(imageId);
                    recycleBin.setUserId(userId);
                    recycleBinList.add(recycleBin);
                }
                recycleBinService.insertRecycleBin(recycleBinList);
                imageService.deleteImageByAlbumId(albumId);
                albumService.deleteAlbum(albumId, status4);
            }
            //否则，该相册为空，只修改相册状态即可
            else {
                albumService.deleteAlbum(albumId, status4);

            }
        }
        return 1;
    }

    /**
     * 修改相册
     * @param albumName 相册名
     * @param theme 主题
     * @param theme 权限
     */
    @RequestMapping("/updateAlbum")
    @ResponseBody
    public int updateAlbum(@Param("albumId") Integer albumId,@Param("albumName") String albumName,
                           @Param("theme") String theme,@Param("jurisdiction") String  jurisdiction,HttpServletRequest request){
        //User user= (User) request.getSession().getAttribute("user");
        //int userId=user.getId();
        //List albumlist =albumService.selectAlbumByName(userId,albumName);
        //Album album= (Album) albumlist.get(0);
        //int albumId=album.getId();
        Album album=albumService.selectAlbumById(albumId);
        //String staus=album.getStatus();
        if (jurisdiction.equals("3")){
            albumService.updateAlbum(albumId,albumName,"0",theme);
            return 1;
        }else {
            albumService.updateAlbum(albumId,albumName,jurisdiction,theme);
            userPromissionService.deletePromission(albumId);
            return 1;
        }

    }

    /**
     * 相册排序（按修改时间）
     * @return
     */
    @RequestMapping("/sortByTime")
    @ResponseBody
    public  Map<String,Object>   sortByTime( HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        List albumlist =albumService.getAlbumByTime(user.getId());
        Map<String,Object> map=new HashMap<>();
        int albumId=0;
        List list=new ArrayList();
        List coverList=new ArrayList();
        for(int i = 0; i < albumlist.size() ; i++) {
            Album album= (Album) albumlist.get(i);
            albumId=album.getId();
            //用户某个相册下照片数量
            int imageNum=imageService.imageNum(user.getId(),albumId);
            //获取每个相册下最近一张照片作为相册封面展示图
            Image coverImage=imageService.getFirstOne(user.getId(),albumId);
            //若该相册内没有照片，则使用系统默认相册封面图
            if (coverImage==null){
                coverImage=new Image();
                coverImage.setUrl("/upload/Album-cover3.jpg");
            }
            coverList.add(coverImage);
            list.add(imageNum);
        }
        map.put("album",albumlist);
        map.put("coverList",coverList);
        map.put("imageNum",list);
        return  map;

    }
    /**
     * 相册排序（按相册名首字母A-Z）
     * @return
     */
    @RequestMapping("/sortByName")
    @ResponseBody
    public  Map<String,Object>   sortByName( HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        List albumlist =albumService.getAlbumByName(user.getId());
        Map<String,Object> map=new HashMap<>();
        int albumId=0;
        List list=new ArrayList();
        List coverList=new ArrayList();
        for(int i = 0; i < albumlist.size() ; i++) {
            Album album= (Album) albumlist.get(i);
            albumId=album.getId();
            //用户某个相册里照片数量
            int imageNum=imageService.imageNum(user.getId(),albumId);
            //获取每个相册下最近一张照片作为相册封面展示图
            Image coverImage=imageService.getFirstOne(user.getId(),albumId);
            //若该相册内没有照片，则使用系统默认相册封面图
            if (coverImage==null){
                coverImage=new Image();
                coverImage.setUrl("/upload/Album-cover3.jpg");
            }
            coverList.add(coverImage);
            list.add(imageNum);
        }
        map.put("album",albumlist);
        map.put("coverList",coverList);
        map.put("imageNum",list);
        return  map;

    }
    /**
     * 相册排序（按主题名首字母A-Z）
     * @return
     */
    @RequestMapping("/sortByTheme")
    @ResponseBody
    public  Map<String,Object>   sortByTheme( HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        List albumlist =albumService.getAlbumByTheme(user.getId());
        Map<String,Object> map=new HashMap<>();
        int albumId=0;
        List list=new ArrayList();
        List coverList=new ArrayList();
        for(int i = 0; i < albumlist.size() ; i++) {
            Album album= (Album) albumlist.get(i);
            albumId=album.getId();
            //用户某个相册下照片数量
            int imageNum=imageService.imageNum(user.getId(),albumId);
            //获取每个相册下最近一张照片作为相册封面展示图
            Image coverImage=imageService.getFirstOne(user.getId(),albumId);
            //若该相册内没有照片，则使用系统默认相册封面图
            if (coverImage==null){
                coverImage=new Image();
                coverImage.setUrl("/upload/Album-cover3.jpg");
            }
            coverList.add(coverImage);
            list.add(imageNum);
        }
        map.put("album",albumlist);
        map.put("coverList",coverList);
        map.put("imageNum",list);
        return  map;

    }
    /**
     * 相册部分好友可见权限控制
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/someFriendCanSee")
    @ResponseBody
    public boolean  someFriendCanSee(@RequestParam(value = "checkID[]")  Integer[]  friendId,@Param("album_name") String album_name,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
        User user= (User) request.getSession().getAttribute("user");
        List<Integer>  list= Arrays.asList(friendId);
        int albumId=0;
        List<Album> album=albumService.selectAlbumByName(user.getId(),album_name);
        for(Album s:album){
            albumId=s.getId();
        }
        albumService.setPerssonalPromission(user.getId(),albumId,list,0);
        return true;
    }
    @RequestMapping("/selectFriendWhoHavePromission")
    @ResponseBody
    public  Map<String,Object>   selectFriendWhoHavePromission( HttpServletRequest request,@Param("album_name") String album_name){
        User user= (User) request.getSession().getAttribute("user");
        Map<String,Object> map=new HashMap<>();
        List<Album> album=albumService.selectAlbumByName(user.getId(),album_name);
        int albumId=0;
        for(Album s:album){
            albumId=s.getId();
        }
        List<User> users=userService.selectFriendHavePromission(albumId);
        for(User s:users){
            System.out.println(s.getNickName()+s.getUserIcon()+s.getUserName());
        }
        map.put("users",users);
        return  map;

    }


}
