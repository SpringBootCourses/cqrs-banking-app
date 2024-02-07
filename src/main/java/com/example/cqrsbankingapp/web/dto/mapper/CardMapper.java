package com.example.cqrsbankingapp.web.dto.mapper;

import com.example.cqrsbankingapp.domain.model.Card;
import com.example.cqrsbankingapp.web.dto.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
}
