package com.vedruna.proyectoServidor1Eval.persistanse.model;

import com.fasterxml.jackson.annotation.JsonBackReference; // Añadido
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer devId;

    private String devName;

    private String devSurname;

    private String email;

    private String linkedinUrl;

    private String githubUrl;

    // Getters y Setters
    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDevSurname() {
        return devSurname;
    }

    public void setDevSurname(String devSurname) {
        this.devSurname = devSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "developers_worked_on_projects", joinColumns = @JoinColumn(name = "developers_dev_id"), inverseJoinColumns = @JoinColumn(name = "projects_project_id"))
    private List<Project> projects;

}
