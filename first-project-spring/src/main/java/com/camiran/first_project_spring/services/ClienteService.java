package com.camiran.first_project_spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.camiran.first_project_spring.domain.Cliente;
import java.util.Optional;
import com.camiran.first_project_spring.repositories.ClienteRepository;
import com.camiran.first_project_spring.services.exceptions.ObjectNotFoundException;



@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repo;


    public Cliente buscar(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }   


}