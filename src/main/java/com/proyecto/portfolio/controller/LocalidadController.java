package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.dto.LocalidadDto;
import com.proyecto.portfolio.mapper.LocalidadMapper;
import com.proyecto.portfolio.model.Localidad;
import com.proyecto.portfolio.model.Provincia;
import com.proyecto.portfolio.service.ILocalidadService;
import com.proyecto.portfolio.service.IProvinciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("localidad")
@CrossOrigin(origins = "*")
public class LocalidadController {
    
    @Autowired
    ILocalidadService iLocalidadService;
    
    @Autowired
    IProvinciaService iProvinciaService;
    
    @Autowired
    LocalidadMapper localMapper;
    
    //Trae todas las localidades almacenadas.
    @GetMapping("/traer")
    public ResponseEntity<List<Localidad>> getLocalidad() {
        List<Localidad> list = iLocalidadService.getLocalidad();
        return new ResponseEntity(localMapper.map(list), HttpStatus.OK);        
    }
    
    //Trae todas las localidades pertenecientes a una provincia, por medio del ID de la misma.
    @GetMapping("/traer/{provinciaId}")
    public ResponseEntity<List<Localidad>> getLocalidadByProvinciaId(@PathVariable(name = "provinciaId") Integer provinciaId) {
        List<Localidad> list = iLocalidadService.findByProvinciaId(provinciaId);
        return new ResponseEntity(localMapper.map(list), HttpStatus.OK);        
    }
    
    //Crea una nueva localidad, para ellos se crea un nuevo objeto, lo cual se le asignan los valores, que provienen
    // del cuerpo de la solicitud, se le asigna el objeto de la provincia correspondiente, y posteriormente se guarda.
    @PostMapping("/crear")
    public void crearLocalidad(@RequestBody LocalidadDto localidadDto) {
        Localidad localidad = new Localidad();
        Provincia provincia = iProvinciaService.findByName(localidadDto.getProvincia());
        localidad.setLocalidad(localidadDto.getLocalidad());
        localidad.setProvincia(provincia);
        iLocalidadService.saveLocalidad(localidad);
        
    }
}
