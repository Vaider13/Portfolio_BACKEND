
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.NivelIdioma;
import com.proyecto.portfolio.repository.NivelIdiomaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NivelIdiomaService implements INivelIdiomaService {

    @Autowired
    NivelIdiomaRepository nivelIdiomaRepository;
    
    @Override
    public List<NivelIdioma> getNivelIdioma() {
        return nivelIdiomaRepository.findAll();
    }
}
