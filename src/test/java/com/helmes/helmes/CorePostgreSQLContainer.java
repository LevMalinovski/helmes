package com.helmes.helmes;

import org.springframework.stereotype.Component;
import org.testcontainers.containers.PostgreSQLContainer;

@Component
public class CorePostgreSQLContainer extends PostgreSQLContainer<CorePostgreSQLContainer> {

    private static final String IMAGE_VERSION = "postgres:11.11";

    private static CorePostgreSQLContainer container;

    private CorePostgreSQLContainer() {
        super(IMAGE_VERSION);
    }

    public static CorePostgreSQLContainer getInstance() {
        if (container == null) {
            container = new CorePostgreSQLContainer();
            container.withReuse(true);
            container.start();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}

