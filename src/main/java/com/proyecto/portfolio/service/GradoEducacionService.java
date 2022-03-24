
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.GradoEducacion;
import com.proyecto.portfolio.repository.GradoEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradoEducacionService implements IGradoService{

    @Autowired
    GradoEducacionRepository gradoRepo;
    
    @Override
    public List<GradoEducacion> getGradoEducacion() {
        return gradoRepo.findAll();
    }

    @Override
    public void saveGradoEducacion(GradoEducacion edu) {
        gradoRepo.save(edu);
    }

    @Override
    public void deleteGradoEducacion(Integer id) {
        gradoRepo.deleteById(id);
    }

    @Override
    public GradoEducacion findGradoEducacion(Integer id) {
        return gradoRepo.getById(id);
    }

    @Override
    public GradoEducacion findByGrado(String grado) {
        return gradoRepo.findByGrado(grado);
    }
    
}
