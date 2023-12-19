package com.example.tenantmicroservice.service;

import com.example.tenantmicroservice.model.dto.DbConfigurationDto;

public interface DbConfigurationService {

    DbConfigurationDto getByTenantId(String tenantId);

    void saveTenant(DbConfigurationDto dbConfigDto);

    void deleteTenant(String tenantId);
}
