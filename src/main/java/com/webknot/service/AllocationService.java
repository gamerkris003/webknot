package com.webknot.service;

import com.webknot.dto.AllocationDTO;

public interface AllocationService {
    void addEmployeeToProject(Long projectId, AllocationDTO allocationDTO);
    void removeEmployeeFromProject(Long projectId, Long employeeId);
}