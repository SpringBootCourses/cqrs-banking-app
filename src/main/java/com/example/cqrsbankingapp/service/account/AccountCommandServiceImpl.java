package com.example.cqrsbankingapp.service.account;

import com.example.cqrsbankingapp.domain.model.Account;
import com.example.cqrsbankingapp.events.AccountCreateEvent;
import com.example.cqrsbankingapp.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {

    private final EventService eventService;

    @Override
    public void create(
            final Account object
    ) {
        AccountCreateEvent event = new AccountCreateEvent(object);
        eventService.create(event);
    }

}
