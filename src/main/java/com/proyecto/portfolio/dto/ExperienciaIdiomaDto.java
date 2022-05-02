package com.proyecto.portfolio.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ExperienciaIdiomaDto {

    private Integer id;
    private String nombreIdioma;
    private String oral;
    private String escritura;
    private String lectura;

}
