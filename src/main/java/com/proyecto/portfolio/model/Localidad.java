
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
public class Localidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String localidad;
    //Relacion muchos a uno entre la clase "Localidad" y "Provincia"
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE )
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;
    @JsonIgnore
    //Relacion uno a muchos entre la clase "Localidad" y "Persona".
    @OneToMany(mappedBy = "localidad", fetch = FetchType.EAGER, cascade=CascadeType.MERGE )
    private List<Persona> personas;  
}
