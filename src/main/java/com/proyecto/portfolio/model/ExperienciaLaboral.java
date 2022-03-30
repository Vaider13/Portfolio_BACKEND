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
public class ExperienciaLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nombreEmpresa;
    @NotNull
    private String puesto;
    @NotNull
    private String fechaInicio;
    private String fechaFinal;
    @NotNull
    private String descripcion;
    private String logoEmpresa;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona persona;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(Integer id, String nombreCompañia, String puesto, String fechaInicio, String fechaFinal, String descripcion, String logoCompañia, Persona persona) {
        this.id = id;
        this.nombreEmpresa = nombreCompañia;
        this.puesto = puesto;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.descripcion = descripcion;
        this.logoEmpresa = logoCompañia;
        this.persona = persona;
    }

    
}
