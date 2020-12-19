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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/user")
    public ResponseEntity<?> save(@RequestBody User user){
        long id = userService.save(user);
        return ResponseEntity.ok().body("User created with id: " + id);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user/{id}")
    public ResponseEntity<User> get(@PathVariable("id") String id){
        User user = userService.get(Long.parseLong(id));
        return ResponseEntity.ok().body(user);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody User user){
        userService.update(Long.parseLong(id),user);
        return ResponseEntity.ok().body("User Updated with id: " + id);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        userService.delete(Long.parseLong(id));
        return ResponseEntity.ok().body("User deleted with id: " + id);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users")
    public ResponseEntity<User> getUserByEmail(@RequestParam("email") String email){
        User user = userService.findUserByEmail(email);
        return ResponseEntity.ok().body(user);
    }
}
