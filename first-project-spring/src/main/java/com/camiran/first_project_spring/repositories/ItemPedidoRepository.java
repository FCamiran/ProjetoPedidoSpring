package com.camiran.first_project_spring.repositories;

import com.camiran.first_project_spring.domain.ItemPedido;
import com.camiran.first_project_spring.domain.ItemPedidoPk;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPk> {

    

    
}
