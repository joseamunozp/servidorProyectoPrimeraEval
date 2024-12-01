package com.vedruna.proyectoServidor1Eval.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.proyectoServidor1Eval.persistanse.model.Developer;
import com.vedruna.proyectoServidor1Eval.persistanse.repository.DeveloperRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class DeveloperService {
    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private EntityManager entityManager;

    public Developer saveDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    @Transactional
    public void deleteDeveloper(Integer id) {
        // Verificar si el desarrollador existe
        if (!developerRepository.existsById(id)) {
            throw new RuntimeException("Developer not found with ID: " + id);
        }

        // Eliminar relaciones del desarrollador en la tabla intermedia
        entityManager.createQuery("DELETE FROM DeveloperWorkedOnProjects dwp WHERE dwp.developer.id = :developerId")
                .setParameter("developerId", id)
                .executeUpdate();

        // Ahora eliminar el desarrollador
        developerRepository.deleteById(id);
    }
}