package com.proyecto.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PersonaDto {

    private Integer id;
    private String nombre;
    private String apellido;
    private String fecha_nacimiento;
    private String telefono;
    private String titulo;
    private String acerca_de;
    private Integer localidad_id;
    private Integer usuario_id;
}
