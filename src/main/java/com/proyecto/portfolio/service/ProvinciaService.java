
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Provincia;
import com.proyecto.portfolio.repository.ProvinciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaService implements IProvinciaService{

    @Autowired
    ProvinciaRepository provinciaRepo;
    
    @Override
    public List<Provincia> getProvincia() {
        return provinciaRepo.findAll();
    }

    @Override
    public void saveProvincia(Provincia provincia) {
        provinciaRepo.save(provincia);
    }

    @Override
    public void deleteProvincia(Integer id) {
        provinciaRepo.deleteById(id);
    }

    @Override
    public Provincia findProvincia(Integer id) {
        return provinciaRepo.findById(id).get();
    }

    @Override
    public Provincia findByName(String provincia) {
        return provinciaRepo.findByProvincia(provincia);
    }
    
}
