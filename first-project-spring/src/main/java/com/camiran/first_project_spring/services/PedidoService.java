package com.camiran.first_project_spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.camiran.first_project_spring.domain.Pedido;
import java.util.Optional;
import com.camiran.first_project_spring.repositories.PedidoRepository;
import com.camiran.first_project_spring.services.exceptions.ObjectNotFoundException;



@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository repo;


    public Pedido buscar(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }   


}