package com.example.core.service.event;

import com.example.core.events.AbstractEvent;
import com.example.core.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Override
    public void create(
            final AbstractEvent event
    ) {
        repository.save(event);
    }

}
