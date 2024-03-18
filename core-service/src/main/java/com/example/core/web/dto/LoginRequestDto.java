package com.example.core.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {

    @NotNull(
            message = "Username must be not null."
    )
    private String username;

    @NotNull(
            message = "Password must be not null."
    )
    private String password;

}
