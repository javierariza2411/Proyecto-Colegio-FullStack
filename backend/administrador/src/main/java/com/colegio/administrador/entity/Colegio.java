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
@Table(name = "colegio")
public class Colegio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;


    @OneToMany(mappedBy = "colegio",cascade= CascadeType.ALL)
    private Set<Curso> curso=new HashSet<>();


}