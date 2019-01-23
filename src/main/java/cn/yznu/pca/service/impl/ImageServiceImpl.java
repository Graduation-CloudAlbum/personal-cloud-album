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
    public List<Image> getAllImages(Integer user_id) {
        List<Image> imageList=imageMapper.selectAllImage("0",user_id);
        return imageList;
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
    public int getImageNum(int userId) {

        return  imageMapper.getImageNum(userId);
    }


}
