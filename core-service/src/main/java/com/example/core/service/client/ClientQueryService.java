package com.example.core.service.client;

import com.example.common.domain.model.Client;
import com.example.core.service.QueryService;

public interface ClientQueryService extends QueryService<Client> {

    Client getByUsername(String username);

    boolean existsByUsername(String username);

}
