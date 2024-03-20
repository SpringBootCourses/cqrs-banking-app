package com.example.eventhandler.handler;

import com.example.common.domain.model.Transaction;
import com.example.common.events.TransactionCreateEvent;
import com.example.eventhandler.service.transaction.TransactionService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("TRANSACTION_CREATE")
@RequiredArgsConstructor
public class TransactionCreateEventHandler implements EventHandler {

    private final TransactionService transactionService;

    @Override
    public void handle(
            final JsonObject object
    ) {
        Gson gson = new Gson();
        TransactionCreateEvent event = gson.fromJson(
                object,
                TransactionCreateEvent.class
        );
        Transaction transaction = (Transaction) event.getPayload();
        transactionService.create(transaction);
    }

}
