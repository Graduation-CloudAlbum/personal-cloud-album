package cn.yznu.pca.controller;

import cn.yznu.pca.model.User;
import cn.yznu.pca.model.UserSpace;
import cn.yznu.pca.service.UserSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yangbaiwan
 * @date 2019-03-15
 */
@Controller
@RequestMapping("sapce")
public class UserSpaceController {

    @Autowired
    private UserSpaceService userSpaceService;

    @RequestMapping("getSpace")
    public ModelAndView getSpace(HttpServletRequest request){
        ModelAndView mav=new ModelAndView("myAlbum");
        User user= (User) request.getSession().getAttribute("user");
        int id=user.getId();
        UserSpace userSpace=userSpaceService.getSpace(id);
        mav.addObject("userSpace",userSpace);
        return mav;
    }
}
