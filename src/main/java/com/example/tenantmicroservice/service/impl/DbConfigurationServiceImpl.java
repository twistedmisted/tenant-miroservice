package com.example.tenantmicroservice.service.impl;

import com.example.tenantmicroservice.model.dto.DbConfigurationDto;
import com.example.tenantmicroservice.model.mapper.DbConfigurationMapper;
import com.example.tenantmicroservice.repository.DbConfigurationRepository;
import com.example.tenantmicroservice.service.DbConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.*;

@Service
@RequiredArgsConstructor
public class DbConfigurationServiceImpl implements DbConfigurationService {

    private final DbConfigurationRepository dbConfRepository;
    private final DbConfigurationMapper dbConfMapper;

    @Override
    public DbConfigurationDto getByTenantId(String tenantId) {
        if (isNull(tenantId) || tenantId.isBlank()) {
            throw new ResponseStatusException(BAD_REQUEST, "Tenant id can't be empty");
        }
        return dbConfMapper.entityToDto(dbConfRepository.findById(tenantId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                                "Can't find a db configuration by tenantId = [" + tenantId + "]")));
    }

    @Override
    public void saveTenant(DbConfigurationDto dbConfigDto) {
        String tenantId = dbConfigDto.getTenantId();
        if (existsById(tenantId)) {
            throw new ResponseStatusException(CONFLICT,
                    "The tenant with id [" + tenantId + "] already exists");
        }
        dbConfRepository.save(dbConfMapper.dtoToEntity(dbConfigDto));
    }

    private boolean existsById(String tenantId) {
        return dbConfRepository.existsById(tenantId);
    }

    @Override
    public void deleteTenant(String tenantId) {
        dbConfRepository.deleteById(tenantId);
    }
}
