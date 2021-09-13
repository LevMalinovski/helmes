package com.helmes.helmes.web.mvc.controller;

import com.helmes.helmes.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.helmes.helmes.web.mvc.controller.WebConstants.API_TOKEN;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(API_TOKEN)
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("")
    public ResponseEntity<?> create() {
        return ResponseEntity.ok().body(tokenService.generateNewToken());
    }
}
