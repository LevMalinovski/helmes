package com.helmes.helmes.web.mvc.controller;

import com.helmes.helmes.BaseIntegrationTestWithDb;
import com.helmes.helmes.BaseWebIntegrationTest;
import com.helmes.helmes.dto.CategoryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static com.helmes.helmes.web.mvc.controller.WebConstants.API_CATEGORY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.HttpStatus.OK;

@SpringJUnitConfig
@BaseWebIntegrationTest
class CategoryControllerIntegrationTest extends BaseIntegrationTestWithDb {

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturnList() {
        ResponseEntity<CategoryDto[]> response = testRestTemplate
                .getForEntity(
                        API_CATEGORY,
                        CategoryDto[].class
                );
        assertEquals(OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}