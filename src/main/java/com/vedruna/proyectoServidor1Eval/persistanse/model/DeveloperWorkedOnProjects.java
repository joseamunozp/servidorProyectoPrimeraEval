package com.vedruna.proyectoServidor1Eval.persistanse.model;

import jakarta.persistence.*;

@Entity
@Table(name = "developers_worked_on_projects")
public class DeveloperWorkedOnProjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // O el campo correspondiente para la clave primaria

    @ManyToOne
    @JoinColumn(name = "developers_dev_id")
    private Developer developer;

    @ManyToOne
    @JoinColumn(name = "projects_project_id")
    private Project project;

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
