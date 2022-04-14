
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Localidad;
import java.util.List;


public interface ILocalidadService {
    public List<Localidad> getLocalidad();
    
    public void saveLocalidad(Localidad localidad);
    
    public void deleteLocalidad(Integer id);
    
    public Localidad findLocalidad(Integer id);
    
    public Localidad findByName(String localidad);
    
    public List<Localidad> findByProvinciaId(Integer provinciaId);
}
