package com.webknot.service.impl;

import com.webknot.dto.LeaveRequestDTO;
import com.webknot.entity.Employee;
import com.webknot.entity.LeaveRequest;
import com.webknot.repository.EmployeeRepository;
import com.webknot.repository.LeaveRepository;
import com.webknot.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public LeaveRequest applyForLeave(LeaveRequestDTO leaveRequestDTO) {
        Employee employee = employeeRepository.findById(leaveRequestDTO.getEmployeeId()).orElseThrow(() -> new RuntimeException("Employee not found"));

        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setEmployee(employee);
        leaveRequest.setLeaveDate(leaveRequestDTO.getLeaveDate());

        return leaveRepository.save(leaveRequest);
    }
}