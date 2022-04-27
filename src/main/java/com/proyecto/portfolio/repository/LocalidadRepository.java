
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.Localidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends JpaRepository <Localidad, Integer> {
    
    //Busca una localidad por medio de su nombre.
    Localidad findByLocalidad(String localidad);
    
    //busca una localidad por medio del ID de una provincia.
    List<Localidad>findByProvinciaId(Integer provinciaId);
}
