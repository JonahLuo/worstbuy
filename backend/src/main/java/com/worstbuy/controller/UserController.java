package com.worstbuy.controller;


import com.worstbuy.model.User;
import com.worstbuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> list(){
        List<User> list = userService.list();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/user")
    public ResponseEntity<?> save(@RequestBody User user){
        long id = userService.save(user);
        return ResponseEntity.ok().body("User created with id: " + id);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> get(@PathVariable("id") long id){
        User user = userService.get(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody User user){
        userService.update(id,user);
        return ResponseEntity.ok().body("User Updated with id: " + id);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        userService.delete(id);
        return ResponseEntity.ok().body("User deleted with id: " + id);
    }
}
