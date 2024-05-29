package com.example.eventhandler.handler;

import com.example.common.domain.model.Card;
import com.example.common.events.CardCreateEvent;
import com.example.eventhandler.service.card.CardService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component("CARD_CREATE")
@RequiredArgsConstructor
public class CardCreateEventHandler implements EventHandler {

    private final CardService cardService;
    private final Gson gson;

    @Override
    public void handle(
            final JsonObject object,
            final Acknowledgment acknowledgment
    ) {
        CardCreateEvent event = gson.fromJson(
                object,
                CardCreateEvent.class
        );
        Card card = gson.fromJson(
                (String) event.getPayload(),
                Card.class
        );
        cardService.create(card);
        //TODO add card to client
//        clientService.addCard(card.getAccount().getId(), card.getId());
        acknowledgment.acknowledge();
    }

}
