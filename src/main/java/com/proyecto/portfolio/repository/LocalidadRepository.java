
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends JpaRepository <Localidad, Integer> {
    
}
