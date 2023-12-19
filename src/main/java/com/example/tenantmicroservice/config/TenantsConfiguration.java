package com.example.tenantmicroservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "tenants")
@Setter
@Getter
public class TenantsConfiguration {

    private Map<String, TenantDbConfiguration> configurations;

    @Setter
    @Getter
    public static class TenantDbConfiguration {
        private String databaseName;
        private String url;
        private String username;
        private String password;
    }
}
