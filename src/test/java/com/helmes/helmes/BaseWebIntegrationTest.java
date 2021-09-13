package com.helmes.helmes;

import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@BaseIntegrationTest
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = {HelmesApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public @interface BaseWebIntegrationTest {
}
