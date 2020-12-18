package com.worstbuy.dao;

import com.worstbuy.model.Image;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDAOImpl implements ImageDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public ImageDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Image findById(long id) {
        Image image = this.sessionFactory.getCurrentSession().get(Image.class, id);
        return image;
    }

    @Override
    public Image findByName(String name) {
        return null;
    }

    @Override
    public Long save(Image image) {
        this.sessionFactory.getCurrentSession().save(image);
        return image.getId();
    }
}
