package com.worstbuy.controller;

import com.worstbuy.model.JwtRequest;
import com.worstbuy.model.User;
import com.worstbuy.service.JwtTokenUtil;
import com.worstbuy.service.MyUserDetailsService;
import com.worstbuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/auth/login")
    public ResponseEntity<?> generateAuthToken(@RequestBody JwtRequest jwtRequest) throws Exception{

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getEmail());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new com.worstbuy.model.JwtResponse(jwt));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/auth/sign-up")
    public ResponseEntity<?> signup(@RequestBody User user, JwtRequest jwtRequest) throws Exception{
        if(!userService.checkBeforeSignup(user)) return ResponseEntity.badRequest().body("User has been exists");
        userService.save(user);
        jwtRequest.setEmail(user.getEmail());
        jwtRequest.setPassword(user.getPassword());
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getEmail());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new com.worstbuy.model.JwtResponse(jwt));
    }


}
