package com.example.core.web.dto.mapper;

import com.example.common.domain.model.Transaction;
import com.example.core.web.dto.TransactionDto;
import org.mapstruct.Mapper;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING,
        uses = CardMapper.class,
        injectionStrategy = CONSTRUCTOR
)
public interface TransactionMapper
        extends Mappable<Transaction, TransactionDto> {
}
