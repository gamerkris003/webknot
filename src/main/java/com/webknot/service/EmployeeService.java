package com.webknot.service;

import com.webknot.dto.EmployeeDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO getEmployeeById(Long id);
    List<EmployeeDTO> getAllEmployees(int page, int size);
    List<EmployeeDTO> getBenchList();
    void importEmployees(MultipartFile file);
}