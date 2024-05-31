package com.webknot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AllocationDTO {
    private Long employeeId;
    private String role;
    private int percentage;
    private String techStack;
    private int durationWeeks;

    // getters and setters
}