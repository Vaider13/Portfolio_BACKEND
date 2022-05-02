
package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.dto.IdiomaDto;
import com.proyecto.portfolio.mapper.IdiomaMapper;
import com.proyecto.portfolio.model.Idioma;
import com.proyecto.portfolio.service.IIdiomaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("idioma")
@CrossOrigin(origins = "*")
public class IdiomaController {
    
    @Autowired
    IIdiomaService iIdiomaService;
    
    @Autowired
    IdiomaMapper idiomaMap;
    
    @GetMapping("/traer")
    public ResponseEntity<List<Idioma>> getIdiomas() {
        List<Idioma> list = iIdiomaService.getIdiomas();
        return new ResponseEntity(idiomaMap.map(list), HttpStatus.OK);
    }
    
    @GetMapping("/traeruno/{id}")
    public ResponseEntity<Idioma> getIdiomaById(@PathVariable(name
            = "id") Integer id) {
        Idioma idioma = iIdiomaService.getIdiomaById(id);
        return new ResponseEntity(idiomaMap.map(idioma), HttpStatus.OK);
    }
    
    @PostMapping("/crear/")
    public void saveIdioma(@RequestBody IdiomaDto idiomaDto) {
        Idioma idioma = new Idioma();
        idioma.setNombreIdioma(idiomaDto.getNombreIdioma());
        iIdiomaService.saveIdioma(idioma);
    }
    
    @DeleteMapping("/borrar/{id}")
     public void deleteIdiomaById(@PathVariable(name
            = "id") Integer id) {
        iIdiomaService.deleteIdiomaById(id);
    }
}
