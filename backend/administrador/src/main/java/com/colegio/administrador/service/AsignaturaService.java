package com.colegio.administrador.service;

import com.colegio.administrador.dto.AsignaturaRequestDTO;
import com.colegio.administrador.dto.AsignaturaResponseDTO;
import com.colegio.administrador.dto.EstudianteResponseDTO;
import com.colegio.administrador.entity.Estudiante;

import java.util.List;

public interface AsignaturaService {

    AsignaturaResponseDTO crear(Integer profesorId,Integer cursoId, AsignaturaRequestDTO asignatura);

    List<AsignaturaResponseDTO> buscarTodos();

    List<AsignaturaResponseDTO> buscarAsignaturasByProfesor(Integer profesorId);

    List<EstudianteResponseDTO> obtenerEstudiantesPorAsignatura(Integer asignaturaId);




}
