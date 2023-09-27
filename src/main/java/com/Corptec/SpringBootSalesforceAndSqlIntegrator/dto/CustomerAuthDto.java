package com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAuthDto {
    private String username;
    private String password;

}
