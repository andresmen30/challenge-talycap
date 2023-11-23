package com.challenge.talycap.business.mapper;

import org.mapstruct.Mapper;

import com.challenge.talycap.business.dto.ClientDto;
import com.challenge.talycap.infrastructure.entity.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {

   ClientDto toDto(final Client entity);

}
