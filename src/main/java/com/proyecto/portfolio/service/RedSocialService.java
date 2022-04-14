
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.RedSocial;
import com.proyecto.portfolio.repository.RedSocialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedSocialService implements  IRedSocialService{

    @Autowired
    RedSocialRepository redRepo;
    
    @Override
    public List<RedSocial> getRedesSociales() {
        return redRepo.findAll();
    }

    @Override
    public RedSocial getByPersonaId(Integer personaId) {
        return redRepo.findByPersonaId(personaId);
    }

    @Override
    public void saveRedSocial(RedSocial redSocial) {
        redRepo.save(redSocial);
    }

    @Override
    public void deleteById(Integer id) {
        redRepo.deleteById(id);
    }

    @Override
    public RedSocial getById(Integer id) {
        return redRepo.findById(id).get();
    }
    
}
