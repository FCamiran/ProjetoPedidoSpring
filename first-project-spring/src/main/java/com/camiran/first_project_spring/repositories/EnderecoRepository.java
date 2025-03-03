package com.camiran.first_project_spring.repositories;

import com.camiran.first_project_spring.domain.Endereco;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    
    
}