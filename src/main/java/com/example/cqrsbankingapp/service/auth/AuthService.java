package com.example.cqrsbankingapp.service.auth;

import com.example.cqrsbankingapp.domain.model.Client;
import com.example.cqrsbankingapp.web.dto.LoginRequestDto;
import com.example.cqrsbankingapp.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto request);

    void register(Client client);

}
