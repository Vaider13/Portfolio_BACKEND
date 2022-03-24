
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.EstadoEducacion;
import java.util.List;


public interface IEstadoEducacion {
    public List<EstadoEducacion> getEstadoEducacion();
      
    public void saveEstadoEducacion(EstadoEducacion edu);
    
    public void deleteEstadoEducacion(Integer id);
    
    public EstadoEducacion findEstadoEducacion(Integer id);
    
    public EstadoEducacion findByEstado(String estado);
}
