
package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.model.NivelIdioma;
import com.proyecto.portfolio.service.INivelIdiomaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("nivelidioma")
@CrossOrigin(origins = "*")
public class NivelIdiomaController {
    
    @Autowired
    INivelIdiomaService iNivelService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<NivelIdioma>> getNivelIdiomas() {
        List<NivelIdioma> list = iNivelService.getNivelIdioma();
        return new ResponseEntity(list, HttpStatus.OK);
    }     
    
    
}
