package com.challenge.talycap.business.service.impl;

import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.challenge.talycap.api.exception.RecordNotFoundException;
import com.challenge.talycap.business.dto.ClientDto;
import com.challenge.talycap.business.mapper.ClientMapper;
import com.challenge.talycap.infrastructure.entity.Client;
import com.challenge.talycap.infrastructure.repository.ClientRepository;
import com.challenge.talycap.util.ConstantUtil;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

   @InjectMocks
   private ClientServiceImpl clientService;

   @Mock
   private ClientRepository clientRepository;

   @Mock
   private ClientMapper clientMapper;

   @Test
   @DisplayName("test get client ByIdentAndTypeDoc")
   void getByIdentAndTypeDoc() {
      final Client client = ConstantUtil.CLIENT_ENTITY;
      given(clientRepository.getByIdentAndTypeDoc("23445322", "C")).willReturn(Optional.of(client));
      given(clientMapper.toDto(client)).willReturn(ConstantUtil.CLIENT_DTO);
      final ClientDto result = clientService.getByIdentAndTypeDoc("23445322", "C");
      assertThat(result).isNotNull();

   }

   @Test
   @DisplayName("test get client RecordNotFound 404")
   void recordNotFound() {
      given(clientRepository.getByIdentAndTypeDoc("1234", "C")).willReturn(Optional.empty());
      assertThrows(RecordNotFoundException.class, () -> clientService.getByIdentAndTypeDoc("1234", "C"));

   }
}