package com.example.cqrsbankingapp.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class TransactionDto {

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
    private CardDto from;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private CardDto to;

    private BigDecimal amount;

}
