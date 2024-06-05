package com.webknot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProjectDTO {
    private Long id;
    private String projectType;
    private String sourceClient;
    private String endClient;
    private String description;
    private Long accountManagerId;
    private Long projectManagerId;
    private String status;


    public ProjectDTO() {

    }

    // getters and setters
}