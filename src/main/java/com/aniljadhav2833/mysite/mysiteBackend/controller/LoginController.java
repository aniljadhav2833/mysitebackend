package com.aniljadhav2833.mysite.mysiteBackend.controller;

import com.aniljadhav2833.mysite.mysiteBackend.dto.UserDTO;
import com.aniljadhav2833.mysite.mysiteBackend.dto.UserResp;
import com.aniljadhav2833.mysite.mysiteBackend.model.LoginUser;
import com.aniljadhav2833.mysite.mysiteBackend.services.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    LoginUserService usersService;


    @PostMapping("/login")
    public ResponseEntity<String> getJwtToken(@RequestBody UserDTO userDTO){
        String jwtToken = usersService.verify(userDTO);
        System.err.println(jwtToken);
        return  new ResponseEntity<>(jwtToken, HttpStatus.CREATED);
    }


    @GetMapping("/getuser")
    public List<UserResp> getAllUsers(){
        return usersService.getAllUsers();
    }

    @PostMapping("/adduser")
    public LoginUser addUser(@RequestBody LoginUser users){
        return usersService.saveUser(users);
    }

}
