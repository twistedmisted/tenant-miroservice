db.createUser(
    {
        user: "mongouser",
        pwd: "password",
        roles: [
            {
                role: "readWrite",
                db: "Tenants"
            }
        ]
    }
);