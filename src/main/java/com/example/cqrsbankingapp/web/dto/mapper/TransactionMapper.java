package com.example.cqrsbankingapp.web.dto.mapper;

import com.example.cqrsbankingapp.domain.model.Transaction;
import com.example.cqrsbankingapp.web.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper
        extends Mappable<Transaction, TransactionDto> {
}
