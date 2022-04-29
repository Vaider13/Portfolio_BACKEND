
package com.proyecto.portfolio.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProyectoImagenDto {
    private Integer id;
    private String imagenUrl;
    private Integer proyectoId;
}
