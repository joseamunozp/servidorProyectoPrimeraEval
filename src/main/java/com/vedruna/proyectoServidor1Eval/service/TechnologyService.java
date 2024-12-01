package com.vedruna.proyectoServidor1Eval.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.proyectoServidor1Eval.persistanse.model.Project;
import com.vedruna.proyectoServidor1Eval.persistanse.model.Technology;
import com.vedruna.proyectoServidor1Eval.persistanse.repository.ProjectRepository;
import com.vedruna.proyectoServidor1Eval.persistanse.repository.TechnologyRepository;
import jakarta.transaction.Transactional;

import jakarta.persistence.EntityManager;

@Service
public class TechnologyService {
    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ProjectRepository projectRepository;

    public Technology saveTechnology(Technology technology) {
        return technologyRepository.save(technology);
    }

    @Transactional
    public void deleteTechnology(Integer techId) {
        // Verificar si la tecnología existe
        Technology technology = technologyRepository.findById(techId)
                .orElseThrow(() -> new RuntimeException("Technology not found with ID: " + techId));

        // Desvincular la tecnología de los proyectos
        List<Project> projects = technology.getProjects();
        for (Project project : projects) {
            project.getTechnologies().remove(technology);
        }

        // Ahora eliminar la tecnología
        technologyRepository.delete(technology);
    }
}