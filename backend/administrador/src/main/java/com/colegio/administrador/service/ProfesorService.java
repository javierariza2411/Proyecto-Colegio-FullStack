package com.colegio.administrador.service;

import com.colegio.administrador.dto.*;

import java.util.List;

public interface ProfesorService {

    ProfesorResponseDTO crear(ProfesorRequestDTO profesor);

    List<ProfesorResponseDTO> buscarTodos();

    List<AsignaturaResponseDTO> buscarAsignaturasPorProfesor(Integer idProfesor);


}
