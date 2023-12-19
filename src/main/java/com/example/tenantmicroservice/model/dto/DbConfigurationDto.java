package com.example.tenantmicroservice.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DbConfigurationDto {

    private String tenantId;
    private String url;
    private String name;
    private String username;
    private String password;
}
