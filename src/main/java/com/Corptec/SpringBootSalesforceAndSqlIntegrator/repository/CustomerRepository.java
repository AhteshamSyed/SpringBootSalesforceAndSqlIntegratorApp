package com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository;

import com.Corptec.SpringBootSalesforceAndSqlIntegrator.model.Customer;
//import org.springframework.data.r2dbc.repository.R2dbcRepository;
//import org.springframework.boot.autoconfigure.data.r2dbc.R2dbcRepositoriesAutoConfiguration;
//import org.springframework.boot.autoconfigure.r2dbc.R2dbcConnectionDetails;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends R2dbcRepository<Customer, String> {
    Optional<Customer> findByUsername(String username);

    boolean existsByEmail(String email);
}
