package com.webknot.repository;

import com.webknot.entity.Allocation;
import com.webknot.entity.Employee;
import com.webknot.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {
    Allocation findByProjectAndEmployee(Project project, Employee employee);
}