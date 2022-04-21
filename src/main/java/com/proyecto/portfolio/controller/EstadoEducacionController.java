
package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.model.EstadoEducacion;
import com.proyecto.portfolio.service.IEstadoEducacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estado")
@CrossOrigin(origins = "*")
public class EstadoEducacionController {
    
    @Autowired
    IEstadoEducacion iEstadoService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<EstadoEducacion>>getEstadoEducacion() {
        List<EstadoEducacion> list = iEstadoService.getEstadoEducacion();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
}
