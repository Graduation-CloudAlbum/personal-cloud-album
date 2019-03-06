package cn.yznu.pca.controller;


import cn.yznu.pca.model.Album;
import cn.yznu.pca.model.Image;
import cn.yznu.pca.model.User;
import cn.yznu.pca.service.AlbumService;
import cn.yznu.pca.service.ImageService;
import cn.yznu.pca.service.UserService;
import cn.yznu.pca.utils.FormatUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

/**
 * @author yangbaiwan
 * @date 2018-09-28
 * 图片上传实现原理：提交图片到某个文件夹并返回图片路径 ，将路径保存到数据库
 */
@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    ImageService imageService;
    @Autowired
    UserService userService;
    @Autowired
    AlbumService albumService;

    @RequestMapping("/getImage")
    @ResponseBody
    public Map getImage(@Param("albumName") String albumName, HttpServletRequest request ){
        User user= (User) request.getSession().getAttribute("user");
        int userId=user.getId();
        System.out.println("相册名是："+albumName);
        List albumlist=albumService.selectAlbumByName(userId,albumName);
        Album album = (Album) albumlist.get(0);
        int albumId=album.getId();
        String  satus="0";
        List list=imageService.getImage(satus,userId,albumId);
        Map map=new HashMap();
        map.put("imageList",list);
        return map;
    }
    @RequestMapping("/goUpload")
    @ResponseBody
    public int goUpload(@Param("albumName") String albumName,HttpServletRequest request ){
    //    String username= (String) request.getSession().getAttribute("username");
    //    String password= (String) request.getSession().getAttribute("password");
    //    String md5pwd=MD5Util.md5Jdk(password);
    //    User user=userService.checkLogin(username,md5pwd);
        User user= (User) request.getSession().getAttribute("user");
        int userId=user.getId();
        System.out.println("页面传过来的相册名是："+albumName);
        List albumlist=albumService.selectAlbumByName(userId,albumName);
        Album album = (Album) albumlist.get(0);
        int albumId=album.getId();
        System.out.println("获取的相册id是"+albumId);
        request.getSession().setAttribute("albumId",albumId);
        return albumId;
    }

    @RequestMapping("/upload")
    public String upload( HttpServletRequest request ,Image image, @RequestParam(value="files")MultipartFile pictureFile) throws Exception{

        User user= (User) request.getSession().getAttribute("user");
        int albumId= (int) request.getSession().getAttribute("albumId");
        //获取用户ID,并设置照片所属用户
        int userId=user.getId();
        image.setUserId(userId);
        //设置照片所在相册
        image.setAlbumId(albumId);
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
        //String url =request.getSession().getServletContext()
        //        .getRealPath("/upload");
        //以绝对路径保存重名命后的图片
        pictureFile.transferTo(new File(localPath+"/"+name + "." + ext));
        //保存图片信息到数据库
        image.setImageName(name);
        image.setUrl(url+name+"." + ext);
        image.setImageSize(fileSize);
        imageService.upload(image);
        //返回到相册，测试图片回显
        return "myAlbum";
    }
    @RequestMapping("/uploadMany")
    public String uploadMany( HttpServletRequest request ,Image image, @RequestParam(value="files",required=false)MultipartFile[] pictureFile) throws Exception{
        //定义序号
        int count=1;
        for (MultipartFile mf : pictureFile) {
            if (!mf.isEmpty()) {
                User user = (User) request.getSession().getAttribute("user");
                int albumId = (int) request.getSession().getAttribute("albumId");
                //获取用户ID,并设置照片所属用户
                int userId = user.getId();
                //image.setUserId(userId);
                ////设置照片所在相册
                //image.setAlbumId(albumId);
                //设置本地保存路径
                String localPath = "F:\\demos\\upload\\";
                //使用UUID给图片重命名，并去掉四个“-”
                String name = UUID.randomUUID().toString().replaceAll("-", "");
                //获取照片大小,以B/KB/MB为单位保存
                String fileSize = FormatUtil.format(mf.getSize());
                //获取文件的扩展名
                String ext = FilenameUtils.getExtension(mf.getOriginalFilename());
                //设置图片上传的虚拟路径
                String url = "/upload/";
                //String url =request.getSession().getServletContext()
                //        .getRealPath("/upload");
                //以绝对路径保存重名命后的图片
                mf.transferTo(new File(localPath + "/" + name + "." + ext));
                //保存图片信息到数据库
                //image.setImageName(name);
                ////image.setUrl(url + name + "." + ext);
                //image.setImageSize(fileSize);
                if (count == 1) {
                    image.setUserId(userId);
                    image.setAlbumId(albumId);
                    image.setImageName(name);
                    image.setImageSize(fileSize);
                    image.setUrl(url + name + "." + ext);
                } else if (count == 2) {
                    image.setUserId(userId);
                    image.setAlbumId(albumId);
                    image.setImageName(name);
                    image.setImageSize(fileSize);
                    image.setUrl(url + name + "." + ext);
                } else if (count == 3) {
                    image.setUserId(userId);
                    image.setAlbumId(albumId);
                    image.setImageName(name);
                    image.setImageSize(fileSize);
                    image.setUrl(url + name + "." + ext);
                }
            }
            count++;
        }
        imageService.upload(image);
        //返回到相册，测试图片回显
        return "myAlbum";
    }


    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename, Model model)throws Exception {
        //文件下载路径,图片文件夹真实路径
        String path = request.getServletContext().getRealPath("/upload/");
        File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        System.out.println("下载文件名是："+downloadFielName);
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 设置以二进制流数据的形式下载（最常见的文件下载）
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
}
