package com.example.eventhandler.handler;

import com.example.common.domain.model.Client;
import com.example.common.events.ClientCreateEvent;
import com.example.eventhandler.service.client.ClientService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component("CLIENT_CREATE")
@RequiredArgsConstructor
public class ClientCreateEventHandler implements EventHandler {

    private final ClientService clientService;
    private final Gson gson;

    @Override
    public void handle(
            final JsonObject object,
            final Acknowledgment acknowledgment
    ) {
        ClientCreateEvent event = gson.fromJson(
                object,
                ClientCreateEvent.class
        );
        Client client = (Client) event.getPayload();
        clientService.create(client);
        acknowledgment.acknowledge();
    }

}
