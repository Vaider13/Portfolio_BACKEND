
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.Localidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends JpaRepository <Localidad, Integer> {
    Localidad findByLocalidad(String localidad);
    List<Localidad>findByProvinciaId(Integer provinciaId);
}
