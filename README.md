# Tenant Management Microservice

This microservice is designed for managing tenants and offers three primary endpoints: GET (retrieve tenant by ID), POST (create a new tenant), and DELETE (delete tenant by ID). It supports Flyway migration during the creation of a new tenant and retrieves all existing tenants from the database during startup, applying new migrations if they exist.

## Technologies Used

- **Java with Spring Boot:** Handles the logic and functionality.
- **MongoDB:** Chosen as the master database for storing all tenants.

### Reasons for Choosing MongoDB

1. **Schema Flexibility:** MongoDB's flexible schema allows easy adaptation to changes and diverse data structures, ideal for tenant management where requirements might evolve.
2. **Scalability:** It offers horizontal scalability, accommodating the potential growth of tenants without compromising performance.

## Endpoints

### GET /api/v1/db-configurations/{tenantID}

Retrieve a specific tenant by ID.

### POST /api/v1/db-configurations

Create a new tenant. Flyway migration is triggered during creation.

### DELETE /api/v1/db-configurations/{tenantID}

Delete a tenant by ID.

## Initialization

During startup, this microservice automatically:

1. Retrieves all existing tenants from the MongoDB database.
2. Applies new migrations, if any, to the database.

## Setup

### Prerequisites

- Docker

### Running the Microservice

1. Clone the repository.
2. Navigate to the project directory.
3. Run `docker-compose up` to start the Java microservice and MongoDB containers.

## Usage

Once the microservice is up and running, you can interact with it through the specified endpoints using tools like cURL or Postman.

### Example:

#### Create a New Tenant:

```bash
curl -X POST http://localhost:PORT/api/v1/db-configurations -d '{
    "tenantId": "Tenant_1",
    "url": "jdbc:mysql://localhost:3306/",
    "name": "Tenant_1",
    "username": "admin",
    "password": "password"
}'
