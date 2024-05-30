package com.example.core.service.account;

import com.example.common.domain.model.Account;
import com.example.core.service.CommandService;
import com.example.common.service.QueryService;

public interface AccountService
        extends QueryService<Account>, CommandService<Account> {

}
