package com.Corptec.SpringBootSalesforceAndSqlIntegrator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Admin {
    @Id
    private int id;

    private String username;
    private String password;
}
