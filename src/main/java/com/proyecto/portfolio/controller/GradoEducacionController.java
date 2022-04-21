package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.model.GradoEducacion;
import com.proyecto.portfolio.service.IGradoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("grado")
@CrossOrigin(origins = "*")
public class GradoEducacionController {

    @Autowired
    IGradoService iGradoService;

    @GetMapping("/traer")
    public ResponseEntity<List<GradoEducacion>> getEducacion() {
        List<GradoEducacion> list = iGradoService.getGradoEducacion();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
