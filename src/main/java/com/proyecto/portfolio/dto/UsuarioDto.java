package com.proyecto.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

    private Integer id;
    private String nombreUsuario;
    private String email;
    private String password;
}
