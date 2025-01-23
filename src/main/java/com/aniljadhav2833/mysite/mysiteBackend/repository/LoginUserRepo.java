package com.aniljadhav2833.mysite.mysiteBackend.repository;

import com.aniljadhav2833.mysite.mysiteBackend.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserRepo extends JpaRepository<LoginUser, Integer> {
    LoginUser findByUserName(String username);
}
