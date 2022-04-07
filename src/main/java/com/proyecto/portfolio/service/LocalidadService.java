
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Localidad;
import com.proyecto.portfolio.repository.LocalidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadService implements ILocalidadService {

    @Autowired
    private LocalidadRepository localRepo;
    
    @Override
    public List<Localidad> getLocalidad() {
        return localRepo.findAll();
    }

    @Override
    public void saveLocalidad(Localidad localidad) {
        localRepo.save(localidad);
    }

    @Override
    public void deleteLocalidad(Integer id) {
        localRepo.deleteById(id);
    }

    @Override
    public Localidad findLocalidad(Integer id) {
       return localRepo.getById(id);
    }

    @Override
    public Localidad findByName(String localidad) {
        return localRepo.findByLocalidad(localidad);
    }
    
}
