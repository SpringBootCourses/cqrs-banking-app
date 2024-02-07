package com.example.cqrsbankingapp.service.account;

import com.example.cqrsbankingapp.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountQueryService queryService;

    @Override
    public Account getById(
            final UUID id
    ) {
        return queryService.getById(id);
    }

}
