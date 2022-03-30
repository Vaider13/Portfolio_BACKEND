
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.ExperienciaLaboral;
import java.util.List;


public interface IExperienciaLaboral {
    public List<ExperienciaLaboral> getExperienciaLaboral();
    
    public List<ExperienciaLaboral> getExperienciaLaboralByPersonaId(Integer personaId);
    
    public void saveExperienciaLaboral(ExperienciaLaboral exp);
    
    public void deleteExperienciaLaboral(Integer id);
    
    public ExperienciaLaboral findExperienciaLaboral(Integer id);
    
    
}
