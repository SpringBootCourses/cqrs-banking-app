package com.example.cqrsbankingapp.service.card;

import com.example.cqrsbankingapp.domain.model.Card;
import com.example.cqrsbankingapp.events.CardCreateEvent;
import com.example.cqrsbankingapp.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CardCommandServiceImpl implements CardCommandService {

    private final EventService eventService;

    @Override
    public void create(
            final Card object
    ) {
        CardCreateEvent event = new CardCreateEvent(object);
        eventService.create(event);
    }

}
