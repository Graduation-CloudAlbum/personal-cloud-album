package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.ImageMapper;
import cn.yznu.pca.model.Image;
import cn.yznu.pca.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yangbaiwan
 * @date 2018-10-19
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public List getImage(String status,Integer userId, Integer albumId) {

        return imageMapper.selectImage(status,userId,albumId);
    }

    @Override
    public int upload(Image image) {
        return imageMapper.insertSelective(image);

    }

    @Override
    public int download(Image image) {
    return 0;
    }

    @Override
    public int deleteImageById(Integer[] imageId) {
        return imageMapper.updateImageStatus(imageId);
    }

    @Override
    public int deleteImageByAlbumId(Integer albumId) {
        return imageMapper.updateImageStatusInAlbum(albumId);
    }

    @Override
    public int updateImage(Integer[] imageId, int albumId) {
        return imageMapper.updateImageToAlbum(imageId,albumId);
    }

    @Override
    public int getAllImageNum(int userId) {

        return  imageMapper.getAllImageNum(userId);
    }

    @Override
    public int imageNum(int userId, int albumId) {
        return imageMapper.getImageNum(userId,albumId);
    }

    @Override
    public Image getFirstOne(int userId, int albumId) {
        return imageMapper.selectFirst(userId,albumId);
    }


}
