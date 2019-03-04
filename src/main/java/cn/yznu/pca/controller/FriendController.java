package cn.yznu.pca.controller;

import cn.yznu.pca.model.FriendVerification;
import cn.yznu.pca.model.User;
import cn.yznu.pca.service.FriendService;
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
    @RequestMapping(method = RequestMethod.POST, value = "/addFriend/{username}")
    @ResponseBody
    public ModelAndView addFriend(@Param("note") String note,
                                  @Param("permisssion_type") String permisssion_type,
                                  @PathVariable String username,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("myFriend");
        try {
            String username2 = new String(username.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println("用户名为" + username2);
            System.out.println("好友请求信息为" + note);
            List<User> list = friendService.selectFriendByUsername(username2);
            User user2=new User();
            User user = (User) request.getSession().getAttribute("user");
            for (User attribute : list) {
                if (friendService.selectExistFriend(user.getId(), attribute.getId()).size() > 0) {
                    System.out.println("你们已经是好友状态！！！！！");
                } else {
                    //添加好友
                    user2.setId(attribute.getId());
                    friendService.addFriend(user, attribute.getId(),
                            friendService.selectAddFriendGroup(user.getId(), permisssion_type),
                            friendService.selectAddFriendGroup(attribute.getId(), "5"));
                    //添加好友验证消息
                    friendService.addFriendVerification(note, user, user2);
                    System.out.println("请求验证消息已发送！！！！！");
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return mav;
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
}
