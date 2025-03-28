package com.camiran.first_project_spring.resources;

import org.springframework.web.bind.annotation.RestController;

import com.camiran.first_project_spring.domain.Categoria;
import com.camiran.first_project_spring.services.CategoriaService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

@Autowired
    private CategoriaService service;

     @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {

        Categoria obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

    
}