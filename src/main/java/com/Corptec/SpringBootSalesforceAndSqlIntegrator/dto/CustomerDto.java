package com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto implements Serializable {

    private String id;
    private String username;
    private String password;
    private String email;
    private String phone;


}
