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
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;


    @OneToMany(mappedBy = "profesor",cascade= CascadeType.ALL)
    private Set<Asignatura> asignatura=new HashSet<>();


}