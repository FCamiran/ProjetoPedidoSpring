package com.camiran.first_project_spring.resources;

import org.springframework.web.bind.annotation.RestController;

import com.camiran.first_project_spring.domain.Cliente;
import com.camiran.first_project_spring.services.ClienteService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/clientes")
public class ClienteResource {

@Autowired
    private ClienteService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {

        Cliente obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

    
}