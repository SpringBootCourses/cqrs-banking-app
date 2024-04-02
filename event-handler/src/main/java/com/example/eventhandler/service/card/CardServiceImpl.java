package com.example.eventhandler.service.card;

import com.example.common.domain.model.Card;
import com.example.common.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository repository;

    @Override
    public Card create(
            final Card card
    ) {
        //TODO set date cvv and number
        return repository.save(card);
    }

}
