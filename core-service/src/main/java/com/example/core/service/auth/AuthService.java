package com.example.core.service.auth;

import com.example.common.domain.model.Client;
import com.example.core.web.dto.LoginRequestDto;
import com.example.core.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto request);

    void register(Client client);

}
