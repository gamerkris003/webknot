package com.webknot.service;

import com.webknot.dto.AllocationDTO;
import com.webknot.dto.ProjectDTO;

public interface ProjectService {
    ProjectDTO createProject(ProjectDTO projectDTO);
    void addEmployeeToProject(Long projectId, AllocationDTO allocationDTO);
    void removeEmployeeFromProject(Long projectId, Long employeeId);
    void setProjectStatus(Long projectId, String status);
    ProjectDTO getProjectDetails(Long projectId);

    String deleteProject(Long projectId);
}