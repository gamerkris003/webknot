package com.webknot.Controller;

import com.webknot.dto.AllocationDTO;
import com.webknot.dto.ProjectDTO;
import com.webknot.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ProjectDTO createProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.createProject(projectDTO);
    }

    @PostMapping("/{projectId}/allocations")
    public void addEmployeeToProject(@PathVariable Long projectId, @RequestBody AllocationDTO allocationDTO) {
        projectService.addEmployeeToProject(projectId, allocationDTO);
    }

    @DeleteMapping("/{projectId}/allocations/{employeeId}")
    public void removeEmployeeFromProject(@PathVariable Long projectId, @PathVariable Long employeeId) {
        projectService.removeEmployeeFromProject(projectId, employeeId);
    }

    @PatchMapping("/{projectId}/status")
    public void setProjectStatus(@PathVariable Long projectId, @RequestParam String status) {
        projectService.setProjectStatus(projectId, status);
    }

    @GetMapping("/{projectId}")
    public ProjectDTO getProjectDetails(@PathVariable Long projectId) {
        return projectService.getProjectDetails(projectId);
    }
}