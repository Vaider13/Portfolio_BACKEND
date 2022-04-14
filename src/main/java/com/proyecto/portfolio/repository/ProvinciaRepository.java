
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {
    Provincia findByProvincia(String Provincia);
}
