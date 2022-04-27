
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.GradoEducacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradoEducacionRepository extends JpaRepository<GradoEducacion, Integer> {
    
    //Busca un grado de educacion por medio del atributo grado
    //(Secundario, Terciario, Universitario, Posgrado, Doctorado, Curso).
    GradoEducacion findByGrado(String grado);
}
