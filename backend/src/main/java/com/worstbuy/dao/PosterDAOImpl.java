package com.worstbuy.dao;

import com.worstbuy.model.Poster;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PosterDAOImpl implements PosterDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public PosterDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Poster get(Long id) {
        return null;
    }

    @Override
    public Long save(Poster poster) {
        return null;
    }

    @Override
    public List<Poster> list() {
        return null;
    }

    @Override
    public void update(Poster poster) {

    }

    @Override
    public void delete(long id) {

    }
}
