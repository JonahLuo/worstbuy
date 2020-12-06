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
    public long save(User user) {
        return 0;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public List<User> list() {
        List<User> list = sessionFactory.getCurrentSession().createQuery("from User").list();
        return list;
    }

    @Override
    public void delete(long id) {

    }
}
