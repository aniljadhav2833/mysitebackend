package com.aniljadhav2833.mysite.mysiteBackend.controller;

import com.aniljadhav2833.mysite.mysiteBackend.dto.ProjectDTO;
import com.aniljadhav2833.mysite.mysiteBackend.model.Project;
import com.aniljadhav2833.mysite.mysiteBackend.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @GetMapping("/getallprojects")
    public ResponseEntity<?> getAllProject(){
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
    @GetMapping("/getproject/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable Integer id){
        Project projects = projectService.getProject(id);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping("addproject")
    public ResponseEntity<?> addProject(@RequestBody ProjectDTO projectDTO){
        Project project = projectService.saveProject(projectDTO);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }
    @PostMapping("addprojects")
    public ResponseEntity<?> addProjects(@RequestBody List<ProjectDTO> projectDTOs){
        List<Project> projects = projectService.saveAllProjects(projectDTOs);
        return new ResponseEntity<>(projects, HttpStatus.CREATED);
    }

    @DeleteMapping("deleteproject")
    public ResponseEntity<?> deleteProject(@RequestParam Integer id){
        boolean isDeleted = projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
