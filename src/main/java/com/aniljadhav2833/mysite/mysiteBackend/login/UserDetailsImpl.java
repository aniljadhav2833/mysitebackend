package com.aniljadhav2833.mysite.mysiteBackend.login;

import com.aniljadhav2833.mysite.mysiteBackend.model.LoginUser;
import com.aniljadhav2833.mysite.mysiteBackend.repository.LoginUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    @Autowired
    LoginUserRepo loginUserRepo;
    private LoginUser loginUser;

    public UserDetailsImpl(LoginUser loginUser){
        this.loginUser = loginUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(loginUser.getRoleName()));
    }

    @Override
    public String getPassword() {
        return loginUser.getPassword();
    }

    @Override
    public String getUsername() {
        return loginUser.getUserName();
    }
}
