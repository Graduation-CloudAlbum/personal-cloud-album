package cn.yznu.pca.controller;

import cn.yznu.pca.model.PermissionGroup;
import cn.yznu.pca.model.User;
import cn.yznu.pca.model.UserRelation;
import cn.yznu.pca.service.FriendService;
import cn.yznu.pca.service.UserService;
import cn.yznu.pca.utils.ResponseUtil;
import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public  ModelAndView myFriend(HttpServletRequest request,HttpServletResponse response){
        User user= (User) request.getSession().getAttribute("user");
        List<?> list=friendService.selectFriendGroup(user);
        ModelAndView mav=new ModelAndView("myFriend");
        JSONObject jo = new JSONObject();
        String jsonArray = JSON.toJSONString(list);
        JSONArray friendgroup = JSONArray.parseArray(jsonArray);
//        response转发Jason数据方法
//        try {
//            ResponseUtil.write(response, jo);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("66666666666666666666666666");
//        }
        mav.addObject("FriendGroup",list);
        mav.addObject("friendgroup",friendgroup);
        return mav;
    }

    /**
     * 点击好友分组显示该用户好友分组下的所有朋友
     */
    @RequestMapping("/selectMyFriend")
    @ResponseBody
    public  ModelAndView selectMyFriend(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav= new ModelAndView("myFriend");
        User user= (User) request.getSession().getAttribute("user");
        List<UserRelation> list=friendService.selectMyFriend(user);
        for(UserRelation attribute : list){
            System.out.println("该用户的好友有"+attribute.getUserIdTwo());
        }
        return mav;
    }

    /**
     * 点击显示该用户家人分组下的所有朋友
     */
    @RequestMapping("/selectMyFamily")
    @ResponseBody
    public  ModelAndView selectMyFamily(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav= new ModelAndView("myFriend");
        User user= (User) request.getSession().getAttribute("user");
        List<?> list=friendService.selectMyFamily(user);
        return mav;
    }

    /**
     * 点击显示该用户同事分组下的所有朋友
     */
    @RequestMapping("/selectMyColleague")
    @ResponseBody
    public  ModelAndView selectMyColleague(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav= new ModelAndView("myFriend");
        User user= (User) request.getSession().getAttribute("user");
        List<?> list=friendService.selectMyColleague(user);
        return mav;
    }

    /**
     * 点击显示该用户同学分组下的所有朋友
     */
    @RequestMapping("/selectMyClassmate")
    @ResponseBody
    public  ModelAndView selectMyClassmate(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav= new ModelAndView("myFriend");
        User user= (User) request.getSession().getAttribute("user");
        List<?> list=friendService.selectMyClassmate(user);
        return mav;
    }

    /**
     * 点击显示该用户陌生人分组下的所有朋友
     */
    @RequestMapping("/selectMyStranger")
    @ResponseBody
    public  ModelAndView selectMyStranger(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav= new ModelAndView("myFriend");
        User user= (User) request.getSession().getAttribute("user");
        List<?> list=friendService.selectMyStranger(user);
        return mav;
    }
}
