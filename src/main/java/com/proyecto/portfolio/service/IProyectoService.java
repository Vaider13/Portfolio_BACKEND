
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    public List<Proyecto> getProyectos();
    
    public List<Proyecto> getProyectosByPersonaId(Integer personaId);
    
    public void saveProyecto(Proyecto proyecto);
    
    public void deleteProyecto(Integer id);
    
    public Proyecto findProyecto(Integer id);
}
