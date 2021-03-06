package com.proyecto.portfolio.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PersonaDto {

    private Integer id;
    private String nombre;
    private String apellido;
    private String fecha_nacimiento;
    private String telefono;
    private String titulo;
    private String acerca_de;
    private String email;
    private String urlAvatar;
    private String urlBanner;
    private String localidad;
    private String provincia;
    private Integer provinciaId;
}
