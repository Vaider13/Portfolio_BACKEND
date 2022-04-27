package com.proyecto.portfolio.model;


import javax.persistence.CascadeType;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    @NotNull
    private String titulo;
    @NotNull
    private String nombreInstitucion;
    @NotNull
    private String fechaInicio;
    private String fechaFinal;
    private String logoEducacion;
    
    //Relacion muchos a uno entre la clase "Educacion" y "Persona"
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE )
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona persona;
    //Relacion muchos a uno entre la clase "Educacion" y "Grado Educacion"
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE )
    @JoinColumn(name = "grado_id", referencedColumnName = "id")
    private GradoEducacion gradoEducacion;
    //Relacion muchos a uno entre la clase "Educacion" y "Estado Educacion"
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE )
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    private EstadoEducacion estadoEducacion;

    public Educacion() {
    }

    public Educacion(String titulo, String nombreInstitucion, String fechaInicio, String fechaFinal, String logoEducacion, Persona persona, GradoEducacion gradoEducacion, EstadoEducacion estadoEducacion) {
        this.titulo = titulo;
        this.nombreInstitucion = nombreInstitucion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.logoEducacion = logoEducacion;
        this.persona = persona;
        this.gradoEducacion = gradoEducacion;
        this.estadoEducacion = estadoEducacion;
    }

    
}
