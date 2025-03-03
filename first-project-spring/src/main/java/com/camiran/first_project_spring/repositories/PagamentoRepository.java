package com.camiran.first_project_spring.repositories;

import com.camiran.first_project_spring.domain.Pagamento;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    
    
}