package com.example.cqrsbankingapp.web.security.service;

import com.example.cqrsbankingapp.domain.model.Card;
import com.example.cqrsbankingapp.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(UUID clientId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessCard(Card card);

    boolean canAccessTransaction(UUID transactionId);

}
