package com.aniljadhav2833.mysite.mysiteBackend.repository;

import com.aniljadhav2833.mysite.mysiteBackend.model.DocumentFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentFileRepo extends JpaRepository<DocumentFile, Integer> {
}
