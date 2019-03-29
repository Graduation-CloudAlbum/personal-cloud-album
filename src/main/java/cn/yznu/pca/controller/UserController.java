package cn.yznu.pca.controller;

import cn.yznu.pca.model.Image;
import cn.yznu.pca.model.PermissionGroup;
import cn.yznu.pca.model.User;
import cn.yznu.pca.model.UserSpace;
import cn.yznu.pca.service.*;
import cn.yznu.pca.utils.FormatUtil;
import cn.yznu.pca.utils.MD5Util;
import cn.yznu.pca.utils.MailUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
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

    @Autowired
    private FriendService friendService;

    @Autowired
    private UserSpaceService userSpaceService;

    @Autowired
    private PermissionGroupService permissionGroupService;


    @RequestMapping("/index")
    public  String index(){
        return "index";
    }
    @RequestMapping("/getpass")
    public  String getpass(){
        return "getpass";
    }

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
        List list = friendService.selectAllMyFriend(user);
        int friendNum=list.size();
        request.getSession().setAttribute("albumNum",albumNum);
        request.getSession().setAttribute("imageNum",imageNum);
        request.getSession().setAttribute("friendNum",friendNum);
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

    //@ResponseBody
    //@RequestMapping("/isExist")
    //public String  isExist(String username) {
    //    int flag = userService.isExistUserName(username);
    //    //用户名未被使用
    //    if(flag==0) {
    //        return "ok";
    //    }else{
    //        //用户名已被使用
    //        return "error";
    //    }
    //}
    @ResponseBody
    @RequestMapping("/doRegister")
    public  String register(@Param("username") String username, @Param("password") String password,HttpServletRequest request) throws MessagingException {
        int flag = userService.isExistUserName(username);
        //用户名未被使用
        if(flag==0) {
            User user=new User();
            String email=username;
            user.setUserName(username);
            //对密码进行MD5加密
            user.setUserPassword(MD5Util.md5Jdk(password));
            //设置默认头像
            user.setUserIcon("/upload/default-c.png");
            //设置用户状态为未激活状态
            user.setUserType("0");
            //设置默认简介
            user.setSynopsis("还没有简介哦");
            //设置默认昵称
            user.setNickName(username);
            //注册用户
            userService.register(user);
            //发送激活邮件
            MailUtil.sendMail(email,username);
            return "success";
        }else{
            //用户名已被使用
            return "error";
        }

    }
    @ResponseBody
    @RequestMapping("/toGetPass")
    public  String toGetPass(@Param("toMail") String toMail) throws MessagingException {
        int flag = userService.isExistUserName(toMail);
        //该邮箱存在
        if(flag!=0) {
            //发送激活邮件
            MailUtil.sendMail2(toMail);
            return "success";
        }else{
            //该邮箱不存在
            return "error";
        }

    }

    @RequestMapping("/getPass")
    public String getPass(@Param("email")String email,@Param("password")String password,HttpServletRequest request){
        User user= userService.selectUserByUserName(email);
        user.setUserPassword(password);
        userService.updateUser(user);
        //userService.changePassword(user.getId(),password);
        //String password=user.getUserPassword();
        ////将用户输入的密码进行MD5转码后比较
        //String oldp=MD5Util.md5Jdk(password);
        //if (password.equals(oldp)){
        //    userService.changePassword(user.getId(),MD5Util.md5Jdk(password));
        //    return "success";
        //}else {
        //    return "fail";
        //}
        return "login";
    }
    @RequestMapping("/activate")
    public  String activate(@Param("code") String code,@Param("username") String username, HttpServletRequest request){
        User user= userService.selectUserByUserName(username);
        //激活账户
        user.setUserType(code);
        userService.updateUser(user);
       //初始化空间
        UserSpace userSpace= new UserSpace();
        //设置初始化大小，1GB
        userSpace.setInitialSpace("1073741824");
        userSpace.setAllSpace("1073741824");
        userSpace.setUsedSpace("0");
        userSpace.setAvailableSpace("1073741824");
        userSpace.setUserId(user.getId());
        userSpaceService.initSpace(userSpace);
        //创建默认（陌生人、我的好友）分组
        PermissionGroup permissionGroup=new PermissionGroup();
        permissionGroup.setPermissionType("我的好友");
        permissionGroup.setUserId(user.getId());
        PermissionGroup permissionGroup1=new PermissionGroup();
        permissionGroup1.setPermissionType("陌生人");
        permissionGroup1.setUserId(user.getId());
        permissionGroupService.insert(permissionGroup);
        permissionGroupService.insert(permissionGroup1);
        return "login";
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
    @ResponseBody
    public String changeIcon(HttpServletRequest request ,Image image, @RequestParam(value="file")MultipartFile pictureFile) throws Exception{
        User user= (User) request.getSession().getAttribute("user");
        //设置本地保存路径
        String localPath="F:\\demos\\upload\\";
        //以icon+用户id的方式命名头像照片
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        //获取照片大小,以B/KB/MB为单位保存
        //String fileSize =FormatUtil.format(pictureFile.getSize()) ;
        //获取文件的扩展名
        String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
        //设置图片上传的虚拟路径
        String url = "/upload/";
        //以绝对路径保存重名命后的图片
        pictureFile.transferTo(new File(localPath+"/"+name + "." + ext));
        //保存头像路径到数据库
        userService.changeIcon(user.getId(),url+name+"." + ext);
        userService.selectUserById(user.getId());
        request.getSession().setAttribute("user", userService.selectUserById(user.getId()));
        return "ok";
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
        if (f){
            return "success";
        }else {
            return "fail";
        }

    }

}
