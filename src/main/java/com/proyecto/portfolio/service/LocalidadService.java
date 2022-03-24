
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
        List<Localidad> listaLocalidades = localRepo.findAll();
        return listaLocalidades;
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
        Localidad localidad = localRepo.getById(id);
        return localidad;
    }
    
}
