package com.colegio.administrador.controller;

import com.colegio.administrador.dto.*;
import com.colegio.administrador.service.AsignaturaService;
import com.colegio.administrador.service.ColegioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/asignatura")
public class AsignaturaController {



    private final AsignaturaService asignaturaService;





    @PostMapping("/{profesorId}/{cursoId}")
    public ResponseEntity<AsignaturaResponseDTO> crear(@PathVariable Integer profesorId,@PathVariable Integer cursoId, @RequestBody @Valid AsignaturaRequestDTO asignatura) {

        AsignaturaResponseDTO asignaturaCreada = asignaturaService.crear(profesorId,cursoId, asignatura);

        URI uri = UriComponentsBuilder.newInstance()
                .path("/api/profesor/{profesorId}/curso/{cursoId}/asignatura/{asignaturaId}").buildAndExpand(profesorId,cursoId, asignaturaCreada.getId()).toUri();

        return ResponseEntity.created(uri).body(asignaturaCreada);

    }



    @GetMapping()
    public ResponseEntity<List<AsignaturaResponseDTO>> buscarTodos() {

        return ResponseEntity.ok(asignaturaService.buscarTodos());

    }


    @GetMapping("/{colegioId}/curso")
    public ResponseEntity<List<AsignaturaResponseDTO>> buscarAsignaturasByProfesor(@PathVariable Integer profesorId) {

        return ResponseEntity.ok(asignaturaService.buscarAsignaturasByProfesor(profesorId));

    }



    @GetMapping("/{asignaturaId}/estudiantes")
    public ResponseEntity<List<EstudianteResponseDTO>> obtenerEstudiantesPorAsignatura(@PathVariable Integer asignaturaId) {

        return ResponseEntity.ok(asignaturaService.obtenerEstudiantesPorAsignatura(asignaturaId));

    }





}
