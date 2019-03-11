package cn.yznu.pca.controller;

import cn.yznu.pca.model.RecycleBin;
import cn.yznu.pca.model.User;
import cn.yznu.pca.service.RecycleBinService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author yangbaiwan
 * @date 2019-03-04
 */
@Controller
@RequestMapping("/recycleBin")
public class RecycleBinController {
    @Autowired
    private RecycleBinService recycleBinService;

    /**
     * 进入回收站页面
     */
    @RequestMapping("/myRecycleBin")
    @ResponseBody
    public ModelAndView myFriend(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        ModelAndView mav = new ModelAndView("recycleBin");
        List<RecycleBin> recycleBins=recycleBinService.getRecycleBin(user.getId());
        String jsonArray = JSON.toJSONString(recycleBins);
        JSONArray allrecycleBins = JSONArray.parseArray(jsonArray);
        System.out.println("jason格式为" +allrecycleBins);
        mav.addObject("allrecycleBins", allrecycleBins);
        mav.addObject("recycleBins",recycleBins);
        return mav;
    }

}
