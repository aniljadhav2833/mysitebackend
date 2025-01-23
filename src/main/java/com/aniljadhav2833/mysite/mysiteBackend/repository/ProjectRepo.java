package com.aniljadhav2833.mysite.mysiteBackend.repository;

import com.aniljadhav2833.mysite.mysiteBackend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Integer> {
}
