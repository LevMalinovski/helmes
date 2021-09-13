package com.helmes.helmes.web.mvc.controller;

import com.helmes.helmes.BaseIntegrationTestWithDb;
import com.helmes.helmes.BaseWebIntegrationTest;
import com.helmes.helmes.dto.ApplicationCreateDto;
import com.helmes.helmes.dto.ApplicationDto;
import com.helmes.helmes.model.repository.ApplicationRepository;
import com.helmes.helmes.service.Token;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.helmes.helmes.web.mvc.controller.WebConstants.API_APPLICATION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@SpringJUnitConfig
@BaseWebIntegrationTest
@AutoConfigureMockMvc
class ApplicationControllerIntegrationTest extends BaseIntegrationTestWithDb {

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Token tokenService;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Test
    public void shouldCreate() {
        String token = tokenService.generateNewToken();
        ApplicationCreateDto dto = ApplicationCreateDto.builder()
                .name("Test")
                .terms(true)
                .categories(List.of(1L))
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);
        HttpEntity<ApplicationCreateDto> request = new HttpEntity<>(dto, headers);
        ResponseEntity<ApplicationDto> response = testRestTemplate.postForEntity(API_APPLICATION, request, ApplicationDto.class);
        assertEquals(OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void shouldNotCreateWithInvalidCategory() {
        ApplicationCreateDto dto = ApplicationCreateDto.builder()
                .name("Test")
                .terms(true)
                .categories(List.of(99999L))
                .build();
        String token = tokenService.generateNewToken();
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);
        HttpEntity<ApplicationCreateDto> request = new HttpEntity<>(dto, headers);
        ResponseEntity<ApplicationDto> response = testRestTemplate.postForEntity(API_APPLICATION, request, ApplicationDto.class);
        assertEquals(INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void shouldReturnList() {
        String token = tokenService.generateNewToken();
        createApplication(token);
        createApplication("invalid-token");
        ResponseEntity<ApplicationDto[]> response = testRestTemplate.exchange(
                API_APPLICATION,
                GET,
                createHeaders(token),
                ApplicationDto[].class
        );
        assertEquals(OK, response.getStatusCode());
        ApplicationDto[] list = response.getBody();
        assertEquals(1, list.length);
        var dto = list[0];
        assertEquals("Test", dto.getName());
    }

    @Test
    public void shouldUpdate() {
        String token = tokenService.generateNewToken();
        ApplicationDto dto = createApplication(token);
        dto.setName("New name");
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);
        HttpEntity<ApplicationDto> request = new HttpEntity<>(dto, headers);
        ResponseEntity<ApplicationDto> response = testRestTemplate.exchange(
                API_APPLICATION,
                PUT,
                request,
                ApplicationDto.class
        );
        assertEquals(OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("New name", response.getBody().getName());
    }

    private ApplicationDto createApplication(String token) {
        ApplicationCreateDto dto = ApplicationCreateDto.builder()
                .name("Test")
                .terms(true)
                .categories(List.of(1L))
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);
        HttpEntity<ApplicationCreateDto> request = new HttpEntity<>(dto, headers);
        ResponseEntity<ApplicationDto> response = testRestTemplate.postForEntity(API_APPLICATION, request, ApplicationDto.class);
        return response.getBody();
    }

    private HttpEntity<ApplicationCreateDto> createHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);
        return new HttpEntity<>(headers);
    }
}