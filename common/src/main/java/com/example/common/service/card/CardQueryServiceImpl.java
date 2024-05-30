package com.example.common.service.card;

import com.example.common.domain.exception.ResourceNotFoundException;
import com.example.common.domain.model.Card;
import com.example.common.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardQueryServiceImpl implements CardQueryService {

    private final CardRepository repository;

    @Override
    public Card getById(
            final UUID id
    ) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByNumberAndDate(
            final String number,
            final String date
    ) {
        return repository.existsByNumberAndDate(number, date);
    }

    @Override
    public Card getByNumberAndDateAndCvv(
            final String number,
            final String date,
            final String cvv
    ) {
        return repository.findByNumberAndDateAndCvv(number, date, cvv)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Card getByNumberAndDate(
            final String number,
            final String date
    ) {
        return repository.findByNumberAndDate(number, date)
                .orElseThrow(ResourceNotFoundException::new);
    }

}
