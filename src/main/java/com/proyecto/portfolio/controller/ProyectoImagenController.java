
package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.dto.ProyectoImagenDto;
import com.proyecto.portfolio.mapper.ProyectoImagenMapper;
import com.proyecto.portfolio.model.Proyecto;
import com.proyecto.portfolio.model.ProyectoImagen;
import com.proyecto.portfolio.service.IProyectoImagenService;
import com.proyecto.portfolio.service.IProyectoService;
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
@RequestMapping("proyectoImagenes")
@CrossOrigin(origins = "*")
public class ProyectoImagenController {
    
    @Autowired
    IProyectoImagenService iProyectImgService;
    
    @Autowired
    ProyectoImagenMapper proyectImgMapper;
    
    @Autowired
    IProyectoService iProyectService;
    
    //Se traen todas las URL de las imagenes de cada uno de los proyectos almacenados.
    @GetMapping("/traer")
    public ResponseEntity<List<ProyectoImagen>>getProyectoImagenes() {
        List<ProyectoImagen> list = iProyectImgService.getProyectoImagenes();
        return new ResponseEntity(proyectImgMapper.map(list), HttpStatus.OK);
    }
    
    //Trae las URL de las imagenes pertenecientes a un proyecto por medio del ID del mismo.
    @GetMapping("/traer/{proyectoId}")
    public ResponseEntity<List<ProyectoImagen>>getProyectoImagenesByProyectoId(@PathVariable (value = "proyectoId") Integer proyectoId) {
        List<ProyectoImagen> list = iProyectImgService.getProyectoImagenesByProyectoId(proyectoId);
        return new ResponseEntity(proyectImgMapper.map(list), HttpStatus.OK);
    }
    
    //Se almacena una nueva URL de una imagen por medio del ID de un proyecto.
    @PostMapping("/crear/{proyectoId}")
    public void saveProyectoImagen(@PathVariable(value = "proyectoId") Integer proyectoId,
            @RequestBody ProyectoImagenDto proyectImgDto) {
        ProyectoImagen proyectImg = new ProyectoImagen();
        Proyecto proyect = iProyectService.findProyecto(proyectoId);
        proyectImg.setImagenUrl(proyectImgDto.getImagenUrl());
        proyectImg.setProyecto(proyect);
        iProyectImgService.saveProyectoImagen(proyectImg);
    }
    
    //Se borra la URL de una imahen por medio de su ProyectoImagenDto.
    @DeleteMapping("/borrar/{id}")
    public void deleteProyectoImagenById(@PathVariable(value = "id") Integer id) {
        iProyectImgService.deleteById(id);
    }
    
    
    
    
}
