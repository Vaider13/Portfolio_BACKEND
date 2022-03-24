
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Persona;
import com.proyecto.portfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService  {
    @Autowired
    private PersonaRepository persorepo;
    
    @Override
    public List<Persona> getPersonas() {
        List <Persona> listasPersonas = persorepo.findAll();
        return listasPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
        persorepo.save(perso);
    }

    @Override
    public void deletePersona(Integer id) {
        persorepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Integer id) {
        Persona perso = persorepo.findById(id).get();
        return perso;
    }
    
}
