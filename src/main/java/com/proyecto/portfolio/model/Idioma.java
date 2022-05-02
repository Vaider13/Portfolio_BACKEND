
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
public class Idioma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nombreIdioma;
   //Relacion uno a muchos entre la clase "Idioma" y "Experiencia Idioma".
    @JsonIgnore
    @OneToMany(mappedBy = "Idioma")
    private List<ExperienciaIdioma> experienciaIdioma;

    public Idioma() {
    }

    public Idioma(Integer id, String nombreIdioma) {
        this.id = id;
        this.nombreIdioma = nombreIdioma;
    }
    
    
}


