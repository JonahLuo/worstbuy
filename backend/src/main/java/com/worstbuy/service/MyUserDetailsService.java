package com.worstbuy.service;

import com.worstbuy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    UserService userService;

    @Autowired
    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new User("foo", "foo", new ArrayList<>());
        User user = findUserByUsername(username);
        org.springframework.security.core.userdetails.User.UserBuilder builder =null;
        if(user != null){
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            builder.authorities(new ArrayList<>());
//            builder.roles(user.getRoles());
        }else{
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

    private User findUserByUsername(String username){
        return userService.findUserByEmail(username);
    }
}
