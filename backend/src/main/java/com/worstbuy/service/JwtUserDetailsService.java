package com.worstbuy.service;

import com.worstbuy.dao.UserDAO;
import com.worstbuy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.getByName(username);
//        UserEntity user = repo.findByUsername(username);
        if(user!=null){
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(), user.getPassword(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found with username: "+ username);
        }
    }
}
