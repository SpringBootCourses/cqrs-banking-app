package com.example.eventhandler.handler;

import com.example.common.domain.model.Account;
import com.example.common.events.AccountCreateEvent;
import com.example.eventhandler.service.account.AccountService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("ACCOUNT_CREATE")
@RequiredArgsConstructor
public class AccountCreateEventHandler implements EventHandler {

    private final AccountService accountService;

    @Override
    public void handle(
            final JsonObject object
    ) {
        Gson gson = new Gson();
        AccountCreateEvent event = gson.fromJson(
                object,
                AccountCreateEvent.class
        );
        Account account = (Account) event.getPayload();
        accountService.create(account);
    }

}
