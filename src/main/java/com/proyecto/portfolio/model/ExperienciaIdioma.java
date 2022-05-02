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
public class ExperienciaIdioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //Relacion muchos a uno entre la clase Experiencia Idioma e Idioma.
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idioma_id", referencedColumnName = "id")
    private Idioma Idioma;
    @NotNull
    private String oral;
    @NotNull
    private String escritura;
    @NotNull
    private String lectura;
    //Relacion muchos a uno entre la clase Experiencia Idioma y Persona.
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona persona;

    public ExperienciaIdioma() {
    }

    public ExperienciaIdioma(Integer id, Persona persona, Idioma Idioma, String oral, String escritura, String lectura) {
        this.id = id;
        this.persona = persona;
        this.Idioma = Idioma;
        this.oral = oral;
        this.escritura = escritura;
        this.lectura = lectura;
    }

}
