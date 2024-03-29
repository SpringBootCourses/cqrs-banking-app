package com.example.core.service.transaction;

import com.example.core.domain.model.Transaction;
import com.example.core.service.CommandService;
import com.example.core.service.QueryService;

public interface TransactionService
        extends CommandService<Transaction>, QueryService<Transaction> {
}
