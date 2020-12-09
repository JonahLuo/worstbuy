package com.worstbuy.dao;

import com.worstbuy.model.Poster;
import org.hibernate.Session;
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
    public Poster get(long id) {
        return sessionFactory.getCurrentSession().get(Poster.class, id);
    }

    @Override
    public long save(Poster poster) {
        sessionFactory.getCurrentSession().save(poster);
        return poster.getId();
    }

    @Override
    public List<Poster> list() {
        List<Poster> list = sessionFactory.getCurrentSession().createQuery("from poster").list();
        return list;
    }

    @Override
    public void update(long id, Poster poster) {
        Session session = sessionFactory.getCurrentSession();
        Poster oldPoster = session.byId(Poster.class).load(id);
        oldPoster.setBrand(poster.getBrand());
        oldPoster.setCategory(poster.getCategory());
        oldPoster.setClose(poster.isClose());
        oldPoster.setCondition(poster.getCondition());
        oldPoster.setDescription(poster.getDescription());
        oldPoster.setPrice(poster.getPrice());
        oldPoster.setTag(poster.getTag());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Poster poster = session.byId(Poster.class).load(id);
        session.delete(poster);

    }
}
