package com.proyecto.portfolio.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UsuarioDto {

    private Integer id;
    private String nombreUsuario;
    private String email;
}
