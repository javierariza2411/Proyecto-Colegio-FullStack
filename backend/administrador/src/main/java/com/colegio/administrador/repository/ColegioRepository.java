package com.colegio.administrador.repository;

import com.colegio.administrador.entity.Colegio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColegioRepository extends JpaRepository<Colegio,Integer> {
}
