package com.example.core.service.card;

import com.example.common.domain.model.Card;
import com.example.core.service.QueryService;

public interface CardQueryService extends QueryService<Card> {

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
