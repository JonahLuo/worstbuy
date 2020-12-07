package com.worstbuy.dao;

import com.worstbuy.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAPImpl implements UserDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAPImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long save(User user) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public List<User> list() {
        List<User> list = sessionFactory.getCurrentSession().createQuery("from user").list();
        return list;
    }

    @Override
    public void delete(Long id) {

    }
}
