package com.example.eventhandler.handler;

import com.example.common.domain.model.Card;
import com.example.common.events.CardCreateEvent;
import com.example.eventhandler.service.card.CardService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("CARD_CREATE")
@RequiredArgsConstructor
public class CardCreateEventHandler implements EventHandler {

    private final CardService cardService;

    @Override
    public void handle(
            final JsonObject object
    ) {
        Gson gson = new Gson();
        CardCreateEvent event = gson.fromJson(
                object,
                CardCreateEvent.class
        );
        Card card = (Card) event.getPayload();
        cardService.create(card);
    }

}
