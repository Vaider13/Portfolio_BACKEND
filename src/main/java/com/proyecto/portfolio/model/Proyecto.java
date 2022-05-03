
package com.proyecto.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nombre;
    @NotNull
    private String fecha;
    @NotNull
    private String descripcion; 
    @NotNull
    private String urlProyecto;
    private String urlProyectoGitHub;
    //Relacion muchos a uno entre la clase "Proyecto" y "Persona"
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona persona;
    //Relacion uno a muchos entre la clase "Proyecto" y "Proyecto Imagen".
    @JsonIgnore
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<ProyectoImagen> proyectoImagen;

    public Proyecto() {
    }

    public Proyecto(Integer id, String nombre, String fecha, String descripcion, String urlProyecto, Persona persona) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.urlProyecto = urlProyecto;
        this.persona = persona;
    }
    
    
}
