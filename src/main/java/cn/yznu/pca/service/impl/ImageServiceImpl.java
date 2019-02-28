package cn.yznu.pca.service.impl;

import cn.yznu.pca.dao.ImageMapper;
import cn.yznu.pca.model.Image;
import cn.yznu.pca.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int getAllImageNum(int userId) {

        return  imageMapper.getAllImageNum(userId);
    }

    @Override
    public int imageNum(int userId, int albumId) {
        return imageMapper.getImageNum(userId,albumId);
    }


}
