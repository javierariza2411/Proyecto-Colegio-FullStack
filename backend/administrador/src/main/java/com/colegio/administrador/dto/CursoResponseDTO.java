package com.colegio.administrador.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CursoResponseDTO {

    private Integer id;

    private Integer grado;

    private String salon;
}
