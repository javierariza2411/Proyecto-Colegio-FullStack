package com.colegio.administrador.controller;

import com.colegio.administrador.dto.ColegioResponseDTO;
import com.colegio.administrador.dto.CursoRequestDTO;
import com.colegio.administrador.dto.CursoResponseDTO;
import com.colegio.administrador.service.CursoService;
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
@RequestMapping("/api/colegio")
public class CursoController {


    private final CursoService cursoService;

    @PostMapping("/{colegioId}/curso")
    public ResponseEntity<CursoResponseDTO> crear(@PathVariable Integer colegioId, @RequestBody @Valid CursoRequestDTO curso) {

        CursoResponseDTO cursoCreado = cursoService.crear(colegioId, curso);

        URI uri = UriComponentsBuilder.newInstance()
                .path("/api/colegio/{colegioId}/curso/{cursoId}").buildAndExpand(colegioId, cursoCreado.getId()).toUri();

        return ResponseEntity.created(uri).body(cursoCreado);

    }


    @GetMapping("/{colegioId}/curso")
    public ResponseEntity<List<CursoResponseDTO>> listarTodas(@PathVariable Integer colegioId) {

        return ResponseEntity.ok(cursoService.buscarCursos(colegioId));

    }



}
