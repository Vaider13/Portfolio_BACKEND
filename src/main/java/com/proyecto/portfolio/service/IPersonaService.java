
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> getPersonas();
    
    public void savePersona(Persona perso);
    
    public void deletePersona(Integer id);
    
    public Persona findPersona(Integer id);
}
