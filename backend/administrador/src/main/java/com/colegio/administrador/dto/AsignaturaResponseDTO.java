package com.colegio.administrador.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AsignaturaResponseDTO {

    private Integer id;
    private String nombre;


}
