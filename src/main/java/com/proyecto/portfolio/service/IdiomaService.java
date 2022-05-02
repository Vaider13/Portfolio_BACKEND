
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Idioma;
import com.proyecto.portfolio.repository.IdiomaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdiomaService implements IIdiomaService {
    
    @Autowired
    IdiomaRepository idiomaRepository;
    
    @Override
    public List<Idioma> getIdiomas() {
        return idiomaRepository.findAll();
    }

    @Override
    public Idioma getIdiomaById(Integer id) {
        return idiomaRepository.findById(id).get();
    }

    @Override
    public void saveIdioma(Idioma idioma) {
        idiomaRepository.save(idioma);
    }

    @Override
    public void deleteIdiomaById(Integer id) {
        idiomaRepository.deleteById(id);
    }

    @Override
    public Idioma getByIdioma(String idioma) {
        return idiomaRepository.findByNombreIdioma(idioma);
    }
    
}
