package com.example.core.service.transaction;

import com.example.common.domain.model.Transaction;
import com.example.common.service.transaction.TransactionQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionQueryService queryService;
    private final TransactionCommandService commandService;

    @Override
    public void create(
            final Transaction object
    ) {
        commandService.create(object);
    }

    @Override
    public Transaction getById(
            final UUID id
    ) {
        return queryService.getById(id);
    }

}
