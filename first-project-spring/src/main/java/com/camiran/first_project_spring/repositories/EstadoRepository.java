package com.camiran.first_project_spring.repositories;

import com.camiran.first_project_spring.domain.Estado;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
    
    
}