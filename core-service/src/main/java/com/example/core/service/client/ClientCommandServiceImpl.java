package com.example.core.service.client;

import com.example.core.domain.model.Client;
import com.example.core.events.ClientCreateEvent;
import com.example.core.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientCommandServiceImpl implements ClientCommandService {

    private final EventService eventService;

    @Override
    public void create(
            final Client object
    ) {
        ClientCreateEvent event = new ClientCreateEvent(object);
        eventService.create(event);
    }

}
