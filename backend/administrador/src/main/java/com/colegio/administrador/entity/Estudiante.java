package com.colegio.administrador.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "estudiante")
public class Estudiante {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;


    @ManyToMany
    @JoinTable(
            name = "estudiante_asignatura",  // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "estudiante_id"),  // Columna que representa al estudiante
            inverseJoinColumns = @JoinColumn(name = "asignatura_id")  // Columna que representa a la asignatura
    )
    private Set<Asignatura> asignaturas;
}