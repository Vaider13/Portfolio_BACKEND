
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.ProyectoImagen;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.portfolio.repository.ProyectoImagenRepository;

@Service
public class ProyectoImagenService implements IProyectoImagenService {

    @Autowired
    ProyectoImagenRepository proyectImagenRepo; 
    
    @Override
    public List<ProyectoImagen> getProyectoImagenes() {
        return proyectImagenRepo.findAll();
    }

    @Override
    public List<ProyectoImagen> getProyectoImagenesByProyectoId(Integer proyectoId) {
        return proyectImagenRepo.findByProyectoId(proyectoId);
    }

    @Override
    public void saveProyectoImagen(ProyectoImagen proyectoImagen) {
        proyectImagenRepo.save(proyectoImagen);
    }

    @Override
    public void deleteById(Integer id) {
        proyectImagenRepo.deleteById(id);
    }

    @Override
    public ProyectoImagen getById(Integer id) {
       return proyectImagenRepo.findById(id).get();
    }
}
