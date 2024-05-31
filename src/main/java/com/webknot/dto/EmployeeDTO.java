package com.webknot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String techStack;
    private int yearsOfExperience;
    private int yearsInWebknot;

    public EmployeeDTO() {

    }

    // getters and setters
}