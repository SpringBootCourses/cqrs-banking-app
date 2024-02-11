package com.example.cqrsbankingapp.service.event;

import com.example.cqrsbankingapp.events.AbstractEvent;

public interface EventService {

    void create(AbstractEvent event);

}
