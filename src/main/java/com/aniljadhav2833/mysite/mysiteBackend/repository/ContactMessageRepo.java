package com.aniljadhav2833.mysite.mysiteBackend.repository;

import com.aniljadhav2833.mysite.mysiteBackend.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactMessageRepo extends JpaRepository<ContactMessage, Integer> {
    List<ContactMessage> findByReplied(boolean isReplied);
}
