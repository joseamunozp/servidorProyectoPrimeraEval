package com.vedruna.proyectoServidor1Eval.persistanse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.proyectoServidor1Eval.persistanse.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
