
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Educacion;
import java.util.List;


public interface IEducacionService {
    
    public List<Educacion> getEducacion();
    
    public List<Educacion> getEducacionByPersonaId(Integer personaId);
    
    public void saveEducacion(Educacion edu);
    
    public void deleteEducacion(Integer id);
    
    public Educacion findEducacion(Integer id);
}
