package com.webknot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequestMapping("/api/allocations")
public class Allocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String role;
    private int percentage;
    private String techStack;
    private int durationWeeks;

    public Allocation() {

    }

    // getters and setters
}