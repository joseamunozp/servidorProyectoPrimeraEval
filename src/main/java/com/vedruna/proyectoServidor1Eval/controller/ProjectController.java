// src/main/java/com/example/developer/controller/ProjectController.java
package com.vedruna.proyectoServidor1Eval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vedruna.proyectoServidor1Eval.dto.ProjectResponseDTO;
import com.vedruna.proyectoServidor1Eval.persistanse.model.Project;
import com.vedruna.proyectoServidor1Eval.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/{word}")
    public ResponseEntity<List<ProjectResponseDTO>> getProjectsByWord(@PathVariable String word) {
        return ResponseEntity.ok(projectService.findByProjectName(word));
    }

    @PostMapping
    public ResponseEntity<String> createProject(@RequestBody Project project) {
        // Guardar el proyecto y obtener la respuesta en DTO
        ProjectResponseDTO createdProject = projectService.saveProject(project);

        // Crear mensaje personalizado con éxito
        String message = "Proyecto creado correctamente con ID: " + createdProject.getProjectId();

        // Devolver respuesta con el mensaje y el código HTTP 201 (Created)
        return ResponseEntity.status(201).body(message);
        // return ResponseEntity.status(201).body(createdProject); Por si se quiere ver
        // todos los campos agregados

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> updateProject(@PathVariable Integer id, @RequestBody Project project) {
        ProjectResponseDTO updatedProject = projectService.updateProject(id, project);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Integer id) {
        try {
            projectService.deleteProject(id);
            return ResponseEntity.ok("Proyecto eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proyecto no encontrado");
        }
    }

}
