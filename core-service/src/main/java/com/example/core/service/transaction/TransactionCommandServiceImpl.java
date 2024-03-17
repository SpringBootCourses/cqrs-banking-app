package com.example.core.service.transaction;

import com.example.core.domain.model.Transaction;
import com.example.core.events.TransactionCreateEvent;
import com.example.core.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionCommandServiceImpl
        implements TransactionCommandService {

    private final EventService eventService;

    @Override
    public void create(
            final Transaction object
    ) {
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }

}
