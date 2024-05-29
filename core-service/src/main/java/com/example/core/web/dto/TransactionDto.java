package com.example.core.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import jakarta.validation.groups.ConvertGroup;
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

    @NotNull(
            message = "Sender card must be not null.",
            groups = OnCreate.class
    )
    @Valid
    @ConvertGroup(from = OnCreate.class, to = OnTransactionFrom.class)
    private CardDto from;

    @NotNull(
            message = "Receiver card must be not null.",
            groups = OnCreate.class
    )
    @Valid
    @ConvertGroup(from = OnCreate.class, to = OnTransactionTo.class)
    private CardDto to;

    @NotNull(
            message = "Amount must be not null.",
            groups = OnCreate.class
    )
    @Positive(
            message = "Amount must be positive.",
            groups = OnCreate.class
    )
    private BigDecimal amount;

}
