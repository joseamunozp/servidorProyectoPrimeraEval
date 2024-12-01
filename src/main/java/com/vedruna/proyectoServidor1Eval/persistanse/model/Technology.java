package com.vedruna.proyectoServidor1Eval.persistanse.model;

import com.fasterxml.jackson.annotation.JsonBackReference; // Añadido
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "technologies")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer techId;

    @Column(nullable = true, length = 45)
    private String techName;

    public Integer getTechId() {
        return techId; // Asegúrate de tener este getter
    }

    public String getTechName() {
        return techName;
    }

    // Relación bidireccional con Project, sin serializar la colección de proyectos
    @JsonIgnore
    @ManyToMany(mappedBy = "technologies")
    private List<Project> projects;
}
