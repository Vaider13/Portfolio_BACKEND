package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Provincia;
import java.util.List;

public interface IProvinciaService {

    public List<Provincia> getProvincia();

    public void saveProvincia(Provincia provincia);

    public void deleteProvincia(Integer id);

    public Provincia findProvincia(Integer id);

    public Provincia findByName(String provincia);
}
