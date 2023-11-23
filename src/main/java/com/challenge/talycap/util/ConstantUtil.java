package com.challenge.talycap.util;

import com.challenge.talycap.business.dto.ClientDto;
import com.challenge.talycap.infrastructure.entity.Client;

public class ConstantUtil {

   public static final String CONTEXT_CLIENT = "/client";

   public static final String CONTEXT_HELLO_WORLD = "/hola";

   public static final String CONTEXT_FACTORIAL = "/factorial";

   public static final ClientDto CLIENT_DTO = ClientDto
         .builder()
         .firstName("Andres")
         .secondName("Felipe")
         .surname("Mendez")
         .secondSurname("Garcia")
         .phone("3144440515")
         .address("Cra 100A #1212 -21")
         .city("Bogotá")
         .build();

   public static final Client CLIENT_ENTITY = Client
         .builder()
         .firstName("Andres")
         .secondName("Felipe")
         .surname("Mendez")
         .secondSurname("Garcia")
         .phone("3144440515")
         .address("Cra 100A #1212 -21")
         .city("Bogotá")
         .build();

}
