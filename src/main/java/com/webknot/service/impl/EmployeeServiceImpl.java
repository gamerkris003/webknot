package com.webknot.service.impl;
import com.webknot.entity.Allocation;
import com.webknot.dto.EmployeeDTO;
import com.webknot.entity.Employee;
import com.webknot.repository.EmployeeRepository;
import com.webknot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return mapToDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees(int page, int size) {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for (Employee employee : employees) {
            employeeDTOs.add(mapToDTO(employee));
        }
        return employeeDTOs;
    }

    @Override
    public List<EmployeeDTO> getBenchList() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> benchList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAllocations().stream().mapToInt(Allocation::getPercentage).sum() < 90) {
                benchList.add(mapToDTO(employee));
            }
        }
        return benchList;
    }

    @Override
    public void importEmployees(MultipartFile file) {
        // Implement logic to parse and import employees from the CSV file
    }

    private EmployeeDTO mapToDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setTechStack(employee.getTechStack());
        dto.setYearsOfExperience(employee.getYearsOfExperience());
        dto.setYearsInWebknot(employee.getYearsInWebknot());
        return dto;
    }
}