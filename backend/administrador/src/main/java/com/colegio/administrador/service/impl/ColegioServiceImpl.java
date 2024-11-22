package com.colegio.administrador.service.impl;

import com.colegio.administrador.dto.ColegioRequestDTO;
import com.colegio.administrador.dto.ColegioResponseDTO;
import com.colegio.administrador.entity.Colegio;
import com.colegio.administrador.exceptions.ResourceNotFoundException;
import com.colegio.administrador.repository.ColegioRepository;
import com.colegio.administrador.service.ColegioService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColegioServiceImpl implements ColegioService {

    private final ColegioRepository colegioRepository;


    @Transactional
    @Override
    public ColegioResponseDTO crear(ColegioRequestDTO colegio) {

        Colegio colegioGuardado=null;

        Colegio colegioG= Colegio.builder()
                .nombre(colegio.getNombre()).build();

        try {
            colegioGuardado=colegioRepository.save(colegioG);
        } catch (DataIntegrityViolationException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de colegio ya existe");
        }

        return ColegioResponseDTO.builder().nombre(colegioGuardado.getNombre())
                .id(colegioGuardado.getId()).build();
    }



    @Transactional(readOnly=true)
    @Override
    public List<ColegioResponseDTO> buscarTodos() {

        List<Colegio> colegios = colegioRepository.findAll();

        return colegios.stream().map(colegio -> ColegioResponseDTO.builder().nombre(colegio.getNombre())
                .id(colegio.getId()).build()).toList();

    }

    @Transactional(readOnly=true)
    @Override
    public ColegioResponseDTO buscarColegio(Integer colegioId) {

        Colegio colegio = colegioRepository.findById(colegioId).orElseThrow(
                () -> new ResourceNotFoundException("Colegio", "id", colegioId.toString())
        );

        return ColegioResponseDTO.builder().nombre(colegio.getNombre())
                .id(colegio.getId()).build();
    }


}
