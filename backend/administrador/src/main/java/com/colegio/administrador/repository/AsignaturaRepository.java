package com.colegio.administrador.repository;

import com.colegio.administrador.entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignaturaRepository extends JpaRepository<Asignatura,Integer> {

    List<Asignatura> findAsignaturaByProfesor_Id(Integer id);

}
