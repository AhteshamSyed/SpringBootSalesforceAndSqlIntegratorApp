package com.Corptec.SpringBootSalesforceAndSqlIntegrator.service;

import com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto.CustomerDto;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.mapper.CustomerMapper;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.model.Customer;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Mono<CustomerDto> saveCustomer(CustomerDto customerDto) {
        Customer customer= CustomerMapper.mapToCustomer(customerDto);
        Mono<Customer> savedCustomer= customerRepository.save(customer);
        return savedCustomer.
                   map((cutomer)->CustomerMapper.mapToCustomerDto(customer));
    }

    @Override
    public Mono<CustomerDto> getCustomer(String customerId) {
        Mono<Customer> customerMono= customerRepository.findById(customerId);
        return customerMono.map((cutomer)->CustomerMapper.mapToCustomerDto(cutomer));
    }

    @Override
    public Flux<CustomerDto> getAllCustomers() {
        Flux<Customer> customerFlux= customerRepository.findAll();
        return customerFlux.map((cutomer)->CustomerMapper.mapToCustomerDto(cutomer))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<CustomerDto> updateCustomer(CustomerDto customerDto, String customerId) {
        Mono<Customer> customerMono= customerRepository.findById(customerId);
        return customerMono.flatMap((existingCustomer)->{
            existingCustomer.setUsername(customerDto.getUsername());
            existingCustomer.setEmail(customerDto.getEmail());
            existingCustomer.setPhone(customerDto.getPhone());
            return customerRepository.save(existingCustomer);
        }).map((customer->CustomerMapper.mapToCustomerDto(customer)));
    }

    @Override
    public Mono<Void> deleteCustomer(String customerId) {
        return customerRepository.deleteById(customerId);
    }
}
