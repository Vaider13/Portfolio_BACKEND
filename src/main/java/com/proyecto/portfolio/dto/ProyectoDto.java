
package com.proyecto.portfolio.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProyectoDto {
    
    private Integer id;
    private String nombre;
    private String fecha;
    private String descripcion;
    private String urlProyecto;
}

