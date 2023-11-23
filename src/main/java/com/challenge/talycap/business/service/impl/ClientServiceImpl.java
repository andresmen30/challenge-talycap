package com.challenge.talycap.business.service.impl;

import org.springframework.stereotype.Service;

import com.challenge.talycap.api.exception.RecordNotFoundException;
import com.challenge.talycap.business.dto.ClientDto;
import com.challenge.talycap.business.mapper.ClientMapper;
import com.challenge.talycap.business.service.ClientService;
import com.challenge.talycap.infrastructure.entity.Client;
import com.challenge.talycap.infrastructure.repository.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

   private final ClientRepository clientRepository;

   private final ClientMapper clientMapper;

   @Override
   public ClientDto getByIdentAndTypeDoc(final String ident, final String typeDoc) {
      final Client client = clientRepository.getByIdentAndTypeDoc(ident, typeDoc).orElseThrow(() -> new RecordNotFoundException(ident, typeDoc));
      return clientMapper.toDto(client);
   }
}
