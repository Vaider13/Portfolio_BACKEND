
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.ExperienciaIdioma;
import com.proyecto.portfolio.repository.ExperienciaIdiomaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaIdioomaService implements IExperienciaIdioma{
    
    @Autowired
    ExperienciaIdiomaRepository expRepository;

    @Override
    public List<ExperienciaIdioma> getExperienciaIdioma() {
        return expRepository.findAll();
    }

    @Override
    public List<ExperienciaIdioma> getExperienciaIdiomaByPersonaId(Integer personaId) {
        return expRepository.findByPersonaId(personaId);
    }

    @Override
    public ExperienciaIdioma getExperienciaIdiomaById(Integer id) {
        return expRepository.findById(id).get();
    }

    @Override
    public void saveExperienciaIdioma(ExperienciaIdioma experienciaIdioma) {
        expRepository.save(experienciaIdioma);
    }

    @Override
    public void deleteById(Integer id) {
        expRepository.deleteById(id);
    }
    
}
