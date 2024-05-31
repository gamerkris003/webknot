package com.webknot.service;

import com.webknot.dto.LeaveRequestDTO;
import com.webknot.entity.LeaveRequest;

public interface LeaveService {
    LeaveRequest applyForLeave(LeaveRequestDTO leaveRequestDTO);
}