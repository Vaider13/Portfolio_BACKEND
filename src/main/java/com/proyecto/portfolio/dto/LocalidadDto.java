
package com.proyecto.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalidadDto {
    private Integer id;
    private String localidad;
    private ProvinciaDto provinciaDto;
    
    
    
    
}
