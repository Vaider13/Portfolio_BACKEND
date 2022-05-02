
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.NivelIdioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelIdiomaRepository extends JpaRepository<NivelIdioma, Integer> {
    
    
    
}
