package com.example.tenantmicroservice.model.mapper;

import com.example.tenantmicroservice.entity.DbConfigurationEntity;
import com.example.tenantmicroservice.model.dto.DbConfigurationDto;
import com.example.tenantmicroservice.model.payload.CreateDbConfig;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Component
public class DbConfigurationMapper {

    public DbConfigurationDto entityToDto(DbConfigurationEntity entity) {
        if (isNull(entity)) {
            return null;
        }
        return DbConfigurationDto.builder()
                .tenantId(entity.getTenantId())
                .name(entity.getName())
                .url(entity.getUrl())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build();
    }

    public DbConfigurationEntity dtoToEntity(DbConfigurationDto dto) {
        if (isNull(dto)) {
            return null;
        }
        DbConfigurationEntity entity = new DbConfigurationEntity();
        entity.setTenantId(dto.getTenantId());
        entity.setName(dto.getName());
        entity.setUrl(dto.getUrl());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public DbConfigurationDto payloadToDto(CreateDbConfig payload) {
        if (isNull(payload)) {
            return null;
        }
        return DbConfigurationDto.builder()
                .tenantId(payload.getTenantId())
                .name(payload.getName())
                .url(payload.getUrl())
                .username(payload.getUsername())
                .password(payload.getPassword())
                .build();
    }
}
