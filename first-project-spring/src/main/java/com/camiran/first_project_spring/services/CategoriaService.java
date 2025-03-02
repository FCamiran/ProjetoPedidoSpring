package com.camiran.first_project_spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.camiran.first_project_spring.domain.Categoria;
import java.util.Optional;
import com.camiran.first_project_spring.repositories.CategoriaRepository;
import com.camiran.first_project_spring.services.exceptions.ObjectNotFoundException;



@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repo;


    public Categoria buscar(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }   


}