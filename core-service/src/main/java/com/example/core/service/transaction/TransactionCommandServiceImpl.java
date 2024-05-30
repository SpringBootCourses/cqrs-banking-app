package com.example.core.service.transaction;

import com.example.common.domain.model.Card;
import com.example.common.domain.model.Transaction;
import com.example.common.events.TransactionCreateEvent;
import com.example.core.service.card.CardService;
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
    private final CardService cardService;

    @Override
    public void create(
            final Transaction object
    ) {
        Card from = cardService.getByNumberAndDateAndCvv(
                object.getFrom().getNumber(),
                object.getFrom().getDate(),
                object.getFrom().getCvv()
        );
        Card to = cardService.getByNumberAndDate(
                object.getTo().getNumber(),
                object.getTo().getDate()
        );
        object.setFrom(from);
        object.setTo(to);
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }

}
