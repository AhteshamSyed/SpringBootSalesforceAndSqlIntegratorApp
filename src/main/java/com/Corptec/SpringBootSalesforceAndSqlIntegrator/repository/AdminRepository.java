package com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository;

import com.Corptec.SpringBootSalesforceAndSqlIntegrator.model.Admin;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import java.util.Optional;

public interface AdminRepository extends R2dbcRepository<Admin,String> {
    Optional<Admin> findByUsername(String username);
   // Mono<User> findByUsername(String username);
    Boolean existsByUsername(String username);

}
