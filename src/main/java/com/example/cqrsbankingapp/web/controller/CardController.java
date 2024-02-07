package com.example.cqrsbankingapp.web.controller;

import com.example.cqrsbankingapp.domain.model.Card;
import com.example.cqrsbankingapp.service.card.CardService;
import com.example.cqrsbankingapp.web.dto.CardDto;
import com.example.cqrsbankingapp.web.dto.TransactionDto;
import com.example.cqrsbankingapp.web.dto.mapper.CardMapper;
import com.example.cqrsbankingapp.web.dto.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create() {
        //TODO take client from token
        UUID userId = UUID.randomUUID();
        cardService.createByClientId(userId);
    }

    @GetMapping("/{id}")
    public CardDto getById(
            @PathVariable UUID id
    ) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{id}/transactions")
    public List<TransactionDto> getTransactionsById(
            @PathVariable UUID id
    ) {
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());
    }

}
