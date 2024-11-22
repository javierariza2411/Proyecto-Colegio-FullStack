package com.colegio.administrador.service;

import com.colegio.administrador.dto.ColegioRequestDTO;
import com.colegio.administrador.dto.ColegioResponseDTO;

import java.util.List;

public interface ColegioService {

    ColegioResponseDTO crear(ColegioRequestDTO colegio);

    List<ColegioResponseDTO> buscarTodos();

    ColegioResponseDTO buscarColegio(Integer colegioId);



}
