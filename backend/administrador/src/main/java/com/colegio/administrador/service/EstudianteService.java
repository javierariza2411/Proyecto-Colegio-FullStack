package com.colegio.administrador.service;

import com.colegio.administrador.dto.EstudianteRequestDTO;
import com.colegio.administrador.dto.EstudianteResponseDTO;

import java.util.List;
import java.util.Set;

public interface EstudianteService {


    EstudianteResponseDTO crear(EstudianteRequestDTO estudiante);

    List<EstudianteResponseDTO> buscarEstudiantesByAsignatura(Integer asignaturaId);


    EstudianteResponseDTO asignarAsignaturasAEstudiante(Integer estudianteId, Set<Integer> asignaturasIds);


}
