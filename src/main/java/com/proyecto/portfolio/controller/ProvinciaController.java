
package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.model.Provincia;
import com.proyecto.portfolio.service.IProvinciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("provincia")
@CrossOrigin(origins = "*")
public class ProvinciaController {
    
    @Autowired
    IProvinciaService iProvinciaService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<Provincia>> getProvincia() {
        List<Provincia> list = iProvinciaService.getProvincia();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/traer/{provincia}")
    public ResponseEntity<Provincia> getProvinciaByProvinciaName(@PathVariable(name = "provincia") String provincia) {
        Provincia pro = iProvinciaService.findByName(provincia);
        return new ResponseEntity(pro, HttpStatus.OK);
    }
}
