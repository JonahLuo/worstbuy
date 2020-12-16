package com.worstbuy.service;

import com.worstbuy.dao.UserDAO;
import com.worstbuy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public long save(User user) {
        return userDAO.save(user);
    }

    @Override
    @Transactional
    public void update(long id, User user) {
        userDAO.update(id, user);
    }

    @Override
    @Transactional
    public User get(long id) {
        return userDAO.get(id);
    }

    @Override
    public User getByName(String username) {
        return userDAO.getByName(username);
    }

    @Override
    @Transactional
    public List<User> list() {
        return userDAO.list();
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDAO.delete(id);
    }
}
