
package com.proyecto.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EstadoEducacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    @NotNull
    private String estado;
    @JsonIgnore
    //Relacion uno a muchos entre la clase "Estado Educacion" y "Educacion".
    @OneToMany(mappedBy = "estadoEducacion")
    private List<Educacion> educaciones;
}
