package cn.yznu.pca.controller;

import cn.yznu.pca.model.Album;
import cn.yznu.pca.model.FriendVerification;
import cn.yznu.pca.model.User;
import cn.yznu.pca.service.AlbumService;
import cn.yznu.pca.service.FriendService;
import cn.yznu.pca.service.ImageService;
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
    private FriendService friendService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ImageService imageService;

    /**
     * 进入我的好友页面查询该用户下所有好友方法
     */
    @RequestMapping("/myFriend")
    @ResponseBody
    public ModelAndView myFriend(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        friendService.test();
        List<?> list = friendService.selectFriendGroup(user);
        List<?> list2 = friendService.selectAllMyFriend(user);
        ModelAndView mav = new ModelAndView("myFriend");
        String jsonArray = JSON.toJSONString(list);
        JSONArray friendgroup = JSONArray.parseArray(jsonArray);
        String jsonArray2 = JSON.toJSONString(list2);
        JSONArray allfriend = JSONArray.parseArray(jsonArray2);
        mav.addObject("FriendGroup", list);
        mav.addObject("friendgroup", friendgroup);
        mav.addObject("allfriend", allfriend);
        return mav;
    }

    /**
     * 点击好友分组显示该用户好友分组下的所有朋友
     */
    @RequestMapping("/selectMyFriend")
    @ResponseBody
    public ModelAndView selectMyFriend(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("myFriend");
        User user = (User) request.getSession().getAttribute("user");
        int permissiongroupid=friendService.selectAddFriendGroup(user.getId(),"我的好友");
        List<?> list = friendService.selectFriendGroup(user);
        List<?> list2 = friendService.selectMyFriend(user,permissiongroupid);
        String jsonArray = JSON.toJSONString(list);
        JSONArray friendgroup = JSONArray.parseArray(jsonArray);
        String jsonArray2 = JSON.toJSONString(list2);
        JSONArray allfriend = JSONArray.parseArray(jsonArray2);
        mav.addObject("allfriend", allfriend);
        mav.addObject("friendgroup", friendgroup);
        return mav;
    }

    /**
     * 点击显示该用户家人分组下的所有朋友
     */
    @RequestMapping("/selectMyFamily")
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
        mav.addObject("allfriend", allfriend);
        mav.addObject("friendgroup", friendgroup);
        return mav;
    }

    /**
     * 点击显示该用户同事分组下的所有朋友
     */
    @RequestMapping("/selectMyColleague")
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
        mav.addObject("allfriend", allfriend);
        mav.addObject("friendgroup", friendgroup);
        return mav;
    }

    /**
     * 点击显示该用户同学分组下的所有朋友
     */
    @RequestMapping("/selectMyClassmate")
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
        mav.addObject("allfriend", allfriend);
        mav.addObject("friendgroup", friendgroup);
        return mav;
    }

    /**
     * 点击显示该用户陌生人分组下的所有朋友
     */
    @RequestMapping("/selectMyStranger")
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
        mav.addObject("allfriend", allfriend);
        mav.addObject("friendgroup", friendgroup);
        return mav;
    }

    /**
     * 添加好友，并添加好友验证
     */
    @RequestMapping(method = RequestMethod.POST, value = "/addFriend")
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
                    System.out.println("请求验证消息已发送！！！！！");
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
    @RequestMapping(method = RequestMethod.POST, value = "/passFriendVerification")
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
    @RequestMapping(method = RequestMethod.POST, value = "/selectAllFriendVerification")
    @ResponseBody
    public ModelAndView  passFriendVerification(HttpServletRequest request,
                                               HttpServletResponse response) {
        ModelAndView mav=new  ModelAndView("myFriend");
        User user = (User) request.getSession().getAttribute("user");
        List<FriendVerification> friendVerifications=friendService.selectAllFriendVerification(user);
        for (FriendVerification s:friendVerifications){
            System.out.println(s.getFriend().getId()+"查询到的该用户下所有验证消息为"+s.getUser().getNickName()
            +"请求加你为好友"+"验证消息为"+s.getNote());
        }
        JSONObject jo = new JSONObject();
        String jsonArray = JSON.toJSONString(friendVerifications);
        JSONArray friendgroup = JSONArray.parseArray(jsonArray);


        JSONArray jsonArray2 = JSONArray.parseArray(JSON.toJSONString(friendVerifications));
        String str =jsonArray2.toJSONString();
        System.out.println("str的数据格式为"+str);
        System.out.println("jsonArray2的数据格式为"+jsonArray2);
        System.out.println("friendgroup的数据格式为"+friendgroup);
        System.out.println("jsonArray的数据格式为"+jsonArray);
        mav.addObject("friendgroup",friendgroup);
        mav.addObject("str",str);
        return mav;
    }


    /**
     * 创建好友分组
     */
    @RequestMapping(method = RequestMethod.POST, value = "/createFriendGroup")
    @ResponseBody
    public boolean createFriendGroup(@Param("groupName") String groupName,
                                               HttpServletRequest request,
                                               HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        boolean date2=friendService.checkFriendsGroup(user,groupName);
        if(date2){
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
    @RequestMapping(method = RequestMethod.POST, value = "/searchFriends")
    @ResponseBody
    public Map<String,?> searchFriends(@Param("friendName") String friendName,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<User> users=friendService.searchFriends(friendName);
//        String jsonArray = JSON.toJSONString(users);
//        JSONArray users2 = JSONArray.parseArray(jsonArray);
        Map<String, List<?>> maps=new HashMap<>();
        maps.put("users",users);
        return maps;
    }


    /**
     * 删除好友分组
     */
    @RequestMapping(method = RequestMethod.POST, value = "/deleteFriendsGroup")
    @ResponseBody
    public boolean deleteFriendsGroup(@Param("groupName") String groupName,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        int i=friendService.selectAddFriendGroup(user.getId(),groupName);
        int a=friendService.selectAddFriendGroup(user.getId(),"我的好友");
        friendService.deleteFriendsGroup(a,i);
     return true;
    }

    /**
     * 点击好友头像进入好友空间
     */
    @RequestMapping(method = RequestMethod.POST, value = "/inFriendSpace/{friend_id}")
    @ResponseBody
    public Map<String,Object>  inFriendSpace(@PathVariable int friend_id,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println("66666666"+friend_id);
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
        map.put("album",albumlist);
        map.put("imageNum",list);
        return  map;
    }


}
