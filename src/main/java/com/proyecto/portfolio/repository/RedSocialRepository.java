
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.RedSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedSocialRepository extends JpaRepository<RedSocial, Integer>{
    
    //Trae las redes sociales pertenecientes a una persona por medio del ID de la misma.
    RedSocial findByPersonaId(Integer personaId);
}
