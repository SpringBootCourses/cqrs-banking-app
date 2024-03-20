package com.example.eventhandler.handler;

import com.example.common.domain.model.Transaction;
import com.example.common.events.TransactionCreateEvent;
import com.example.eventhandler.service.transaction.TransactionService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component("TRANSACTION_CREATE")
@RequiredArgsConstructor
public class TransactionCreateEventHandler implements EventHandler {

    private final TransactionService transactionService;
    private final Gson gson;

    @Override
    public void handle(
            final JsonObject object,
            final Acknowledgment acknowledgment
    ) {
        TransactionCreateEvent event = gson.fromJson(
                object,
                TransactionCreateEvent.class
        );
        Transaction transaction = (Transaction) event.getPayload();
        transactionService.create(transaction);
        acknowledgment.acknowledge();
    }

}
