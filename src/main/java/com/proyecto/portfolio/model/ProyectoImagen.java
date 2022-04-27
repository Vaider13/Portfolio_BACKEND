
package com.proyecto.portfolio.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProyectoImagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //Relacion muchos a uno entre la clase "Proyecto Imagen" y "Proyecto"
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "proyecto_id", referencedColumnName = "id")
    private Proyecto proyecto;
    @NotNull
    private String imagenUrl;

    public ProyectoImagen() {
    }

    public ProyectoImagen(Integer id, Proyecto proyecto, String imagenUrl) {
        this.id = id;
        this.proyecto = proyecto;
        this.imagenUrl = imagenUrl;
    }
    
}
