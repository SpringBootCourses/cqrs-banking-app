package com.example.core.web.dto.mapper;

import com.example.common.domain.model.Account;
import com.example.core.web.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}
