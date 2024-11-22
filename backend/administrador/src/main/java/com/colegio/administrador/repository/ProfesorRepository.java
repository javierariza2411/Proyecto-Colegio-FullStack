package com.colegio.administrador.repository;

import com.colegio.administrador.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor,Integer> {

}
