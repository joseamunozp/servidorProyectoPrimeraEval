// src/main/java/com/example/developer/repository/ProjectRepository.java
package com.vedruna.proyectoServidor1Eval.persistanse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.proyectoServidor1Eval.persistanse.model.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    // Este método buscará los proyectos que contengan la palabra en el nombre del
    // proyecto
    List<Project> findByProjectNameContaining(String word);

}
