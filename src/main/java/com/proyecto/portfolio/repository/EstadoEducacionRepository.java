
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.EstadoEducacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoEducacionRepository extends JpaRepository<EstadoEducacion, Integer> {
    
    //Busca un estado de educacion por medio del atributo estado(Graduado, En Curso, Abandonado)
    EstadoEducacion findByEstado(String estado);
}
