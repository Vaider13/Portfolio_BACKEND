package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Persona;
import com.proyecto.portfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository persorepo;

    @Override
    public List<Persona> getPersonas() {
        return persorepo.findAll();
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
        return persorepo.findById(id).get();
    }

    @Override
    public Persona findPersonaByUserId(Integer usuario_id) {
        return persorepo.findPersonaByUsuarioId(usuario_id);
    }

}
