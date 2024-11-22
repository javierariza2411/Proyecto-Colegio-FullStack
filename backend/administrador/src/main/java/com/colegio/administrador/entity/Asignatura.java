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
@Table(name = "asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="curso_id", nullable = false)
    private Curso curso;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="profesor_id", nullable = false)
    private Profesor profesor;


    @ManyToMany(mappedBy = "asignaturas")
    private Set<Estudiante> estudiantes;




}