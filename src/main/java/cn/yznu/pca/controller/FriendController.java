package cn.yznu.pca.controller;

import cn.yznu.pca.model.Album;
import cn.yznu.pca.model.FriendVerification;
import cn.yznu.pca.model.Image;
import cn.yznu.pca.model.User;
import cn.yznu.pca.service.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiangchuan
 * @date 2019-1-21
 */


@Controller
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionGroupService permissionGroupService;

    @Autowired
    private FriendService friendService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ImageService imageService;

    /**
     * 进入我的好友页面查询该用户下所有好友方法
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/myFriend")
    @ResponseBody
    public ModelAndView myFriend(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        //查询好友分组
        List<?> list = friendService.selectFriendGroup(user);
        //查询所有好友
        List<?> list2 = friendService.selectAllMyFriend(user);
        ModelAndView mav = new ModelAndView("myFriend");
        //将好友分组变为json格式
        String jsonArray = JSON.toJSONString(list);
        JSONArray friendgroup = JSONArray.parseArray(jsonArray);
        //将好友列表变为json格式
        String jsonArray2 = JSON.toJSONString(list2);
        JSONArray allfriend = JSONArray.parseArray(jsonArray2);
        //将新的好友数存入
        int newFriendNumber=friendService.searchNewFriend(user.getId());
        request.setAttribute("newFriendNumber", newFriendNumber);
        //将json存入mav
        mav.addObject("FriendGroup", list);
        mav.addObject("friendgroup", friendgroup);
        mav.addObject("allfriend", allfriend);
        return mav;
    }

    /**
     * 点击好友分组显示该用户好友分组下的所有朋友
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/selectMyFriend")
    @ResponseBody
    public ModelAndView selectMyFriend(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("myFriend");
        User user = (User) request.getSession().getAttribute("user");
        //获取该用户对应的我的好友id
        int permissiongroupid=friendService.selectAddFriendGroup(user.getId(),"我的好友");
        //将好友分组存入list
        List<?> list = friendService.selectFriendGroup(user);
        //查询该分组下我的所有好友
        List<?> list2 = friendService.selectMyFriend(user,permissiongroupid);
        String jsonArray = JSON.toJSONString(list);
        JSONArray friendgroup = JSONArray.parseArray(jsonArray);
        String jsonArray2 = JSON.toJSONString(list2);
        JSONArray allfriend = JSONArray.parseArray(jsonArray2);
        int newFriendNumber=friendService.searchNewFriend(user.getId());
        request.setAttribute("newFriendNumber", newFriendNumber);
        mav.addObject("allfriend", allfriend);
        mav.addObject("friendgroup", friendgroup);
        return mav;
    }

    /**
     * 点击显示该用户家人分组下的所有朋友
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/selectMyFamily")
    @ResponseBody
    public ModelAndView selectMyFamily(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("myFriend");
        User user = (User) request.getSession().getAttribute("user");
        int permissiongroupid=friendService.selectAddFriendGroup(user.getId(),"我的家人");
        List<?> list = friendService.selectFriendGroup(user);
        List<?> list2 = friendService.selectMyFriend(user,permissiongroupid);
        String jsonArray = JSON.toJSONString(list);
        JSONArray friendgroup = JSONArray.parseArray(jsonArray);
        String jsonArray2 = JSON.toJSONString(list2);
        JSONArray allfriend = JSONArray.parseArray(jsonArray2);
        int newFriendNumber=friendService.searchNewFriend(user.getId());
        request.setAttribute("newFriendNumber", newFriendNumber);
        mav.addObject("allfriend", allfriend);
        mav.addObject("friendgroup", friendgroup);
        return mav;
    }

    /**
     * 点击显示该用户同事分组下的所有朋友
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/selectMyColleague")
    @ResponseBody
    public ModelAndView selectMyColleague(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("myFriend");
        User user = (User) request.getSession().getAttribute("user");
        int permissiongroupid=friendService.selectAddFriendGroup(user.getId(),"我的同事");
        List<?> list = friendService.selectFriendGroup(user);
        List<?> list2 = friendService.selectMyFriend(user,permissiongroupid);
        String jsonArray = JSON.toJSONString(list);
        JSONArray friendgroup = JSONArray.parseArray(jsonArray);
        String jsonArray2 = JSON.toJSONString(list2);
        JSONArray allfriend = JSONArray.parseArray(jsonArray2);
        int newFriendNumber=friendService.searchNewFriend(user.getId());
        request.setAttribute("newFriendNumber", newFriendNumber);
        mav.addObject("allfriend", allfriend);
        mav.addObject("friendgroup", friendgroup);
        return mav;
    }

    /**
     * 点击显示该用户同学分组下的所有朋友
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/selectMyClassmate")
    @ResponseBody
    public ModelAndView selectMyClassmate(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("myFriend");
        User user = (User) request.getSession().getAttribute("user");
        int permissiongroupid=friendService.selectAddFriendGroup(user.getId(),"我的同学");
        List<?> list = friendService.selectFriendGroup(user);
        List<?> list2 = friendService.selectMyFriend(user,permissiongroupid);
        String jsonArray = JSON.toJSONString(list);
        JSONArray friendgroup = JSONArray.parseArray(jsonArray);
        String jsonArray2 = JSON.toJSONString(list2);
        JSONArray allfriend = JSONArray.parseArray(jsonArray2);
        int newFriendNumber=friendService.searchNewFriend(user.getId());
        request.setAttribute("newFriendNumber", newFriendNumber);
        mav.addObject("allfriend", allfriend);
        mav.addObject("friendgroup", friendgroup);
        return mav;
    }

    /**
     * 点击显示该用户陌生人分组下的所有朋友
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/selectMyStranger")
    @ResponseBody
    public ModelAndView selectMyStranger(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("myFriend");
        User user = (User) request.getSession().getAttribute("user");
        int permissiongroupid=friendService.selectAddFriendGroup(user.getId(),"陌生人");
        List<?> list = friendService.selectFriendGroup(user);
        List<?> list2 = friendService.selectMyFriend(user,permissiongroupid);
        String jsonArray = JSON.toJSONString(list);
        JSONArray friendgroup = JSONArray.parseArray(jsonArray);
        String jsonArray2 = JSON.toJSONString(list2);
        JSONArray allfriend = JSONArray.parseArray(jsonArray2);
        int newFriendNumber=friendService.searchNewFriend(user.getId());
        request.setAttribute("newFriendNumber", newFriendNumber);
        mav.addObject("allfriend", allfriend);
        mav.addObject("friendgroup", friendgroup);
        return mav;
    }

    /**
     * 添加好友，并添加好友验证
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/addFriend")
    @ResponseBody
    public boolean addFriend(@Param("Validationmessage") String Validationmessage,
                                  @Param("userName") String userName,
                                  @Param("groupName") String groupName,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
            List<User> list = friendService.selectFriendByUsername(userName);
            User user2=new User();
            int a=0;
            User user = (User) request.getSession().getAttribute("user");
            for (User attribute : list) {
                if (friendService.selectExistFriend(user.getId(), attribute.getId()).size() > 0) {
                    a=friendService.selectExistFriend(user.getId(), attribute.getId()).size();

                } else {
                    a=0;
                    //添加好友
                    user2.setId(attribute.getId());
                    friendService.addFriend(user, attribute.getId(),
                            friendService.selectAddFriendGroup(user.getId(), groupName),
                            friendService.selectAddFriendGroup(attribute.getId(), "陌生人"));
                    //添加好友验证消息
                    friendService.addFriendVerification(Validationmessage, user, user2);
                }
            }
            if(a==0){
                return true;
            }
            else {
                return false;
            }
    }


    /**
     * 通过好友验证
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/passFriendVerification")
    @ResponseBody
    public ModelAndView passFriendVerification(@Param("friendVerificationId") int friendVerificationId,
                                               HttpServletRequest request,
                                               HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("myFriend");
        friendService.passFriendVerification(friendVerificationId);
        return mav;
    }


    /**
     * 查询该用户下所有朋友验证消息
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/selectAllFriendVerification")
    @ResponseBody
    public Map<String,Object>  passFriendVerification(HttpServletRequest request,
                                               HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        //查询已收到的所有好友验证消息
        List<FriendVerification> friendVerifications=friendService.selectAllFriendVerification(user);
        Map<String,Object> map=new HashMap<>();
        //查询已发送的所有好友验证消息
        List<FriendVerification> friendVerificationsTwo=friendService.selectAllSandFriendVerification(user);
        map.put("friendVerifications",friendVerifications);
        map.put("friendVerificationsTwo",friendVerificationsTwo);
        return map;
    }


    /**
     * 创建好友分组
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/createFriendGroup")
    @ResponseBody
    public boolean createFriendGroup(@Param("groupName") String groupName,
                                               HttpServletRequest request,
                                               HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        //查询分组信息
        boolean data2=friendService.checkFriendsGroup(user,groupName);
        //判断是否已有分组
        if(data2){
            friendService.createFriendsGroup(user,groupName);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 搜索好友
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/searchFriends")
    @ResponseBody
    public Map<String,?> searchFriends(@Param("friendName") String friendName,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
        List<User> users=friendService.searchFriends(friendName);
        Map<String, List<?>> maps=new HashMap<>();
        maps.put("users",users);
        return maps;
    }


    /**
     * 删除好友分组
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/deleteFriendsGroup")
    @ResponseBody
    public boolean deleteFriendsGroup(@Param("groupName") String groupName,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        //删除分组时将该分组下好友全部转移至默认好友分组
        int i=friendService.selectAddFriendGroup(user.getId(),groupName);
        int a=friendService.selectAddFriendGroup(user.getId(),"我的好友");
        friendService.deleteFriendsGroup(a,i);
     return true;
    }

    /**
     * 点击好友头像进入好友空间
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/inFriendSpace")
    @ResponseBody
    public Map<String,Object>  inFriendSpace(HttpServletRequest request,
                                      HttpServletResponse response) {
        int friend_id2= (int) request.getSession().getAttribute("friend_id");
        //获取盆友的所有相册
        List albumlist =albumService.getAlbum(friend_id2);
        Map<String,Object> map=new HashMap<>();
        int albumId=0;
        List list=new ArrayList();
        List coverList=new ArrayList();
        for(int i = 0; i < albumlist.size() ; i++) {
            Album album= (Album) albumlist.get(i);
            albumId=album.getId();
            //用户某个相册下照片数量
            int imageNum=imageService.imageNum(friend_id2,albumId);
            //获取每个相册下最近一张照片作为相册封面展示图
            Image coverImage=imageService.getFirstOne(friend_id2,albumId);
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




    /**
     * 点击好友头像进入好友空间存session
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/inFriendSpace2/{friend_id}")
    @ResponseBody
    public ModelAndView  inFriendSpace2(@PathVariable int friend_id,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
        ModelAndView mav=new  ModelAndView("friendAlbum");
        //获取该朋友的信息
        User user1 = userService.getFriendInformation(friend_id);
        //将朋友信息存入session
        request.getSession().setAttribute("user1",user1);
        //查询相册数量
        int friend_albumNum=albumService.getAlbumNum(friend_id);
        //查询照片数量
        int friend_imageNum2=imageService.getAllImageNum(friend_id);
        //查询好友数量
        List list2 = friendService.selectAllMyFriend(user1);
        int friend_friendNum=list2.size();
        //将对应值存入session
        request.getSession().setAttribute("user1",user1);
        request.getSession().setAttribute("friend_albumNum",friend_albumNum);
        request.getSession().setAttribute("friend_imageNum2",friend_imageNum2);
        request.getSession().setAttribute("friend_friendNum",friend_friendNum);
        User user = (User) request.getSession().getAttribute("user");
        //查询新的好友消息
        int newFriendNumber=friendService.searchNewFriend(user.getId());
        //将数字存入session
        request.setAttribute("newFriendNumber", newFriendNumber);
        //查询我的好友分组
        List<?> list = friendService.selectFriendGroup(user);
        String jsonArray = JSON.toJSONString(list);
        JSONArray friendgroup = JSONArray.parseArray(jsonArray);
        request.getSession().setAttribute("friend_id",friend_id);
        mav.addObject("friend_id",friend_id);
        mav.addObject("friendgroup", friendgroup);
        return  mav;
    }


    /**
     * 判断用户是否有进入好友相册权限
     */
    @RequestMapping(method = RequestMethod.POST, value = "/checkAlbumPower")
    @ResponseBody
    public Map  checkAlbumPower(@Param("albumName") String albumName,HttpServletRequest request,
                                        HttpServletResponse response) {
        int friend_id= (int) request.getSession().getAttribute("friend_id");
        //通过用户id和相册名获取到唯一相册
        List albumlist=albumService.selectAlbumByName(friend_id,albumName);
        Album album = (Album) albumlist.get(0);
        //获取该相册id
        int albumId=album.getId();
        String  satus="0";
        List list=imageService.getImage(satus,friend_id,albumId);
        Map map=new HashMap();
        map.put("imageList",list);
        return map;
    }

    /**
     * 判断用户是否有进入好友相册权限
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/checkFriendPower")
    @ResponseBody
    public boolean  checkFriendPower(@Param("albumName") String albumName,HttpServletRequest request,
                                HttpServletResponse response) {
        int friend_id= (int) request.getSession().getAttribute("friend_id");
        User user= (User) request.getSession().getAttribute("user");
        int userId=user.getId();
        //通过用户id和相册名获取到唯一相册
        List albumlist=albumService.selectAlbumByName(friend_id,albumName);
        //拿到唯一相册实体
        Album album = (Album) albumlist.get(0);
        //获取该相册id
        int albumId=album.getId();
        //相册权限
        boolean power=friendService.checkAlbumPower(albumId);
        //私人权限
        int power_two=friendService.checkFriendPower(friend_id,userId,albumId);
        //判断权限
        if(power==true&&power_two==3){
            return true;
        }else if(power==true&&power_two==0){
            return true;
        }
        else if(power!=true&&power_two==0){
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * 用户拒绝好友验证请求
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/refusedfriendVerifications")
    @ResponseBody
    public boolean  refusedfriendVerifications(@Param("userId") String userId,
                                               @Param("friendVerifications_id") String friendVerifications_id,
                                               @Param("friendId") String friendId,
                                               HttpServletRequest request,
                                               HttpServletResponse response) {
        int user_id=Integer.parseInt(userId);
        int friend_id=Integer.parseInt(friendId);
        int friendVerificationsId=Integer.parseInt(friendVerifications_id);
        boolean a=friendService.refusedfriendVerifications(user_id,friend_id,friendVerificationsId);
        if(a){
            return true;
        }else{
            return false;
        }

    }

    /**
     * 用户拒绝好友验证请求并删除相关数据
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/deleteFriendVerifications")
    @ResponseBody
    public boolean  deleteFriendVerifications(@Param("friendVerifications_id") String friendVerifications_id,
                                               HttpServletRequest request,
                                               HttpServletResponse response) {
        int friendVerificationsId=Integer.parseInt(friendVerifications_id);
        boolean a=friendService.deleteFriendVerifications(friendVerificationsId);
        if(a){
            return true;
        }else{
            return false;
        }

    }
    /**
     * 移动好友去新的分组
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/moveFriends")
    @ResponseBody
    public boolean  moveFriends(@Param("friendsGroupName") String friendsGroupName,
                                              HttpServletRequest request,
                                              HttpServletResponse response) {
        User user=(User)request.getSession().getAttribute("user");
        User user1=(User)request.getSession().getAttribute("user1");
        //查询分组id
        int friendsGroupId=friendService.searchFriendsGroup(user,friendsGroupName);
        //移动好友是否成功
        boolean result=friendService.moveFriendToNewGroup(user,user1,friendsGroupId);
       if(result){
           return true;
       }else {
           return false;
       }
    }

    /**
     * 用户删除好友
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/deleteFriends")
    @ResponseBody
    public ModelAndView  deleteFriends(HttpServletRequest request,
                                HttpServletResponse response) {
        User user=(User)request.getSession().getAttribute("user");
        User user1=(User)request.getSession().getAttribute("user1");
        ModelAndView mav = new ModelAndView("myFriend");
        friendService.deleteFriends(user,user1);
        friendService.deleteFriends(user1,user);
        return mav;
    }

    /**
     * 用户接受好友验证请求
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/acceptFriendsInformation")
    @ResponseBody
    public boolean  acceptFriendsInformation(@Param("acceptGroupName") String acceptGroupName,@Param("friendVerifications_id_Two") int friendVerifications_id_Two,HttpServletRequest request,
                                       HttpServletResponse response) {
        User user=(User)request.getSession().getAttribute("user");
        //拿到分组id
        int group_id=friendService.searchFriendsGroup(user,acceptGroupName);
        if(group_id!=0){
            //拿到好友id
            int friend_id=friendService.seachFriendIdByFriendVerifications(friendVerifications_id_Two);
            //用户接受好友请求
            friendService.acceptfriendVerifications(user.getId(),friend_id,group_id,friendVerifications_id_Two);
            return true;
        }
        else{
            return false;
        }

    }



}
