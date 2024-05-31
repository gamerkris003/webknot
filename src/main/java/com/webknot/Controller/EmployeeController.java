package com.webknot.Controller;

import com.webknot.dto.EmployeeDTO;
import com.webknot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size) {
        return employeeService.getAllEmployees(page, size);
    }

    @GetMapping("/bench")
    public List<EmployeeDTO> getBenchList() {
        return employeeService.getBenchList();
    }

    @PostMapping("/import")
    public void importEmployees(@RequestParam("file") MultipartFile file) {
        employeeService.importEmployees(file);
    }
}