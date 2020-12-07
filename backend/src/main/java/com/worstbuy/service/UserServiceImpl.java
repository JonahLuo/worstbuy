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
    @Transactional
    public List<User> list() {
        return userDAO.list();
    }

    @Override
    public void delete(Long id) {

    }
}
