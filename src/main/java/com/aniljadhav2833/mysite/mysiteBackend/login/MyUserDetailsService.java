package com.aniljadhav2833.mysite.mysiteBackend.login;

import com.aniljadhav2833.mysite.mysiteBackend.model.LoginUser;
import com.aniljadhav2833.mysite.mysiteBackend.repository.LoginUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    LoginUserRepo loginUserRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser login = loginUserRepo.findByUserName(username);
        return new UserDetailsImpl(login);
    }
}
