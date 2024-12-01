package com.vedruna.proyectoServidor1Eval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.vedruna.proyectoServidor1Eval.persistanse.model.Technology;
import com.vedruna.proyectoServidor1Eval.service.TechnologyService;

@RestController
@RequestMapping("/api/v1/technologies")
public class TechnologyController {
    @Autowired
    private TechnologyService technologyService;

    @PostMapping
    public ResponseEntity<Technology> createTechnology(@RequestBody Technology technology) {
        Technology savedTechnology = technologyService.saveTechnology(technology);
        return new ResponseEntity<>(savedTechnology, HttpStatus.CREATED);
    }

    @DeleteMapping("/{techId}")
    public ResponseEntity<String> deleteTechnology(@PathVariable Integer techId) {
        technologyService.deleteTechnology(techId);
        return ResponseEntity.ok("Technology deleted successfully");
    }
}
