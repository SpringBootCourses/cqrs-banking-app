package com.example.cqrsbankingapp.service.card;

import com.example.cqrsbankingapp.domain.model.Card;
import com.example.cqrsbankingapp.service.QueryService;

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

}
