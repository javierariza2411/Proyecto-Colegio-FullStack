package com.colegio.administrador.repository;

import com.colegio.administrador.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso,Integer> {


    List<Curso> findCursoByColegio_Id(Integer id);




}
