package com.colegio.administrador.service.impl;

import com.colegio.administrador.dto.AsignaturaResponseDTO;
import com.colegio.administrador.dto.ProfesorRequestDTO;
import com.colegio.administrador.dto.ProfesorResponseDTO;
import com.colegio.administrador.entity.Asignatura;
import com.colegio.administrador.entity.Profesor;
import com.colegio.administrador.exceptions.ResourceNotFoundException;
import com.colegio.administrador.repository.ProfesorRepository;
import com.colegio.administrador.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {


    private final ProfesorRepository profesorRepository;


    @Transactional
    @Override
    public ProfesorResponseDTO crear(ProfesorRequestDTO profesor) {

        Profesor profesorGuardado=null;

        Profesor profesorG= Profesor.builder()
                .nombre(profesor.getNombre()).build();


            profesorGuardado=profesorRepository.save(profesorG);


        return ProfesorResponseDTO.builder().nombre(profesorGuardado.getNombre())
                .id(profesorGuardado.getId()).build();
    }



    @Transactional(readOnly=true)
    @Override
    public List<ProfesorResponseDTO> buscarTodos() {

        List<Profesor> profesores = profesorRepository.findAll();

        return profesores.stream().map(profesor -> ProfesorResponseDTO.builder().nombre(profesor.getNombre())
                .id(profesor.getId()).build()).toList();

    }



    @Transactional
    @Override
    public List<AsignaturaResponseDTO> buscarAsignaturasPorProfesor(Integer profesorId) {


        Profesor profesor = profesorRepository.findById(profesorId).orElseThrow(
                    () -> new ResourceNotFoundException("Profesor", "id", profesorId.toString()));

        List<Asignatura> asignaturas=new ArrayList<Asignatura>();

        if (profesor != null) {

             asignaturas.addAll(profesor.getAsignatura());

        }

        return asignaturas.stream().map(asignatura -> AsignaturaResponseDTO.builder().nombre(asignatura.getNombre())
                .id(asignatura.getId()).build()).toList();

    }






}
