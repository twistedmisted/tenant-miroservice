package com.example.tenantmicroservice.service.facade.impl;

import com.example.tenantmicroservice.model.dto.DbConfigurationDto;
import com.example.tenantmicroservice.model.mapper.DbConfigurationMapper;
import com.example.tenantmicroservice.model.payload.CreateDbConfig;
import com.example.tenantmicroservice.service.DbConfigurationService;
import com.example.tenantmicroservice.service.FlywayService;
import com.example.tenantmicroservice.service.facade.DbConfigurationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
@RequiredArgsConstructor
public class DbConfigurationFacadeImpl implements DbConfigurationFacade {

    private final DbConfigurationService dbConfService;
    private final FlywayService flywayService;
    private final DbConfigurationMapper dbConfMapper;

    @Override
    public DbConfigurationDto getByTenantId(String tenantId) {
        return dbConfService.getByTenantId(tenantId);
    }

    @Override
    public void createDbConfig(CreateDbConfig dbConfig) {
        DbConfigurationDto dbConfigDto = dbConfMapper.payloadToDto(dbConfig);
        dbConfService.saveTenant(dbConfigDto);
        try {
            flywayService.initNewDb(dbConfigDto);
        } catch (Exception e) {
            dbConfService.deleteTenant(dbConfig.getTenantId());
            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, "Can't create a schema for this tenant");
        }
    }

    @Override
    public void deleteTenant(String tenantId) {
        dbConfService.deleteTenant(tenantId);
    }
}
