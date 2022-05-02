
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Idioma;
import java.util.List;


public interface IIdiomaService {
    
    public List<Idioma> getIdiomas();
    
    public Idioma getIdiomaById(Integer id);
    
    public Idioma getByIdioma(String idioma);
    
    public void saveIdioma(Idioma idioma);
    
    public void deleteIdiomaById(Integer id);
}
