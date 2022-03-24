
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.EstadoEducacion;
import com.proyecto.portfolio.repository.EstadoEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoEducacionService implements IEstadoEducacion {

    @Autowired
    EstadoEducacionRepository estadoRepo;
    
    @Override
    public List<EstadoEducacion> getEstadoEducacion() {
        List <EstadoEducacion> listasEstado = estadoRepo.findAll();
        return listasEstado;
    }

    @Override
    public void saveEstadoEducacion(EstadoEducacion edu) {
        estadoRepo.save(edu);
    }

    @Override
    public void deleteEstadoEducacion(Integer id) {
        estadoRepo.deleteById(id);
    }

    @Override
    public EstadoEducacion findEstadoEducacion(Integer id) {
        return estadoRepo.getById(id);

    }

    @Override
    public EstadoEducacion findByEstado(String estado) {
        return estadoRepo.findByEstado(estado);
    }
    
}
