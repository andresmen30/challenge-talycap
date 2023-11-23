package com.challenge.talycap.api.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.lang3.StringUtils;
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

import com.challenge.talycap.business.service.NumberService;
import com.challenge.talycap.util.ConstantUtil;

@WebMvcTest(NumberController.class)
class NumberControllerTest {

   @Autowired
   private MockMvc mockMvc;

   @MockBean
   private NumberService numberService;

   @Test
   @DisplayName("Calculate OK 200")
   void calculateFactorial() throws Exception {
      Mockito.when(numberService.calculate(5L)).thenReturn(120L);
      this.mockMvc
            .perform(get(StringUtils.join(ConstantUtil.CONTEXT_FACTORIAL, "/", 5L)).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.time", Matchers.notNullValue()))
            .andExpect(jsonPath("$.message", is(HttpStatus.OK.name())))
            .andExpect(jsonPath("$.data", Matchers.notNullValue()))
            .andExpect(jsonPath("$.data", is(120)));
   }

   @Test
   @DisplayName("Calculate number is less than 0 negative number")
   void NumberLessThanNegative() throws Exception {
      this.mockMvc
            .perform(get(StringUtils.join(ConstantUtil.CONTEXT_FACTORIAL, "/", -5L)).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.time", Matchers.notNullValue()))
            .andExpect(jsonPath("$.message", Matchers.notNullValue()));
   }

   @Test
   @DisplayName("Calculate number is less than 0")
   void NumberLessThan() throws Exception {
      this.mockMvc
            .perform(get(StringUtils.join(ConstantUtil.CONTEXT_FACTORIAL, "/", 0)).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.time", Matchers.notNullValue()))
            .andExpect(jsonPath("$.message", Matchers.notNullValue()));
   }
}