package com.challenge.talycap.business.mapper;

import com.challenge.talycap.business.dto.ClientDto;
import com.challenge.talycap.infrastructure.entity.Client;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-23T02:06:43-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto toDto(Client entity) {
        if ( entity == null ) {
            return null;
        }

        ClientDto.ClientDtoBuilder clientDto = ClientDto.builder();

        clientDto.firstName( entity.getFirstName() );
        clientDto.secondName( entity.getSecondName() );
        clientDto.surname( entity.getSurname() );
        clientDto.secondSurname( entity.getSecondSurname() );
        clientDto.phone( entity.getPhone() );
        clientDto.address( entity.getAddress() );
        clientDto.city( entity.getCity() );

        return clientDto.build();
    }
}
