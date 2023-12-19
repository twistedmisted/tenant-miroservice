package com.example.tenantmicroservice.service;

import com.example.tenantmicroservice.model.dto.DbConfigurationDto;

public interface FlywayService {

    void initNewDb(DbConfigurationDto dbConfig);
}
