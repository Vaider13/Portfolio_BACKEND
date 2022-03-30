
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.ExperienciaLaboral;
import com.proyecto.portfolio.repository.ExperienciaLaboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboral{
    
    @Autowired
    private ExperienciaLaboralRepository experienciaRepository;

    @Override
    public List<ExperienciaLaboral> getExperienciaLaboral() {
        return experienciaRepository.findAll();
    }

    @Override
    public List<ExperienciaLaboral> getExperienciaLaboralByPersonaId(Integer personaId) {
        return experienciaRepository.findByPersonaId(personaId);
    }

    @Override
    public void saveExperienciaLaboral(ExperienciaLaboral exp) {
        experienciaRepository.save(exp);
    }

   @Override
    public void deleteExperienciaLaboral(Integer id) {
        experienciaRepository.deleteById(id);
    }

    @Override
    public ExperienciaLaboral findExperienciaLaboral(Integer id) {
        return experienciaRepository.findById(id).get();
    }

    
    
}
