
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
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nombreSkill;
    @NotNull
    private String tipoSkill;
    @NotNull
    private Integer nivelSkill;
    //Relacion muchos a uno entre la clase "Skill" y "Persona"
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona persona;

    public Skill() {
    }

    public Skill(Integer id, String nombreSkill, String tipoSkill, Integer nivelSkill, Persona persona) {
        this.id = id;
        this.nombreSkill = nombreSkill;
        this.tipoSkill = tipoSkill;
        this.nivelSkill = nivelSkill;
        this.persona = persona;
    }
    
    
}
