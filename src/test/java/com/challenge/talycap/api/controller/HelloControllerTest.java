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

import com.challenge.talycap.business.service.HelloService;
import com.challenge.talycap.util.ConstantUtil;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

   @Autowired
   private MockMvc mockMvc;

   @MockBean
   private HelloService helloService;

   @Test
   @DisplayName("Hello World development OK 200")
   void calculateFactorial() throws Exception {
      Mockito.when(helloService.getHello()).thenReturn("Hello Dohko!");
      this.mockMvc
            .perform(get(ConstantUtil.CONTEXT_HELLO_WORLD).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.time", Matchers.notNullValue()))
            .andExpect(jsonPath("$.message", is(HttpStatus.OK.name())))
            .andExpect(jsonPath("$.data", Matchers.notNullValue()))
            .andExpect(jsonPath("$.data", is("Hello Dohko!")));
   }
}