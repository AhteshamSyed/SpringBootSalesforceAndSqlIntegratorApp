package com.Corptec.SpringBootSalesforceAndSqlIntegrator.service;

import com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto.CustomerDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {


    Mono<CustomerDto> saveCustomer(CustomerDto customerDto);

    Mono<CustomerDto> getCustomer(String customerId);

    Flux<CustomerDto> getAllCustomers();

    Mono<CustomerDto> updateCustomer(CustomerDto customerDto, String customerId);

    Mono<Void> deleteCustomer(String employeeId);
}
