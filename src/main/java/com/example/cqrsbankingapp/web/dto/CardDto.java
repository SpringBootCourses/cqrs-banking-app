package com.example.cqrsbankingapp.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
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

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String number;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String date;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String cvv;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<TransactionDto> transactions;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private AccountDto account;

}
