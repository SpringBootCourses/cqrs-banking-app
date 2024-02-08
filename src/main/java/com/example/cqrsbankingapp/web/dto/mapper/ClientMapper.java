package com.example.cqrsbankingapp.web.dto.mapper;

import com.example.cqrsbankingapp.domain.model.Client;
import com.example.cqrsbankingapp.web.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}
