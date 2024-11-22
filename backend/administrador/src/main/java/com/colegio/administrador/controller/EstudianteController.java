package com.colegio.administrador.controller;

import com.colegio.administrador.dto.EstudianteRequestDTO;
import com.colegio.administrador.dto.EstudianteResponseDTO;
import com.colegio.administrador.service.EstudianteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/estudiante")
public class EstudianteController {


    private final EstudianteService estudianteService;


    @PostMapping()
    public ResponseEntity<EstudianteResponseDTO> crear(@RequestBody @Valid EstudianteRequestDTO estudiante) {

        EstudianteResponseDTO estudianteCreado = estudianteService.crear(estudiante);

        URI uri = UriComponentsBuilder.newInstance()
                .path("/api/estudiante/{estudianteId}").buildAndExpand(estudianteCreado.getId()).toUri();
        return ResponseEntity.created(uri).body(estudianteCreado);

    }



    @PutMapping("/{estudianteId}/asignaturas")
    public ResponseEntity<EstudianteResponseDTO> asignarAsignaturasAEstudiante(@PathVariable Integer estudianteId, @RequestBody Set<Integer> asignaturasIds) {
        // Obtener el estudiante

        EstudianteResponseDTO estudianteCreado = estudianteService.asignarAsignaturasAEstudiante(estudianteId,asignaturasIds);


        URI uri = UriComponentsBuilder.newInstance()
                .path("/api/estudiante/{estudianteId}").buildAndExpand(estudianteCreado.getId()).toUri();
        return ResponseEntity.created(uri).body(estudianteCreado);

    }



}
