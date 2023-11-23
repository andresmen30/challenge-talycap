package com.challenge.talycap.api.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.challenge.talycap.business.service.ClientService;
import com.challenge.talycap.util.ConstantUtil;

@WebMvcTest(ClientController.class)
class ClientControllerTest {

   @Autowired
   private MockMvc mockMvc;

   @MockBean
   private ClientService clientService;

   @Test
   @DisplayName("Test getByIdentAndTypeDoc OK 200")
   void getByIdentAndTypeDoc() throws Exception {
      Mockito.when(clientService.getByIdentAndTypeDoc("23445322", "C")).thenReturn(ConstantUtil.CLIENT_DTO);
      this.mockMvc
            .perform(get(ConstantUtil.CONTEXT_CLIENT)
                  .queryParam("identification", "23445322")
                  .queryParam("type_doc", "C")
                  .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.time", Matchers.notNullValue()))
            .andExpect(jsonPath("$.message", is(HttpStatus.OK.name())))
            .andExpect(jsonPath("$.data", Matchers.notNullValue()));
   }

   @Test
   @DisplayName("Test getByIdentAndTypeDoc OK 400 Mandatory identification")
   void getByIdentAndTypeDocErroBadRequestIdentification() throws Exception {
      this.mockMvc
            .perform(get(ConstantUtil.CONTEXT_CLIENT)
                  .queryParam("identification", "")
                  .queryParam("type_doc", "C")
                  .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.time", Matchers.notNullValue()))
            .andExpect(jsonPath("$.message", Matchers.notNullValue()));
   }

   @Test
   @DisplayName("Test getByIdentAndTypeDoc OK 400 Mandatory type_doc")
   void getByIdentAndTypeDocErroBadRequestTypeDoc() throws Exception {
      this.mockMvc
            .perform(get(ConstantUtil.CONTEXT_CLIENT)
                  .queryParam("identification", "23445322")
                  .queryParam("type_doc", "")
                  .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.time", Matchers.notNullValue()))
            .andExpect(jsonPath("$.message", Matchers.notNullValue()));
   }

   @Test
   @DisplayName("Test getByIdentAndTypeDoc OK 400 error Type document not invalid")
   void getByIdentAndTypeDocErroBadRequestTypeDocInvalid() throws Exception {
      this.mockMvc
            .perform(get(ConstantUtil.CONTEXT_CLIENT)
                  .queryParam("identification", "23445322")
                  .queryParam("type_doc", "F")
                  .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.time", Matchers.notNullValue()))
            .andExpect(jsonPath("$.message", Matchers.notNullValue()));
   }

}