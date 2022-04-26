
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.ProyectoImagen;
import java.util.List;


public interface IProyectoImagenService {
    
    public List<ProyectoImagen>getProyectoImagenes();
    
    public List<ProyectoImagen>getProyectoImagenesByProyectoId(Integer proyectoId);
    
    public void saveProyectoImagen(ProyectoImagen proyectoImagen);
    
    public void deleteById(Integer id);
    
    public ProyectoImagen getById(Integer id);
}
