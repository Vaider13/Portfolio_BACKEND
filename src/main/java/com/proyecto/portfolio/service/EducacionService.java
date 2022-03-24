
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Educacion;
import com.proyecto.portfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{

    @Autowired
    private EducacionRepository eduRepo;
    
    @Override
    public List<Educacion> getEducacion() {
         return eduRepo.findAll();
    } 
    
    @Override
    public void saveEducacion(Educacion edu) {
        eduRepo.save(edu);
    }

    @Override
    public void deleteEducacion(Integer id) {
        eduRepo.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Integer id) {
         Educacion edu = eduRepo.findById(id).get();
         return edu;
    }

    @Override
    public List<Educacion> getEducacionByPersonaId(Integer personaId) {
            return eduRepo.findByPersonaId(personaId);
    }
}
