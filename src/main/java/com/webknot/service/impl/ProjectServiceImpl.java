package com.webknot.service.impl;

import com.webknot.dto.AllocationDTO;
import com.webknot.dto.ProjectDTO;
import com.webknot.entity.Project;
import com.webknot.repository.ProjectRepository;
import com.webknot.service.AllocationService;
import com.webknot.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private AllocationService allocationService;

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setProjectType(projectDTO.getProjectType());
        project.setSourceClient(projectDTO.getSourceClient());
        project.setEndClient(projectDTO.getEndClient());
        project.setDescription(projectDTO.getDescription());
        project.setStatus(projectDTO.getStatus());

        Project savedProject = projectRepository.save(project);
        return mapToDTO(savedProject);
    }

    @Override
    public void addEmployeeToProject(Long projectId, AllocationDTO allocationDTO) {
        allocationService.addEmployeeToProject(projectId, allocationDTO);
    }

    @Override
    public void removeEmployeeFromProject(Long projectId, Long employeeId) {
        allocationService.removeEmployeeFromProject(projectId, employeeId);
    }

    @Override
    public void setProjectStatus(Long projectId, String status) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
        project.setStatus(status);
        projectRepository.save(project);
    }

    @Override
    public ProjectDTO getProjectDetails(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
        return mapToDTO(project);
    }

    private ProjectDTO mapToDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setProjectType(project.getProjectType());
        dto.setSourceClient(project.getSourceClient());
        dto.setEndClient(project.getEndClient());
        dto.setDescription(project.getDescription());
        dto.setStatus(project.getStatus());
        return dto;
    }
}