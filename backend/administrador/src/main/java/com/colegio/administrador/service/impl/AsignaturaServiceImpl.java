package com.colegio.administrador.service.impl;

import com.colegio.administrador.dto.AsignaturaRequestDTO;
import com.colegio.administrador.dto.AsignaturaResponseDTO;
import com.colegio.administrador.dto.ColegioResponseDTO;
import com.colegio.administrador.dto.EstudianteResponseDTO;
import com.colegio.administrador.entity.*;
import com.colegio.administrador.exceptions.ResourceNotFoundException;
import com.colegio.administrador.repository.AsignaturaRepository;
import com.colegio.administrador.repository.CursoRepository;
import com.colegio.administrador.repository.ProfesorRepository;
import com.colegio.administrador.service.AsignaturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignaturaServiceImpl implements AsignaturaService {



    private final AsignaturaRepository asignaturaRepository;

    private final ProfesorRepository profesorRepository;

    private final CursoRepository cursoRepository;



    @Transactional
    @Override
    public AsignaturaResponseDTO crear(Integer profesorId,Integer cursoId,  AsignaturaRequestDTO asignatura) {

        Curso curso = getCurso(cursoId);
        Profesor profesor = getProfesor(profesorId);

        Asignatura asignaturaG= Asignatura.builder().nombre(asignatura.getNombre())
                .profesor(profesor)
                .curso(curso).build();

        Asignatura asignaturaGuardada = asignaturaRepository.save(asignaturaG);

        return AsignaturaResponseDTO.builder()
                .id(asignaturaGuardada.getId())
                .nombre(asignaturaGuardada.getNombre())
                .build();

    }



    @Transactional(readOnly=true)
    @Override
    public List<AsignaturaResponseDTO> buscarTodos() {

        List<Asignatura> asignaturas = asignaturaRepository.findAll();

        return asignaturas.stream().map(asignatura -> AsignaturaResponseDTO.builder().nombre(asignatura.getNombre())
                .id(asignatura.getId()).build()).toList();

    }



    public List<AsignaturaResponseDTO> buscarAsignaturasByProfesor(Integer profesorId) {


        Profesor profesor = getProfesor(profesorId);

        List<Asignatura> asignaturas = asignaturaRepository.findAsignaturaByProfesor_Id(profesorId);


        return asignaturas.stream().map(asignatura -> AsignaturaResponseDTO.builder().nombre(asignatura.getNombre())
                .id(asignatura.getId())
                .build()).toList();


    }




    @Transactional(readOnly=true)
    @Override
    public List<EstudianteResponseDTO> obtenerEstudiantesPorAsignatura(Integer asignaturaId) {
        Asignatura asignatura = asignaturaRepository.findById(asignaturaId).orElse(null);

        List<Estudiante> estudiantes= new ArrayList<Estudiante>();


        if (asignatura != null) {
            estudiantes.addAll(asignatura.getEstudiantes());

        }


        return estudiantes.stream().map(estudiante -> EstudianteResponseDTO.builder().nombre(estudiante.getNombre())
                .id(estudiante.getId())
                .build()).toList();


    }


    private Profesor getProfesor(Integer profesorId) {
        Profesor profesor = profesorRepository.findById(profesorId).orElseThrow(
                () -> new ResourceNotFoundException("Profesor", "id", profesorId.toString())
        );
        return profesor;
    }


    private Curso getCurso(Integer cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(
                () -> new ResourceNotFoundException("Curso", "id", cursoId.toString())
        );
        return curso;
    }







}
