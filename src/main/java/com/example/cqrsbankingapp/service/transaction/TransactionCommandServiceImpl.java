package com.example.cqrsbankingapp.service.transaction;

import com.example.cqrsbankingapp.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionCommandServiceImpl
        implements TransactionCommandService {

    @Override
    public void create(Transaction object) {
        //TODO implement
    }

}
