package com.colegio.administrador.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Integer grado;

    private String salon;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="colegio_id", nullable = false)
    private Colegio colegio;


    @OneToMany(mappedBy = "curso",cascade= CascadeType.ALL)
    private Set<Asignatura> asignatura=new HashSet<>();




}