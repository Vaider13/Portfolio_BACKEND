package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Proyecto;
import com.proyecto.portfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    ProyectoRepository proyecRepo;

    @Override
    public List<Proyecto> getProyectos() {
        return proyecRepo.findAll();
    }

    @Override
    public List<Proyecto> getProyectosByPersonaId(Integer personaId) {
        return proyecRepo.findByPersonaId(personaId);
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        proyecRepo.save(proyecto);
    }

    @Override
    public void deleteProyecto(Integer id) {
        proyecRepo.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Integer id) {
        return proyecRepo.findById(id).get();
    }
}
