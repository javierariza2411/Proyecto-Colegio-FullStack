package com.colegio.administrador.service.impl;

import com.colegio.administrador.dto.CursoRequestDTO;
import com.colegio.administrador.dto.CursoResponseDTO;
import com.colegio.administrador.entity.Colegio;
import com.colegio.administrador.entity.Curso;
import com.colegio.administrador.exceptions.ResourceNotFoundException;
import com.colegio.administrador.repository.ColegioRepository;
import com.colegio.administrador.repository.CursoRepository;
import com.colegio.administrador.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {


    private final CursoRepository cursoRepository;

    private final ColegioRepository colegioRepository;



    @Transactional
    @Override
    public CursoResponseDTO crear(Integer colegioId, CursoRequestDTO curso) {

        Colegio colegio = getColegio(colegioId);

        Curso cursoG= Curso.builder().grado(curso.getGrado())
                .salon(curso.getSalon()).colegio(colegio).build();

        Curso cursoGuardado = cursoRepository.save(cursoG);

        return CursoResponseDTO.builder().
                id(cursoGuardado.getId())
                .grado(cursoGuardado.getGrado())
                .salon(cursoGuardado.getSalon())
                .build();

    }




    @Transactional(readOnly=true)
    @Override
    public List<CursoResponseDTO> buscarCursos(Integer colegioId) {


        Colegio colegio = getColegio(colegioId);

        List<Curso> cursos = cursoRepository.findCursoByColegio_Id(colegioId);


        return cursos.stream().map(curso -> CursoResponseDTO.builder().grado(curso.getGrado())
                .id(curso.getId())
                .salon(curso.getSalon())
                .build()).toList();


    }



    private Colegio getColegio(Integer colegioId) {
        Colegio colegio = colegioRepository.findById(colegioId).orElseThrow(
                () -> new ResourceNotFoundException("Colegio", "id", colegioId.toString())
        );
        return colegio;
    }




}
