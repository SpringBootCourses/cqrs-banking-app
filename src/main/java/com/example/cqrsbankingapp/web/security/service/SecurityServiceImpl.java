package com.example.cqrsbankingapp.web.security.service;

import com.example.cqrsbankingapp.domain.exception.ResourceNotFoundException;
import com.example.cqrsbankingapp.domain.model.Card;
import com.example.cqrsbankingapp.domain.model.Client;
import com.example.cqrsbankingapp.domain.model.Transaction;
import com.example.cqrsbankingapp.service.card.CardService;
import com.example.cqrsbankingapp.service.client.ClientService;
import com.example.cqrsbankingapp.service.transaction.TransactionService;
import com.example.cqrsbankingapp.web.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("ssi")
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final ClientService clientService;
    private final CardService cardService;
    private final TransactionService transactionService;

    @Override
    public SecurityUser getUserFromRequest() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if (!authentication.isAuthenticated()) {
            return null;
        }
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return null;
        }
        return (SecurityUser) authentication
                .getPrincipal();
    }

    @Override
    public boolean canAccessClient(
            final UUID clientId
    ) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        return clientId.equals(id);
    }

    @Override
    public boolean canAccessCard(
            final UUID cardId
    ) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        Client client = clientService.getById(id);
        return client.getCards().stream()
                .anyMatch(card -> card.getId().equals(cardId));
    }

    @Override
    public boolean canAccessCard(
            final Card card
    ) {
        try {
            Card foundCard = cardService.getByNumberAndDateAndCvv(
                    card.getNumber(),
                    card.getDate(),
                    card.getCvv()
            );
            return canAccessCard(foundCard.getId());
        } catch (ResourceNotFoundException e) {
            return false;
        }
    }

    @Override
    public boolean canAccessTransaction(
            final UUID transactionId
    ) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        Client client = clientService.getById(id);
        Transaction transaction = transactionService.getById(transactionId);
        return client.getCards().contains(transaction.getFrom())
                || client.getCards().contains(transaction.getTo());
    }

}
