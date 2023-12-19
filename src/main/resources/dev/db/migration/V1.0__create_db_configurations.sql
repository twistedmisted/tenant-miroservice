CREATE TABLE db_configurations
(
    tenant_id VARCHAR(50),
    name      VARCHAR(50)   NOT NULL,
    url       VARCHAR(2083) NOT NULL,
    username  VARCHAR(32)   NOT NULL,
    password  VARCHAR(32)   NOT NULL
);

ALTER TABLE db_configurations
    ADD CONSTRAINT pk_db_configurations PRIMARY KEY (tenant_id);