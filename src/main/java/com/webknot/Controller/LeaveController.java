package com.webknot.Controller;

import com.webknot.dto.LeaveRequestDTO;
import com.webknot.entity.LeaveRequest;
import com.webknot.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping
    public LeaveRequest applyForLeave(@RequestBody LeaveRequestDTO leaveRequestDTO) {
        return leaveService.applyForLeave(leaveRequestDTO);
    }
}