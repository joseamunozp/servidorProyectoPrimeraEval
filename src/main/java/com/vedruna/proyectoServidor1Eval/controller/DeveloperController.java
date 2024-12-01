package com.vedruna.proyectoServidor1Eval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vedruna.proyectoServidor1Eval.persistanse.model.Developer;
import com.vedruna.proyectoServidor1Eval.service.DeveloperService;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @PostMapping
    public ResponseEntity<String> createDeveloper(@RequestBody Developer developer) {
        // Llamar al servicio para guardar el desarrollador
        Developer savedDeveloper = developerService.saveDeveloper(developer);

        // Devolver una respuesta con un mensaje y código 201 (Created)
        String message = "Developer creado correctamente con ID: " + savedDeveloper.getDevId();
        return ResponseEntity.status(201).body(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeveloper(@PathVariable Integer id) {
        developerService.deleteDeveloper(id);
        String message = "Developer eliminado correctamente con ID: " + id;
        return ResponseEntity.ok(message);
    }
}
