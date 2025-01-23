package com.aniljadhav2833.mysite.mysiteBackend.services;

import com.aniljadhav2833.mysite.mysiteBackend.dto.ProjectDTO;
import com.aniljadhav2833.mysite.mysiteBackend.model.Project;
import com.aniljadhav2833.mysite.mysiteBackend.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;


    public List<Project> getAllProjects(){
        return projectRepo.findAll();
    }

    public Project getProject(Integer id){
        Optional<Project> optionProject = projectRepo.findById(id);
        return optionProject.orElse(null);
    }

    public Project saveProject(ProjectDTO projectDTO){
        Project project = convertDTOToModel(projectDTO);
        return projectRepo.save(project);
    }

    public List<Project> saveAllProjects(List<ProjectDTO> projectDTOS){
        List<Project> projects = new ArrayList<>();
        for(ProjectDTO projectDTO: projectDTOS){
            Project project = convertDTOToModel(projectDTO);
            projects.add(project);
        }

        return projectRepo.saveAll(projects);
    }

    /*public Project updateProject(ProjectDTO projectDTO){
        Project project = getProject(projectDTO.getProjectid());
        return projectRepo.save(project);
    }*/


    public boolean deleteProject(Integer id){
        Optional<Project> optionProject = projectRepo.findById(id);
        boolean isDeleted = false;
        if(optionProject.isPresent())
        {
            projectRepo.deleteById(id);
            isDeleted = true;
        }
        return isDeleted;
    }

    public List<Boolean> deleteProjects(List<Integer> ids){
       List<Boolean> isDeletedList = new ArrayList<>(ids.size());
        for (int id: ids){
           boolean isDeleted = deleteProject(id);
           isDeletedList.add(isDeleted);
       }
       return isDeletedList;
    }



    private Project convertDTOToModel(ProjectDTO projectDTO){
        Project project = new Project();
        project.setProjectid(projectDTO.getProjectid());
        project.setProjectName(projectDTO.getProjectName());
        project.setProjectDesc(projectDTO.getProjectDesc());
        project.setProjectPath(projectDTO.getProjectPath());
        project.setProjectPhoto(projectDTO.getProjectPhoto());
        return project;
    }

    private ProjectDTO convertModelToDTO(Project project){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectid(project.getProjectid());
        projectDTO.setProjectName(project.getProjectName());
        projectDTO.setProjectDesc(project.getProjectDesc());
        projectDTO.setProjectPath(project.getProjectPath());
        projectDTO.setProjectPhoto(project.getProjectPhoto());
        return projectDTO;
    }

}
