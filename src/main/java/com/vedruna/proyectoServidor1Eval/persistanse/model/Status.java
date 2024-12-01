package com.vedruna.proyectoServidor1Eval.persistanse.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statusId; // Asegúrate de que esta propiedad existe

    private String statusName;

    public Integer getStatusId() {
        return statusId; // Asegúrate de tener este getter
    }

    public String getStatusName() {
        return statusName;
    }

}
