package com.webknot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class LeaveRequestDTO {
    private Long employeeId;
    private LocalDate leaveDate;

    // getters and setters
}