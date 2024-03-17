package com.example.core.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CardDto {

    @NotNull(
            message = "Id must be not null.",
            groups = OnUpdate.class
    )
    @Null(
            message = "Id must be null.",
            groups = OnCreate.class
    )
    private UUID id;

    @NotNull(
            message = "Number must be not null.",
            groups = OnCreate.class
    )
    @Null(message = "Number must be null.")
    private String number;

    @NotNull(
            message = "Date must be not null.",
            groups = OnCreate.class
    )
    @Null(message = "Date must be null.")
    private String date;

    @NotNull(
            message = "Cvv must be not null.",
            groups = OnCreate.class
    )
    @Null(message = "Cvv must be null.")
    private String cvv;

}
