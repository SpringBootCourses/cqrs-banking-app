package com.example.cqrsbankingapp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class MessageDto {

    private String message;
    private Map<String, String> errors;

    public MessageDto(
            final String message
    ) {
        this.message = message;
        this.errors = new HashMap<>();
    }

}
