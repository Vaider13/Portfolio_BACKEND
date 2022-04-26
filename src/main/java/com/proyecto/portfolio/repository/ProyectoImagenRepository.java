
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.ProyectoImagen;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoImagenRepository extends JpaRepository<ProyectoImagen, Integer> {
    List<ProyectoImagen>findByProyectoId(Integer proyectoId);
}
