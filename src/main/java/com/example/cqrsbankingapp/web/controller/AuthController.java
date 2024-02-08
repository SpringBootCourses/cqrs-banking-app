package com.example.cqrsbankingapp.web.controller;

import com.example.cqrsbankingapp.domain.model.Client;
import com.example.cqrsbankingapp.service.auth.AuthService;
import com.example.cqrsbankingapp.web.dto.ClientDto;
import com.example.cqrsbankingapp.web.dto.LoginRequestDto;
import com.example.cqrsbankingapp.web.dto.LoginResponseDto;
import com.example.cqrsbankingapp.web.dto.OnCreate;
import com.example.cqrsbankingapp.web.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
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
            @RequestBody @Validated(OnCreate.class) final LoginRequestDto dto
    ) {
        return authService.login(dto);
    }

}
