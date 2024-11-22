package com.colegio.administrador.service.impl;

import com.colegio.administrador.dto.EstudianteRequestDTO;
import com.colegio.administrador.dto.EstudianteResponseDTO;
import com.colegio.administrador.entity.Asignatura;
import com.colegio.administrador.entity.Estudiante;
import com.colegio.administrador.repository.AsignaturaRepository;
import com.colegio.administrador.repository.EstudianteRepository;
import com.colegio.administrador.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {



    private final AsignaturaRepository asignaturaRepository;


    private final EstudianteRepository estudianteRepository;


    @Transactional
    @Override
    public EstudianteResponseDTO crear(EstudianteRequestDTO estudiante) {


        Estudiante estudianteG= Estudiante.builder().nombre(estudiante.getNombre())
                .build();

        Estudiante estudianteGuardado = estudianteRepository.save(estudianteG);

        return EstudianteResponseDTO.builder()
                .id(estudianteGuardado.getId())
                .nombre(estudianteGuardado.getNombre())
                .build();

    }




    @Transactional(readOnly=true)
    @Override
    public List<EstudianteResponseDTO> buscarEstudiantesByAsignatura(Integer asignaturaId) {


        List<Estudiante> estudiantes = null;


        return estudiantes.stream().map(estudiante -> EstudianteResponseDTO.builder().nombre(estudiante.getNombre())
                .id(estudiante.getId())
                .build()).toList();


    }


    @Transactional
    @Override
    public EstudianteResponseDTO asignarAsignaturasAEstudiante(Integer estudianteId, Set<Integer> asignaturasIds) {

        Estudiante estudiante = estudianteRepository.findById(estudianteId).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));


        Set<Asignatura> asignaturas = new HashSet<>();
        for (Integer asignaturaId : asignaturasIds) {
            Asignatura asignatura = asignaturaRepository.findById(asignaturaId).orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));
            asignaturas.add(asignatura);
        }

        estudiante.setAsignaturas(asignaturas);

        Estudiante estudianteGuardado  =estudianteRepository.save(estudiante);


        return EstudianteResponseDTO.builder()
                .id(estudianteGuardado.getId())
                .nombre(estudianteGuardado.getNombre())
                .build();


    }







}
