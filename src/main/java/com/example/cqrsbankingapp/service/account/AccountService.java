package com.example.cqrsbankingapp.service.account;

import com.example.cqrsbankingapp.domain.model.Account;
import com.example.cqrsbankingapp.service.CommandService;
import com.example.cqrsbankingapp.service.QueryService;

public interface AccountService
        extends CommandService<Account>, QueryService<Account> {

}
