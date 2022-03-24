package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.GradoEducacion;
import java.util.List;

public interface IGradoService {

    public List<GradoEducacion> getGradoEducacion();

    public void saveGradoEducacion(GradoEducacion edu);

    public void deleteGradoEducacion(Integer id);

    public GradoEducacion findGradoEducacion(Integer id);
    
    public GradoEducacion findByGrado(String grado);

}
