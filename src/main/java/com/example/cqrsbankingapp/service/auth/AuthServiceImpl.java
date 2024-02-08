package com.example.cqrsbankingapp.service.auth;

import com.example.cqrsbankingapp.domain.model.Client;
import com.example.cqrsbankingapp.service.client.ClientService;
import com.example.cqrsbankingapp.web.dto.LoginRequestDto;
import com.example.cqrsbankingapp.web.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ClientService clientService;

    @Override
    public LoginResponseDto login(
            final LoginRequestDto request
    ) {
        //TODO implement
        return null;
    }

    @Override
    public void register(
            final Client client
    ) {
        //TODO check by existence of username
        //TODO set hashed password
        clientService.create(client);
    }

}
