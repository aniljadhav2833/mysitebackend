package com.aniljadhav2833.mysite.mysiteBackend.services;

import com.aniljadhav2833.mysite.mysiteBackend.dto.UserDTO;
import com.aniljadhav2833.mysite.mysiteBackend.dto.UserResp;
import com.aniljadhav2833.mysite.mysiteBackend.login.JWTUtil;
import com.aniljadhav2833.mysite.mysiteBackend.model.LoginUser;
import com.aniljadhav2833.mysite.mysiteBackend.repository.LoginUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginUserService {


    @Autowired
    LoginUserRepo loginUserRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    public String verify(UserDTO userDTO) {
        LoginUser loginUser = convertDTOToModel(userDTO);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUser.getUserName(), loginUser.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtUtil.generateToken(loginUser.getUserName());
        }
        return "BAD creadtionals";
    }
    public List<UserResp> getAllUsers(){
        List<UserResp> userRespList = new ArrayList<>();
        List<LoginUser> list = loginUserRepo.findAll();
        for(LoginUser user: list){
            userRespList.add(convertModelToUserResp(user));
        }
        return userRespList;
    }

    public LoginUser saveUser(LoginUser loginUser){

        loginUser.setPassword(passwordEncoder.encode(loginUser.getPassword()));
        return loginUserRepo.save(loginUser);
    }

    private LoginUser convertDTOToModel(UserDTO userDTO){
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(userDTO.getUserId());
        loginUser.setUserName(userDTO.getUserName());
        loginUser.setPassword(userDTO.getPassword());
        loginUser.setRoleName(userDTO.getRoleName());
        return loginUser;

    }

    private UserResp convertModelToUserResp(LoginUser user){
        UserResp userResp = new UserResp();
        userResp.setUserName(user.getUserName());
        userResp.setRoleName(user.getRoleName());
        return userResp;

    }


}
