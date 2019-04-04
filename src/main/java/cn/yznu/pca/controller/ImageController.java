package cn.yznu.pca.controller;


import cn.yznu.pca.model.Album;
import cn.yznu.pca.model.Image;
import cn.yznu.pca.model.User;
import cn.yznu.pca.model.UserSpace;
import cn.yznu.pca.service.AlbumService;
import cn.yznu.pca.service.ImageService;
import cn.yznu.pca.service.UserService;
import cn.yznu.pca.service.UserSpaceService;
import cn.yznu.pca.utils.FormatUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yangbaiwan
 * @date 2018-09-28
 * 图片上传实现原理：提交图片到某个磁盘文件夹中并返回图片路径 ，将路径保存到数据库
 */
@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private UserSpaceService userSpaceService;

    private static String EXCLUSIVE = "我的专属";

    /**
     * 查询相册中的照片
     *
     * @param albumName 相册名
     * @param request
     * @return
     */
    @RequestMapping("/getImage")
    @ResponseBody
    public Map getImage(@Param("albumName") String albumName, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getId();
        System.out.println("相册名是：" + albumName);
        //通过用户id和相册名获取到唯一相册
        List albumlist = albumService.selectAlbumByName(userId, albumName);
        Album album = (Album) albumlist.get(0);
        //获取该相册id
        int albumId = album.getId();
        String satus = "0";
        List list = imageService.getImage(satus, userId, albumId);
        //Image coverIma= (Image) list.get(0);
        Map map = new HashMap();
        //map.put("coverIma",coverIma);
        map.put("imageList", list);
        return map;
    }

    /**
     * 上传准备，通过相册名获取相册id
     *
     * @param albumName 相册名
     * @param request
     * @return
     */
    @RequestMapping("/goUpload")
    @ResponseBody
    public int goUpload(@Param("albumName") String albumName, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getId();
        System.out.println("页面传过来的相册名是：" + albumName);
        List albumlist = albumService.selectAlbumByName(userId, albumName);
        Album album = (Album) albumlist.get(0);
        int albumId = album.getId();
        System.out.println("获取的相册id是" + albumId);
        request.getSession().setAttribute("albumId", albumId);
        return albumId;
    }

    /**
     * 上传照片
     *
     * @param request
     * @param image       iamge对象
     * @param pictureFile 照片文件
     * @return
     * @throws Exception
     */
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, final Image image, String logOutTime, @RequestParam(value = "files", required = false) MultipartFile[] pictureFile) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        int albumId = (int) request.getSession().getAttribute("albumId");
        //获取用户ID
        final int userId = user.getId();
        //处理页面传过来的时间字符串，用空格替换T
        String loutTime = logOutTime.replaceAll("T", " ");
        //设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //转换成date
        Date date=sdf.parse(loutTime);
        //logOutTime为空，表示未设置定时上传
        if ("" == logOutTime || null == logOutTime) {
            for (int i = 0; i < pictureFile.length - 1; i++) {
                MultipartFile file = pictureFile[i];
                //设置本地保存路径
                String localPath = "F:\\demos\\upload\\";
                //使用UUID给图片重命名，并去掉四个“-”
                String name = UUID.randomUUID().toString().replaceAll("-", "");
                //获取照片大小,以B(字节)为单位保存
                String fileSize = String.valueOf(file.getSize());
                //获取文件的扩展名
                String ext = FilenameUtils.getExtension(file.getOriginalFilename());
                //设置图片上传的虚拟路径
                String url = "/upload/";
                //保存照片到硬盘
                file.transferTo(new File(localPath + "/" + name + "." + ext));
                //保存照片名
                image.setImageName(name);
                //保存照片大小
                image.setImageSize(fileSize);
                //设置所属用户
                image.setUserId(userId);
                //保存到相册
                image.setAlbumId(albumId);
                //保存照片url
                image.setUrl(url + name + "." + ext);
                //上传照片
                imageService.upload(image);
                //计算所有照片占用的空间
                UserSpace userSpace = userSpaceService.getSpace(userId);
                //总空间
                String all = userSpace.getAllSpace();
                //获取所有照片占用的空间
                String used = userSpace.getUsedSpace();
                //计算剩余可用空间
                String available = FormatUtil.minus(all, used);
                //更新用户的空间信息
                userSpaceService.updateSpace(userId, all, used, available);
            }
        }else {
            //截取时间字符串中的年、月、日、分，设置定时任务触发时间
            Calendar calendar = Calendar.getInstance();
            int year = Integer.valueOf(loutTime.substring(0, 4));
            int month = Integer.valueOf(loutTime.substring(5, 7));
            int day = Integer.valueOf(loutTime.substring(8, 10));
            int hour = Integer.valueOf(loutTime.substring(11, 13));
            int minute = Integer.valueOf(loutTime.substring(14, 16));
            calendar.set(year, month - 1, day, hour, minute, 0);
            Date time = calendar.getTime();
            Timer timer = new Timer();

            for (int i = 0; i < pictureFile.length - 1; i++) {
                MultipartFile file = pictureFile[i];

                //设置本地保存路径
                String localPath = "F:\\demos\\upload\\";
                //使用UUID给图片重命名，并去掉四个“-”
                String name = UUID.randomUUID().toString().replaceAll("-", "");
                //获取照片大小,以B(字节)为单位保存
                String fileSize = String.valueOf(file.getSize());
                //获取文件的扩展名
                String ext = FilenameUtils.getExtension(file.getOriginalFilename());
                //设置图片上传的虚拟路径
                String url = "/upload/";
                //保存照片到硬盘
                file.transferTo(new File(localPath + "/" + name + "." + ext));
                //保存照片名
                image.setImageName(name);
                //保存照片大小
                image.setImageSize(fileSize);
                //设置所属用户
                image.setUserId(userId);
                //保存到相册
                image.setAlbumId(albumId);
                //保存照片url
                image.setUrl(url + name + "." + ext);
                //开始定时任务
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("定时任务开始了");
                        imageService.upload(image);
                        //计算所有照片占用的空间
                        UserSpace userSpace = userSpaceService.getSpace(userId);
                        //总空间
                         String all = userSpace.getAllSpace();
                        //获取所有照片占用的空间
                         String used = userSpace.getUsedSpace();
                        //计算剩余可用空间
                         String available = FormatUtil.minus(all, used);
                        //更新用户的空间信息
                        userSpaceService.updateSpace(userId, all, used, available);
                    }
                }, time);

            }
        }
            return "myAlbum";

    }
        /**
         * 下载照片
         * @param request
         * @param filename 文件名
         * @return
         * @throws Exception
         */
        @RequestMapping("/download")
        public ResponseEntity<byte[]> download (HttpServletRequest request, @RequestParam("filename") String filename)throws
        Exception {
            //文件下载路径,图片文件夹真实路径
            String path = request.getServletContext().getRealPath("/upload/");
            File file = new File(path + File.separator + filename);
            HttpHeaders headers = new HttpHeaders();
            //下载显示的文件名，解决中文名称乱码问题
            String downloadFielName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
            System.out.println("下载文件名是：" + downloadFielName);
            //通知浏览器以attachment（下载方式）打开图片
            headers.setContentDispositionFormData("attachment", downloadFielName);
            //application/octet-stream ： 设置以二进制流数据的形式下载（最常见的文件下载）
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file),
                    headers, HttpStatus.CREATED);
        }

        /**
         * 删除照片（包含单个和批量操作）
         * @param imageId 照片id
         * @param request
         * @return
         */
        @RequestMapping("/deleteImage")
        @ResponseBody
        public int deleteImage (@Param("imageId") Integer[]imageId, HttpServletRequest request ){
            //User user = (User) request.getSession().getAttribute("user");
            //int userId = user.getId();
            //
            //return imageService.deleteImageById(imageId);
            //String items = request.getParameter("imageId");
            //List<Integer>   list= Arrays.asList(imageId);
            //System.out.println(list);
            //System.out.println(imageId);

            return imageService.deleteImageById(imageId);
            //return 0;
        }

        /**
         * 移动照片（包含单个和批量操作）
         * @param imageId 照片id
         * @param request
         * @return
         */
        @RequestMapping("/moveImage")
        @ResponseBody
        public int moveImage (@Param("imageId") Integer[]imageId, @Param("albumName") String
        albumName, HttpServletRequest request ){
            User user = (User) request.getSession().getAttribute("user");
            int userId = user.getId();
            List albumlist = albumService.selectAlbumByName(userId, albumName);
            Album album = (Album) albumlist.get(0);
            int albumId = album.getId();
            return imageService.updateImage(imageId, albumId);
        }
    }
