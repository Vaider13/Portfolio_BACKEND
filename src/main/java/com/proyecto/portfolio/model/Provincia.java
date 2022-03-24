
package com.proyecto.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String provincia;
    @JsonIgnore
    @OneToMany(mappedBy = "provincia" , cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Localidad> localidades;
 
    public Provincia() {
    }

    public Provincia(int id, String provincia) {
        this.id = id;
        this.provincia = provincia;
    }

    
}
