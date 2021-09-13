package com.helmes.helmes.web.mvc.controller;

import com.helmes.helmes.dto.ApplicationCreateDto;
import com.helmes.helmes.dto.ApplicationDto;
import com.helmes.helmes.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

import static com.helmes.helmes.web.mvc.controller.WebConstants.API_APPLICATION;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(API_APPLICATION)
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<ApplicationDto> create(@Valid @RequestBody ApplicationCreateDto dto, HttpServletRequest request) {
        return ResponseEntity.ok().body(applicationService.create(dto, request.getHeader("token")));
    }

    @GetMapping("")
    public ResponseEntity<List<ApplicationDto>> getApplications(HttpServletRequest request) {
        return ResponseEntity.ok().body(applicationService.getAllByToken(request.getHeader("token")));
    }

    @PutMapping
    public ResponseEntity<ApplicationDto> update(@Valid @RequestBody ApplicationDto dto, HttpServletRequest request) {
        return ResponseEntity.ok().body(applicationService.update(dto, request.getHeader("token")));
    }
}
