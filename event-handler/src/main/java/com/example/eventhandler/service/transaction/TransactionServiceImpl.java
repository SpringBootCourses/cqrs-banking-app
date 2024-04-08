package com.example.eventhandler.service.transaction;

import com.example.common.domain.model.Card;
import com.example.common.domain.model.Transaction;
import com.example.common.repository.TransactionRepository;
import com.example.eventhandler.service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final CardService cardService;

    @Override
    @Transactional
    public Transaction create(
            final Transaction transaction
    ) {
        Card cardFrom = cardService.getById(transaction.getFrom().getId());
        Card cardTo = cardService.getById(transaction.getTo().getId());
        checkBalance(cardFrom, transaction.getAmount());
        cardService.add(cardFrom, transaction.getAmount().negate());
        cardService.add(cardTo, transaction.getAmount());
        return repository.save(transaction);
    }

    private void checkBalance(
            final Card card,
            final BigDecimal amount
    ) {
        if (card.getAccount().getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Not enough money on card account.");
        }
    }

}
