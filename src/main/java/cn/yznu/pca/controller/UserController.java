package cn.yznu.pca.controller;

import cn.yznu.pca.model.Image;
import cn.yznu.pca.model.User;
import cn.yznu.pca.service.AlbumService;
import cn.yznu.pca.service.ImageService;
import cn.yznu.pca.service.UserService;
import cn.yznu.pca.utils.FormatUtil;
import cn.yznu.pca.utils.MD5Util;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;


/**
 * @author yangbaiwan
 * @date 2018-09-28
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired

    private AlbumService albumService;

    @Autowired

    private ImageService imageService;

    //@RequestMapping("/index")
    //public  String index(){
    //    return "index";
    //}

    @RequestMapping("/register")
    public  String register(){
        return "register";
    }


    @RequestMapping("/login")
    public  String login(){
        return "login";
    }

    @RequestMapping("/personalData")
    public  String personalData(HttpServletRequest request, ModelAndView mav){
        User user= (User) request.getSession().getAttribute("user");
        int id=user.getId();
        int albumNum=albumService.getAlbumNum(id);
        int imageNum=imageService.getAllImageNum(id);
        request.getSession().setAttribute("albumNum",albumNum);
        request.getSession().setAttribute("imageNum",imageNum);
        return "personalData";
    }
    @RequestMapping("/myAlbum")
    public  String myAlbum(){
        return "myAlbum";
    }

    @RequestMapping("/myFriend")
    public  String myFriend(){
        return "myFriend";
    }

    @RequestMapping("/recycleBin")
    public  String recycleBin(){
        return "recycleBin";
    }

    @ResponseBody
    @RequestMapping("/isExist")
    public String  isExist(String username) {
        int flag = userService.isExistUserName(username);
        //用户名未被使用
        if(flag==0) {
            return "success";
        }else{
            //用户名已被使用
            return "error";
        }
    }
    @ResponseBody
    @RequestMapping("/doRegister")
    public  String register(@Param("username") String username, @Param("password") String password){
        User user=new User();
        user.setUserName(username);
        //对密码进行MD5加密
        user.setUserPassword(MD5Util.md5Jdk(password));
        System.out.println(MD5Util.md5Jdk(password));
        userService.register(user);
        return "success";
    }
    @ResponseBody
    @RequestMapping("/checkLogin")
    public String  checkLogin(@Param("username") String username, @Param("password") String password,HttpServletRequest request){
        request.getSession().setAttribute("username",username);
        request.getSession().setAttribute("password",password);
        //对密码进行MD5加密
        String md5pwd=MD5Util.md5Jdk(password);
        //检查用户名和密码是否正确
        User user=userService.checkLogin(username,md5pwd);
        request.getSession().setAttribute("user",user);
        if (user==null){
            //用户名或密码错误,返回到页面
            return "error";
        }else {
            //用户名或密码正确,返回页面
            return  "success";
        }
    }
    @RequestMapping("/changeIcon")
    public String changeIcon(HttpServletRequest request ,Image image,User user, @RequestParam(value="file")MultipartFile pictureFile) throws Exception{
        //设置本地保存路径
        String localPath="F:\\demos\\upload\\";
        //使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        //获取照片大小,以B/KB/MB为单位保存
        String fileSize =FormatUtil.format(pictureFile.getSize()) ;
        //获取文件的扩展名
        String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
        //设置图片上传的虚拟路径
        String url = "/upload/";
        //以绝对路径保存重名命后的图片
        pictureFile.transferTo(new File(localPath+"/"+name + "." + ext));
        //保存图片信息到数据库
        image.setImageName(name);
        image.setUrl(url+name+"." + ext);
        image.setImageSize(fileSize);
        imageService.upload(image);
        return "personalData";
    }
    @ResponseBody
    @RequestMapping("/changePassword")
    public String changePassword(@Param("oldPassword")String oldPassword,
                                 @Param("newPasssword1")String newPassword1,HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        String password=user.getUserPassword();
        //将用户输入的密码进行MD5转码后比较
        String oldp=MD5Util.md5Jdk(oldPassword);
        if (password.equals(oldp)){
            userService.changePassword(user.getId(),MD5Util.md5Jdk(newPassword1));
            return "success";
        }else {
            return "fail";
        }
    }
    @ResponseBody
    @RequestMapping("/modifyingData")
    public String ModifyingData(@Param("nickName") String nickName, @Param("synopsis") String synopsis,HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        boolean f=userService.modifyingData(user.getId(),nickName,synopsis);
        if (true){
            return "success";
        }else {
            return "fail";
        }

    }

}
