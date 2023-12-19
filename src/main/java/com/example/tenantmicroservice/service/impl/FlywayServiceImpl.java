package com.example.tenantmicroservice.service.impl;

import com.example.tenantmicroservice.model.dto.DbConfigurationDto;
import com.example.tenantmicroservice.repository.DbConfigurationRepository;
import com.example.tenantmicroservice.service.FlywayService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlywayServiceImpl implements FlywayService {

    private static final String TABLES_LOCATION = "classpath:/dev/db/tenant/tables";
    private static final String MIGRATION_LOCATION = "classpath:/dev/db/tenant/migration";

    private final DbConfigurationRepository dbConfigurationRepository;

//    @PostConstruct
    public void applyMigration() {
        dbConfigurationRepository.findAll().forEach(dbConf -> {
            Flyway.configure()
                    .dataSource(dbConf.getUrl() + dbConf.getName(), dbConf.getUsername(), dbConf.getPassword())
                    .locations(MIGRATION_LOCATION)
                    .load()
                    .migrate();
        });
    }

    @Override
    public void initNewDb(DbConfigurationDto dbConfig) {
        Flyway.configure()
                .dataSource(dbConfig.getUrl() + dbConfig.getName(), dbConfig.getUsername(), dbConfig.getPassword())
                .locations(TABLES_LOCATION, MIGRATION_LOCATION)
                .load()
                .migrate();
    }
}
