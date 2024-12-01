// src/main/java/com/example/developer/service/ProjectService.java
package com.vedruna.proyectoServidor1Eval.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedruna.proyectoServidor1Eval.dto.ProjectResponseDTO;
import com.vedruna.proyectoServidor1Eval.dto.ProjectResponseDTO.DeveloperResponseDTO;
import com.vedruna.proyectoServidor1Eval.dto.ProjectResponseDTO.StatusResponseDTO;
import com.vedruna.proyectoServidor1Eval.dto.ProjectResponseDTO.TechnologyResponseDTO;
import com.vedruna.proyectoServidor1Eval.persistanse.model.Project;
import com.vedruna.proyectoServidor1Eval.persistanse.repository.ProjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectResponseDTO mapProjectToDTO(Project project) {
        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO();

        // Asignar propiedades del proyecto
        projectResponseDTO.setProjectId(project.getProjectId());
        projectResponseDTO.setProjectName(project.getProjectName());
        projectResponseDTO.setDescription(project.getDescription());
        projectResponseDTO.setStartDate(project.getStartDate());
        projectResponseDTO.setEndDate(project.getEndDate());
        projectResponseDTO.setRepositoryUrl(project.getRepositoryUrl());
        projectResponseDTO.setDemoUrl(project.getDemoUrl());
        projectResponseDTO.setPicture(project.getPicture());

        // Mapear Status a DTO
        if (project.getStatus() != null) {
            StatusResponseDTO statusDTO = new StatusResponseDTO();
            statusDTO.setStatusId(project.getStatus().getStatusId());
            statusDTO.setStatusName(project.getStatus().getStatusName());
            projectResponseDTO.setStatus(statusDTO);
        }

        // Mapear tecnologías a DTO
        if (project.getTechnologies() != null) {
            List<TechnologyResponseDTO> techDTOList = project.getTechnologies().stream().map(tech -> {
                TechnologyResponseDTO techDTO = new TechnologyResponseDTO();
                techDTO.setTechId(tech.getTechId());
                techDTO.setTechName(tech.getTechName());
                return techDTO;
            }).collect(Collectors.toList());
            projectResponseDTO.setTechnologies(techDTOList);
        }

        // Mapear desarrolladores a DTO
        if (project.getDevelopers() != null) {
            List<DeveloperResponseDTO> devDTOList = project.getDevelopers().stream().map(dev -> {
                DeveloperResponseDTO devDTO = new DeveloperResponseDTO();
                devDTO.setDevId(dev.getDevId());
                devDTO.setDevName(dev.getDevName());
                devDTO.setDevSurname(dev.getDevSurname());
                return devDTO;
            }).collect(Collectors.toList());
            projectResponseDTO.setDevelopers(devDTOList);
        }

        return projectResponseDTO;
    }

    // Método para buscar proyectos por nombre
    public List<ProjectResponseDTO> findByProjectName(String word) {
        List<Project> projects = projectRepository.findByProjectNameContaining(word);
        return projects.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Método existente para obtener todos los proyectos
    public List<ProjectResponseDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Método para guardar un nuevo proyecto
    @Transactional
    public ProjectResponseDTO saveProject(Project project) {
        // Guardar el proyecto en la base de datos
        Project savedProject = projectRepository.save(project);

        // Forzar la carga de relaciones, si es necesario
        savedProject.getTechnologies().size(); // Carga tecnologías
        savedProject.getDevelopers().size(); // Carga desarrolladores

        // Convertir el proyecto a DTO y devolver la respuesta
        return convertToDTO(savedProject);
    }

    // Convertir de Project a ProjectResponseDTO

    // Método para actualizar el proyecto
    public ProjectResponseDTO updateProject(Integer id, Project updatedProject) {
        // Buscar el proyecto por ID
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));

        // Actualizar las propiedades del proyecto existente
        existingProject.setProjectName(updatedProject.getProjectName());
        existingProject.setDescription(updatedProject.getDescription());
        existingProject.setStartDate(updatedProject.getStartDate());
        existingProject.setEndDate(updatedProject.getEndDate());
        existingProject.setRepositoryUrl(updatedProject.getRepositoryUrl());
        existingProject.setDemoUrl(updatedProject.getDemoUrl());
        existingProject.setPicture(updatedProject.getPicture());

        // Actualizar tecnologías (si es necesario)
        if (updatedProject.getTechnologies() != null) {
            existingProject.setTechnologies(updatedProject.getTechnologies());
        }

        // Actualizar desarrolladores (si es necesario)
        if (updatedProject.getDevelopers() != null) {
            existingProject.setDevelopers(updatedProject.getDevelopers());
        }

        // Guardar el proyecto actualizado en la base de datos
        Project savedProject = projectRepository.save(existingProject);

        // Convertir a DTO y devolver la respuesta
        return convertToDTO(savedProject);
    }

    public void deleteProject(Integer id) {
        // Verificar si el proyecto existe antes de eliminarlo
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found with id: " + id);
        }
        projectRepository.deleteById(id);
    }

    private ProjectResponseDTO convertToDTO(Project project) {
        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO();
        projectResponseDTO.setProjectId(project.getProjectId());
        projectResponseDTO.setProjectName(project.getProjectName());
        projectResponseDTO.setDescription(project.getDescription());
        projectResponseDTO.setStartDate(project.getStartDate());
        projectResponseDTO.setEndDate(project.getEndDate());
        projectResponseDTO.setRepositoryUrl(project.getRepositoryUrl());
        projectResponseDTO.setDemoUrl(project.getDemoUrl());
        projectResponseDTO.setPicture(project.getPicture());

        // Mapear Status
        if (project.getStatus() != null) {
            ProjectResponseDTO.StatusResponseDTO statusDTO = new ProjectResponseDTO.StatusResponseDTO();
            statusDTO.setStatusId(project.getStatus().getStatusId());
            statusDTO.setStatusName(project.getStatus().getStatusName());
            projectResponseDTO.setStatus(statusDTO);
        }

        // Mapear tecnologías
        if (project.getTechnologies() != null) {
            List<ProjectResponseDTO.TechnologyResponseDTO> technologyDTOs = project.getTechnologies().stream()
                    .map(tech -> {
                        ProjectResponseDTO.TechnologyResponseDTO techDTO = new ProjectResponseDTO.TechnologyResponseDTO();
                        techDTO.setTechId(tech.getTechId());
                        techDTO.setTechName(tech.getTechName());
                        return techDTO;
                    }).collect(Collectors.toList());
            projectResponseDTO.setTechnologies(technologyDTOs);
        }

        // Mapear desarrolladores
        if (project.getDevelopers() != null) {
            List<ProjectResponseDTO.DeveloperResponseDTO> developerDTOs = project.getDevelopers().stream()
                    .map(dev -> {
                        ProjectResponseDTO.DeveloperResponseDTO devDTO = new ProjectResponseDTO.DeveloperResponseDTO();
                        devDTO.setDevId(dev.getDevId());
                        devDTO.setDevName(dev.getDevName());
                        devDTO.setDevSurname(dev.getDevSurname());
                        return devDTO;
                    }).collect(Collectors.toList());
            projectResponseDTO.setDevelopers(developerDTOs);
        }

        return projectResponseDTO;
    }

}
