package com.example.core.service.transaction;

import com.example.core.domain.exception.ResourceNotFoundException;
import com.example.core.domain.model.Transaction;
import com.example.core.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService {

    private final TransactionRepository repository;

    @Override
    public Transaction getById(
            final UUID id
    ) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

}
