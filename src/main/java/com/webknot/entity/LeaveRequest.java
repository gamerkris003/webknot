package com.webknot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequestMapping("/api/leaverequest")
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDate leaveDate;

    public LeaveRequest() {

    }

    // getters and setters
}