package com.camiran.first_project_spring.repositories;

import com.camiran.first_project_spring.domain.Categoria;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
    
}