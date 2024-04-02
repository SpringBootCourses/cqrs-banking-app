package com.example.eventhandler.service.transaction;

import com.example.common.domain.model.Transaction;
import com.example.common.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    @Override
    public Transaction create(
            final Transaction transaction
    ) {
        //TODO change balance of card accounts
        return repository.save(transaction);
    }

}
