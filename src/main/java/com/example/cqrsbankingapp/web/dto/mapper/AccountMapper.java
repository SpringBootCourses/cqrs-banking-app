package com.example.cqrsbankingapp.web.dto.mapper;

import com.example.cqrsbankingapp.domain.model.Account;
import com.example.cqrsbankingapp.web.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}
