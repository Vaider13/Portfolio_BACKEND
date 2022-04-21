package com.proyecto.portfolio.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ExperienciaLaboralDto {

    private Integer id;
    private String nombreEmpresa;
    private String puesto;
    private String fechaInicio;
    private String fechaFinal;
    private Boolean enCurso;
    private String descripcion;
    private String logoEmpresa;
}
