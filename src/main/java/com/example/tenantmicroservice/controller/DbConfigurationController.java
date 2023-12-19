package com.example.tenantmicroservice.controller;

import com.example.tenantmicroservice.model.dto.DbConfigurationDto;
import com.example.tenantmicroservice.model.payload.CreateDbConfig;
import com.example.tenantmicroservice.service.facade.DbConfigurationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/db-configurations")
@RequiredArgsConstructor
public class DbConfigurationController {

    private final DbConfigurationFacade dbConfFacade;

    @GetMapping("/{tenantId}")
    public ResponseEntity<DbConfigurationDto> getDbConfByTenantId(@PathVariable String tenantId) {
        if (tenantId.equals("public")) {
            tenantId = "Tenant_1";
        }
        return new ResponseEntity<>(dbConfFacade.getByTenantId(tenantId), OK);
    }

    @PostMapping
    public ResponseEntity<?> saveTenant(@RequestBody CreateDbConfig dbConfig) {
        dbConfFacade.createDbConfig(dbConfig);
        return new ResponseEntity<>(CREATED);
    }

    @DeleteMapping("/{tenantId}")
    public ResponseEntity<?> deleteTenant(@PathVariable String tenantId) {
        dbConfFacade.deleteTenant(tenantId);
        return new ResponseEntity<>(OK);
    }
}
