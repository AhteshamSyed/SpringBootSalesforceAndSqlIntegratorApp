package com.Corptec.SpringBootSalesforceAndSqlIntegrator.mapper;

import com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto.CustomerDto;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.model.Customer;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getUsername(),
                customer.getPassword(),
                customer.getEmail(),
                customer.getPhone()
        );
    }
    public static Customer mapToCustomer(CustomerDto customerDto){
        return new Customer(
                customerDto.getId(),
                customerDto.getUsername(),
                customerDto.getPassword(),
                customerDto.getEmail(),
                customerDto.getPhone()
        );
    }
}
