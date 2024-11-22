package com.colegio.administrador.repository;

import com.colegio.administrador.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante,Integer> {



}
