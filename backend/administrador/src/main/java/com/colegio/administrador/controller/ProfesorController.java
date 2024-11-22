package com.colegio.administrador.controller;

import com.colegio.administrador.dto.*;
import com.colegio.administrador.service.ColegioService;
import com.colegio.administrador.service.ProfesorService;
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
@RequestMapping("/api/profesor")
public class ProfesorController {



    private final ProfesorService profesorService;


    @PostMapping()
    public ResponseEntity<ProfesorResponseDTO> crear(@RequestBody @Valid ProfesorRequestDTO profesor) {

        ProfesorResponseDTO profesorCreado = profesorService.crear(profesor);

        URI uri = UriComponentsBuilder.newInstance()
                .path("/api/profesor/{profsorId}").buildAndExpand(profesorCreado.getId()).toUri();
        return ResponseEntity.created(uri).body(profesorCreado);

    }


    @GetMapping()
    public ResponseEntity<List<ProfesorResponseDTO>> buscarTodos() {

        return ResponseEntity.ok(profesorService.buscarTodos());

    }


    @GetMapping("/{idProfesor}/asignaturas")
    public ResponseEntity<List<AsignaturaResponseDTO>>  buscarAsignaturasPorProfesor(@PathVariable Integer idProfesor) {
        return  ResponseEntity.ok(profesorService.buscarAsignaturasPorProfesor(idProfesor));

    }




}
