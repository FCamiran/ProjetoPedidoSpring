package com.camiran.first_project_spring.repositories;

import com.camiran.first_project_spring.domain.Pedido;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    
    
}