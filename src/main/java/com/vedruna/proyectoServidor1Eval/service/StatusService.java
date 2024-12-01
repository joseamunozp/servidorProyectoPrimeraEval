package com.vedruna.proyectoServidor1Eval.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.proyectoServidor1Eval.persistanse.model.Status;
import com.vedruna.proyectoServidor1Eval.persistanse.repository.StatusRepository;

import java.util.List;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }
}