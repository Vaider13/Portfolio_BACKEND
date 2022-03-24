package com.proyecto.portfolio.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class EducacionDto {

    private String nombreInstitucion;
    private String titulo;
    private String fechaInicio;
    private String fechaFinal;
    private String logoEducacion;
    private String estadoEducacion;
    private String gradoEducacion;
}
