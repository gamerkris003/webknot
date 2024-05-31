package com.webknot.service.impl;

import com.webknot.dto.AllocationDTO;
import com.webknot.entity.Allocation;
import com.webknot.entity.Employee;
import com.webknot.entity.Project;
import com.webknot.repository.AllocationRepository;
import com.webknot.repository.EmployeeRepository;
import com.webknot.repository.ProjectRepository;
import com.webknot.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocationServiceImpl implements AllocationService {

    @Autowired
    private AllocationRepository allocationRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void addEmployeeToProject(Long projectId, AllocationDTO allocationDTO) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
        Employee employee = employeeRepository.findById(allocationDTO.getEmployeeId()).orElseThrow(() -> new RuntimeException("Employee not found"));

        Allocation allocation = new Allocation();
        allocation.setProject(project);
        allocation.setEmployee(employee);
        allocation.setRole(allocationDTO.getRole());
        allocation.setPercentage(allocationDTO.getPercentage());
        allocation.setTechStack(allocationDTO.getTechStack());
        allocation.setDurationWeeks(allocationDTO.getDurationWeeks());

        allocationRepository.save(allocation);
    }

    @Override
    public void removeEmployeeFromProject(Long projectId, Long employeeId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));

        Allocation allocation = allocationRepository.findByProjectAndEmployee(project, employee);
        if (allocation != null) {
            allocationRepository.delete(allocation);
        }
    }
}