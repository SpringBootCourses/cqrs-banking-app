package com.example.eventhandler.service.card;

import com.example.common.domain.model.Card;
import com.example.common.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public Card create(
            final Card card
    ) {
        return cardRepository.save(card);
    }

}
