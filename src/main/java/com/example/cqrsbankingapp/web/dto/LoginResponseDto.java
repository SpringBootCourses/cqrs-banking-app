package com.example.cqrsbankingapp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDto {

    private UUID id;
    private String access;
    private String refresh;

}
