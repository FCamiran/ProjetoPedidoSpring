package com.camiran.first_project_spring.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @RequestMapping(method=RequestMethod.GET)
    public String listar() {
        return "REST está funcionando!";
    }

    
}