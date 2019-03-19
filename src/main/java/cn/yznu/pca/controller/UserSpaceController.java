package cn.yznu.pca.controller;

import cn.yznu.pca.model.User;
import cn.yznu.pca.model.UserSpace;
import cn.yznu.pca.service.UserSpaceService;
import cn.yznu.pca.utils.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
    @ResponseBody
    public Map getSpace(HttpServletRequest request){
        Map map=new HashMap();
        User user= (User) request.getSession().getAttribute("user");
        int id=user.getId();
        UserSpace userSpace=userSpaceService.getSpace(id);
        String allSpace= FormatUtil.toRise(userSpace.getAllSpace());
        String usedSpace=FormatUtil.toRise(userSpace.getUsedSpace());
        String availableSpace=FormatUtil.toRise(userSpace.getAvailableSpace());
        String usedSpace2=userSpace.getUsedSpace();
        String allSpace2=userSpace.getAllSpace();
        String percent= FormatUtil.toPercent(usedSpace2,allSpace2);
        map.put("allSpace",allSpace);
        map.put("usedSpace",usedSpace);
        map.put("availableSpace",availableSpace);
        map.put("percent",percent);
        return map;
    }
}
