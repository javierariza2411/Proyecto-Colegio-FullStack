package com.colegio.administrador.controller;

import com.colegio.administrador.dto.ColegioRequestDTO;
import com.colegio.administrador.dto.ColegioResponseDTO;
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
@RequestMapping("/api/colegio")
public class ColegioController {


    private final ColegioService colegioService;


    @PostMapping()
    public ResponseEntity<ColegioResponseDTO> crear(@RequestBody @Valid ColegioRequestDTO colegio) {

        ColegioResponseDTO colegioCreado = colegioService.crear(colegio);

        URI uri = UriComponentsBuilder.newInstance()
                .path("/api/colegio/{colegioId}").buildAndExpand(colegioCreado.getId()).toUri();
        return ResponseEntity.created(uri).body(colegioCreado);

    }


    @GetMapping("/{colegioId}")
    public ResponseEntity<ColegioResponseDTO> buscarColegio(@PathVariable Integer colegioId) {

        return ResponseEntity.ok(colegioService.buscarColegio(colegioId));

    }


    @GetMapping()
    public ResponseEntity<List<ColegioResponseDTO>> buscarTodos() {

        return ResponseEntity.ok(colegioService.buscarTodos());

    }



}
