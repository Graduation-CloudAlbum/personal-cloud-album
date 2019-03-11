package cn.yznu.pca.controller;

import cn.yznu.pca.model.RecycleBin;
import cn.yznu.pca.model.User;
import cn.yznu.pca.service.RecycleBinService;
import cn.yznu.pca.utils.MD5Util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
    public ModelAndView myRecycleBin(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        ModelAndView mav = new ModelAndView("recycleBin");
        List<RecycleBin> recycleBins=recycleBinService.getRecycleBin(user.getId());
        String jsonArray = JSON.toJSONString(recycleBins);
        JSONArray allrecycleBins = JSONArray.parseArray(jsonArray);
        mav.addObject("allrecycleBins", allrecycleBins);
        mav.addObject("recycleBins",recycleBins);
        return mav;
    }


    /**
     * 还原部分相片
     */
    @RequestMapping("/someImageRecovery")
    @ResponseBody
    public boolean someImageRecovery(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam(value="check_val[]") Integer[] check_val) {
        User user = (User) request.getSession().getAttribute("user");

        List list=new ArrayList();
        List list2=new ArrayList();
        for (Integer integer : check_val) {
            list.add(integer.intValue());
            System.out.println("前台送的数据为"+integer.intValue());
        }
        List<RecycleBin> recycleBins=recycleBinService.selectAlbumByList(list);
        for (RecycleBin recycleBin : recycleBins) {
            list2.add(recycleBin.getAlbumId());
            System.out.println("拿到相册id"+recycleBin.getAlbumId());
        }
        boolean recycleBinsResult=recycleBinService.recoverSomeImage(list);
        boolean recycleBinsResult2=recycleBinService.delManyRecycleBin(list);
        boolean recycleBinsResult3=recycleBinService.updateAlbumByList(list2);
        if(recycleBinsResult&&recycleBinsResult2&&recycleBinsResult3){
            return true;
        }
       else{
            return false;
        }
    }

    /**
     * 删除部分回收站相片
     */
    @RequestMapping("/deleteSomeRecycleBin/{deleteRecycleInput2}")
    @ResponseBody
    public boolean deleteSomeRecycleBin(HttpServletRequest request,
                                        @PathVariable String deleteRecycleInput2, HttpServletResponse response,
                                        @RequestParam(value="check_val[]") Integer[] check_val) {
        User user = (User) request.getSession().getAttribute("user");
        List list=new ArrayList();
        System.out.println("第一个："+MD5Util.md5Jdk(deleteRecycleInput2));
        System.out.println("第二个："+user.getUserPassword());

        for (Integer integer : check_val) {
            list.add(integer.intValue());
        }
        if(user.getUserPassword().equals(MD5Util.md5Jdk(deleteRecycleInput2))){
            boolean recycleBinsResult2=recycleBinService.delManyRecycleBin(list);
            if(recycleBinsResult2){
                recycleBinService.deleteImageByList(list);
                return true;
            }
            else{
                return false;
            }
        }else {
            return false;
        }

    }

    /**
     * 清空回收站
     */
    @RequestMapping("/deleteAllRecycleBin/{deleteRecycleInput}")
    @ResponseBody
    public boolean deleteAllRecycleBin(HttpServletRequest request,
                                       @PathVariable String deleteRecycleInput,
                                       HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<RecycleBin> recycleBins=recycleBinService.getRecycleBin(user.getId());
        List list=new ArrayList();
        for(RecycleBin recycleBin:recycleBins){
            list.add(recycleBin.getImageId());
        }
        if(user.getUserPassword().equals(MD5Util.md5Jdk(deleteRecycleInput))){
            boolean recycleBinsResult =recycleBinService.deleteAllRecycleBin(user.getId());
            if(recycleBinsResult){
                recycleBinService.deleteImageByList(list);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }


    /**
     * 清空回收站
     */
    @RequestMapping("/recoverAllRecycleBin")
    @ResponseBody
    public boolean recoverAllRecycleBin(HttpServletRequest request,
                                       HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<RecycleBin> recycleBins=recycleBinService.getRecycleBin(user.getId());
        List list=new ArrayList();
        List list2=new ArrayList();
        for(RecycleBin recycleBin:recycleBins){
            list.add(recycleBin.getImageId());
        }
        List<RecycleBin> recycleBins2=recycleBinService.selectAlbumByList(list);
        for (RecycleBin recycleBin : recycleBins2) {
            list2.add(recycleBin.getAlbumId());
        }
        boolean recycleBinsResult =recycleBinService.recoverAllRecycleBin(list);
        if(recycleBinsResult){
            boolean recycleBinsResult2=recycleBinService.deleteAllRecycleBin(user.getId());
            if(recycleBinsResult2){
                return true;
            }else{
                System.out.println("66666");
                return false;
            }
        }else{
            System.out.println("111111111");
                return false;
        }
    }
}
