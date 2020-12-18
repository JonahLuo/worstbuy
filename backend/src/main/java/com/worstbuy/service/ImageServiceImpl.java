package com.worstbuy.service;

import com.worstbuy.dao.ImageDAO;
import com.worstbuy.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageDAO imageDAO;

    @Autowired
    public ImageServiceImpl(ImageDAO imageDAO) {
        this.imageDAO = imageDAO;
    }

    @Override
    public Image findById(long id) {
        return imageDAO.findById(id);
    }

    @Override
    public Image findByName(String name) {
        return imageDAO.findByName(name);
    }

    @Override
    public Long save(Image image) {
        return imageDAO.save(image);
    }
}
