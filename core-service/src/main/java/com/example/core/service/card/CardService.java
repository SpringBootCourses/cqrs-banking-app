package com.example.core.service.card;

import com.example.common.domain.model.Card;
import com.example.core.service.CommandService;
import com.example.common.service.QueryService;

import java.util.UUID;

public interface CardService
        extends CommandService<Card>, QueryService<Card> {

    void createByClientId(UUID clientId);

    boolean existsByNumberAndDate(
            String number,
            String date
    );

    Card getByNumberAndDateAndCvv(
            String number,
            String date,
            String cvv
    );

    Card getByNumberAndDate(
            String number,
            String date
    );

}
