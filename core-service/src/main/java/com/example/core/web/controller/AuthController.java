package com.example.core.web.controller;

import com.example.common.domain.model.Client;
import com.example.core.service.auth.AuthService;
import com.example.core.web.dto.ClientDto;
import com.example.core.web.dto.LoginRequestDto;
import com.example.core.web.dto.LoginResponseDto;
import com.example.core.web.dto.OnCreate;
import com.example.core.web.dto.mapper.ClientMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final AuthService authService;
    private final ClientMapper clientMapper;

    @PostMapping("/register")
    public void register(
            @RequestBody @Validated(OnCreate.class) final ClientDto dto
    ) {
        Client client = clientMapper.fromDto(dto);
        authService.register(client);
    }

    @PostMapping("/login")
    public LoginResponseDto login(
            @RequestBody @Valid final LoginRequestDto dto
    ) {
        return authService.login(dto);
    }

}
