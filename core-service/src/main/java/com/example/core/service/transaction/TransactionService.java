package com.example.core.service.transaction;

import com.example.common.domain.model.Transaction;
import com.example.core.service.CommandService;
import com.example.common.service.QueryService;

public interface TransactionService
        extends CommandService<Transaction>, QueryService<Transaction> {
}
