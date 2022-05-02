
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.ExperienciaIdioma;
import java.util.List;


public interface IExperienciaIdioma {
    
    public List<ExperienciaIdioma> getExperienciaIdioma();
    
    public List<ExperienciaIdioma> getExperienciaIdiomaByPersonaId(Integer personaId);
    
    public ExperienciaIdioma getExperienciaIdiomaById(Integer id);
    
    public void saveExperienciaIdioma(ExperienciaIdioma experienciaIdioma);
    
    public void deleteById(Integer id);
    
}
