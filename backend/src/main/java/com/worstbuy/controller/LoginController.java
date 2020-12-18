package com.worstbuy.controller;

import com.worstbuy.model.JwtRequest;
import com.worstbuy.service.JwtTokenUtil;
import com.worstbuy.service.MyUserDetailsService;
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

//    @CrossOrigin
//    @PostMapping(value="/auth/")
//    public @ResponseBody
//    JwtResponse login(@RequestBody User user) {
//        //模拟去查询数据库，看是否存在此用户
//        boolean login = toLogin(user);
//        JwtResponse responseData = JwtResponse.ok();
//        if(login) {
//            //生成token
//            String token = JwtTokenUtil.generToken("1", "Jersey-Security-Basic", user.getEmail());
//            //向浏览器返回token，客户端受到此token后存入cookie中，或者h5的本地存储中
//            responseData.putDataValue("token", token);
//            //以及用户
//            responseData.putDataValue("user", user);
//        }else {
//            //用户或者密码错误
//            responseData=JwtResponse.customerError();
//        }
//        return responseData;
//    }
//    public boolean toLogin(User user) {
//        System.out.println(user.getEmail());
//        if(user.getEmail()!=null&&user.getEmail().trim().length()>0) {
//            if(user.getEmail().equals("root@123.com")) {
//                if(user.getPassword().equals("123456")) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

}
