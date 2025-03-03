package com.camiran.first_project_spring.repositories;

import com.camiran.first_project_spring.domain.Cliente;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    
}