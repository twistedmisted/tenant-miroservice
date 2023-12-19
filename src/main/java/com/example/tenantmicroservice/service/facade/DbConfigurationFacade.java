package com.example.tenantmicroservice.service.facade;

import com.example.tenantmicroservice.model.dto.DbConfigurationDto;
import com.example.tenantmicroservice.model.payload.CreateDbConfig;

public interface DbConfigurationFacade {

    DbConfigurationDto getByTenantId(String tenantId);

    void createDbConfig(CreateDbConfig dbConfig);

    void deleteTenant(String tenantId);
}
