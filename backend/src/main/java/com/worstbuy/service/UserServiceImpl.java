package com.worstbuy.service;

import com.worstbuy.dao.UserDAO;
import com.worstbuy.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
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
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
