
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.RedSocial;
import java.util.List;


public interface IRedSocialService {
    public List<RedSocial> getRedesSociales();
    
    public RedSocial getByPersonaId(Integer personaId);
    
    public void saveRedSocial(RedSocial redSocial);
    
    public void deleteById(Integer id);
    
    public RedSocial getById(Integer id);
}
