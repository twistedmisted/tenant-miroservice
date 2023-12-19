package com.example.tenantmicroservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_configurations")
@Getter
@Setter
public class DbConfigurationEntity {

    @Id
    private String tenantId;

    private String name;

    private String url;

    private String username;

    private String password;
}
