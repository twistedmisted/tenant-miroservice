package com.example.tenantmicroservice.repository;

import com.example.tenantmicroservice.entity.DbConfigurationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DbConfigurationRepository extends MongoRepository<DbConfigurationEntity, String> {

    List<DbConfigurationEntity> findAll();
}
