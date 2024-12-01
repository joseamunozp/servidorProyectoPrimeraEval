package com.vedruna.proyectoServidor1Eval.persistanse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.proyectoServidor1Eval.persistanse.model.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
}
