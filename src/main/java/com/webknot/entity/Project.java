package com.webknot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RestController
@RequestMapping("/api/projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectType;
    private String sourceClient;
    private String endClient;
    private String description;

    @ManyToOne
    @JoinColumn(name = "account_manager_id")
    private Employee accountManager;

    @ManyToOne
    @JoinColumn(name = "project_manager_id")
    private Employee projectManager;

    private String status;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Allocation> allocations;

    public Project() {

    }

    // getters and setters
}