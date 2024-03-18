package com.example.core.web.dto.mapper;

import com.example.common.domain.model.Card;
import com.example.core.web.dto.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
}
