package com.example.core.web.security.service;

import com.example.common.domain.model.Card;
import com.example.core.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(UUID clientId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessCard(Card card);

    boolean canAccessTransaction(UUID transactionId);

}
