package com.example.core.web.dto.mapper;

import com.example.common.domain.model.Client;
import com.example.core.web.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}
