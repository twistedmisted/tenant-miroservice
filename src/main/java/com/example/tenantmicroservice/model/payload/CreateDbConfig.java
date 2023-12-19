package com.example.tenantmicroservice.model.payload;

import lombok.Data;

@Data
public class CreateDbConfig {

    private String tenantId;
    private String url;
    private String name;
    private String username;
    private String password;
}
