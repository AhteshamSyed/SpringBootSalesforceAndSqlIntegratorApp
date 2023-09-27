package com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto;

import com.Corptec.SpringBootSalesforceAndSqlIntegrator.model.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminLoginResponseDto {
    private boolean success;
    private String message;
    private String token;
    private Admin admin;
    public void setAdmin(String username, Integer id) {
        this.admin = new Admin();
        this.admin.setUsername(username);
        this.admin.setId(id);
    }




}
