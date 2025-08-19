package com.williamfernandez.foro_hub.controller;

import com.williamfernandez.foro_hub.dto.LoginRequest;
import com.williamfernandez.foro_hub.security.jwt.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;

    public AuthController(AuthenticationManager authManager, TokenService tokenService) {
        this.authManager = authManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request) {
        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.username(), request.password())
            );

            String token = tokenService.generarToken(request.username());
            return ResponseEntity.ok(token);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }
    }
}