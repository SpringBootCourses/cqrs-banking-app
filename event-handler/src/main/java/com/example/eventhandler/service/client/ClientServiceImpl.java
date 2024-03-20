package com.example.eventhandler.service.client;

import com.example.common.domain.model.Account;
import com.example.common.domain.model.Client;
import com.example.common.repository.ClientRepository;
import com.example.eventhandler.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final AccountService accountService;

    @Override
    public Client create(
            final Client client
    ) {
        Account account = new Account();
        account = accountService.create(account);
        client.setAccount(account);
        return clientRepository.save(client);
    }

}
