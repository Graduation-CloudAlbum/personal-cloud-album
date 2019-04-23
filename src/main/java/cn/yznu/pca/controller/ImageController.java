package cn.yznu.pca.controller;


import cn.yznu.pca.model.*;
import cn.yznu.pca.service.*;
import cn.yznu.pca.utils.FormatUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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

    @Autowired
    private RecycleBinService recycleBinService;

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
        //通过用户id和相册名获取到唯一相册
        List albumlist = albumService.selectAlbumByName(userId, albumName);
        Album album = (Album) albumlist.get(0);
        //获取该相册id
        int albumId = album.getId();
        String satus = "0";
        //获取照片
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
        ////1，获取原始文件名
        //String originalFilename = multipartFile.getOriginalFilename();
        ////2,截取源文件的文件名前缀,不带后缀
        //String fileNamePrefix = originalFilename.substring(0,originalFilename.lastIndexOf("."));
        ////3,加工处理文件名，原文件加上时间戳
        //String newFileNamePrefix  = fileNamePrefix + System.currentTimeMillis();
        ////4,得到新文件名
        //String newFileName = newFileNamePrefix + originalFilename.substring(originalFilename.lastIndexOf("."));

        User user = (User) request.getSession().getAttribute("user");
        int albumId = (int) request.getSession().getAttribute("albumId");
       // //获取用户ID
        final int userId = user.getId();
       // //处理页面传过来的时间字符串，用空格替换T
        String loutTime = logOutTime.replaceAll("T", " ");
        System.out.println("logOutTime1 is"+loutTime);
       // //设置日期格式
       // //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
       // //转换成date
       //// Date date=sdf.parse(loutTime);
       // //logOutTime为空，表示未设置定时上传
        if ("" == loutTime || null == loutTime||("").equals(loutTime)) {
            System.out.println("pictureFile.length is :"+pictureFile.length);
            for (int i = 0; i < pictureFile.length ; i++) {
                MultipartFile file = pictureFile[i];
                //设置本地保存路径
                String localPath = "D:\\demos\\upload\\";
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

            for (int i = 0; i < pictureFile.length; i++) {
                MultipartFile file = pictureFile[i];
                System.out.println("pictureFile.length is :"+pictureFile.length);
                //设置本地保存路径
                String localPath = "D:\\demos\\upload\\";
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
         * @param
         * @return
         * @throws Exception
         */
        @RequestMapping("/download")
        @ResponseBody
        public void download (final HttpServletResponse response, HttpServletRequest request)throws
        Exception {
            String imagePath = request.getParameter("image");
            String[] path = imagePath.split(",");
             if (path.length==1){
                 File file = new File(path[0]);
                 System.out.println(file.getName());
                 String fname=path[0].substring(path[0].lastIndexOf("/")+1);

                 //将文件读取到输入流
                 InputStream bis = new BufferedInputStream(new FileInputStream(file));

                 //设置文件转码
                 fname = URLEncoder.encode(fname,"UTF-8");


                 //解决中文显示乱码
                 response.addHeader("Content-Disposition", "attachment;filename=" + fname);

                 //设置响应的类型
                 //response.setContentType("multipart/form-data");
                 response.setContentType("application/x-download");

                 //将对应文件读取出来
                 BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());

                 int len=0 ;
                 //byte[] b = new byte[1024];
                 while((len = bis.read()) != -1){
                     out.write(len);
                     out.flush();

                 }
                 out.close();
            }else if (path.length>1){
                 ServletOutputStream out;
                 FileInputStream instream = null;
                 try {
                     ZipOutputStream zipstream = new ZipOutputStream(response.getOutputStream());
                     for (int i = 0; i < path.length; ++i) {
                         File file = new File(path[i]);
                         instream = new FileInputStream(file);
                         ZipEntry entry = new ZipEntry(file.getName());
                         zipstream.putNextEntry(entry);
                         byte[] buffer = new byte[1024];
                         int len = 0;
                         while (len != -1) {
                             len = instream.read(buffer);
                             zipstream.write(buffer, 0, buffer.length);
                         }
                         instream.close();
                         zipstream.closeEntry();
                         zipstream.flush();
                     }
                     zipstream.finish();
                     zipstream.close();
                 } catch (IOException e) {
                     new RuntimeException(e.getMessage());
                 }
             }
        }

        /**
         * 删除照片（包含单个和批量操作）
         * @param imageId 照片id
         * @param request
         * @return
         */
        @RequestMapping("/deleteImage")
        @ResponseBody
        public int deleteImage (@Param("imageId") Integer[]imageId, @Param("aName") String aName,HttpServletRequest request ){
            User user = (User) request.getSession().getAttribute("user");
            int userId = user.getId();
            //通过用户id和相册名获取到唯一相册
            List albumlist = albumService.selectAlbumByName(userId, aName);
            Album album = (Album) albumlist.get(0);
            //获取该相册id
            int albumId = album.getId();
            List<RecycleBin> recycleBinList=new ArrayList<>();
            for (int i=0;i<imageId.length;i++){
                RecycleBin recycleBin=new RecycleBin();
                recycleBin.setAlbumId(albumId);
                recycleBin.setImageId(imageId[i]);
                recycleBin.setUserId(userId);
                recycleBinList.add(recycleBin);
            }
            recycleBinService.insertRecycleBin(recycleBinList);
            return imageService.deleteImageById(imageId);
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
