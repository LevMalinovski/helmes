package com.helmes.helmes;

import org.junit.ClassRule;
import org.testcontainers.containers.PostgreSQLContainer;

public abstract class BaseIntegrationTestWithDb {

    @ClassRule
    protected PostgreSQLContainer<CorePostgreSQLContainer> postgreSQLContainer = CorePostgreSQLContainer.getInstance();
}
