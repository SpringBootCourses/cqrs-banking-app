package com.example.core.web.security.service;

import com.example.core.web.dto.CardDto;
import com.example.core.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(UUID clientId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessCard(CardDto card);

    boolean canAccessTransaction(UUID transactionId);

}
