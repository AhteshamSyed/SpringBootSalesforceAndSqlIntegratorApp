package com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto;

import com.Corptec.SpringBootSalesforceAndSqlIntegrator.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoginResponseDto {
    private boolean success;
    private String message;
    private String token;
    private Customer customer;
}
