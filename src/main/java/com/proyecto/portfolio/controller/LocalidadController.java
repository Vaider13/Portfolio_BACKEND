package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.mapper.LocalidadMapper;
import com.proyecto.portfolio.model.Localidad;
import com.proyecto.portfolio.service.ILocalidadService;
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
@RequestMapping("/localidad")
@CrossOrigin(origins = "*")
public class LocalidadController {
    
    @Autowired
    ILocalidadService iLocalidadService;
    
    @Autowired
    LocalidadMapper localMapper;
    
    @GetMapping("/traer")
    public ResponseEntity<List<Localidad>> getLocalidad() {
        List<Localidad> list = iLocalidadService.getLocalidad();
        return new ResponseEntity(localMapper.map(list), HttpStatus.OK);        
    }
    
    @GetMapping("/traer/{provinciaId}")
    public ResponseEntity<List<Localidad>> getLocalidadByProvinciaId(@PathVariable(name = "provinciaId") Integer provinciaId) {
        List<Localidad> list = iLocalidadService.findByProvinciaId(provinciaId);
        return new ResponseEntity(localMapper.map(list), HttpStatus.OK);        
    }
    
}