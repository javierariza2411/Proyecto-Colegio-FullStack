package com.colegio.administrador.service;

import com.colegio.administrador.dto.CursoRequestDTO;
import com.colegio.administrador.dto.CursoResponseDTO;

import java.util.List;

public interface CursoService {

    CursoResponseDTO crear(Integer colegioId, CursoRequestDTO curso);

    List<CursoResponseDTO> buscarCursos(Integer colegioId);



}
