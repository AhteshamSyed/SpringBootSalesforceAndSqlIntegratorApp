package com.Corptec.SpringBootSalesforceAndSqlIntegrator.model;




//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Customer {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private String phone;
}
