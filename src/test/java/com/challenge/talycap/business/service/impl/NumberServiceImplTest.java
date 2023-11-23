package com.challenge.talycap.business.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NumberServiceImplTest {

   @InjectMocks
   private NumberServiceImpl numberService;

   @Test
   @DisplayName("calculate factorial 8")
   void calculate() {
      final Long result = numberService.calculate(8L);
      assertThat(result).isNotNull();
      assertThat(result).isEqualTo(40320);
   }

   @Test
   @DisplayName("calculate factorial zero")
   void calculateZero() {
      final Long result = numberService.calculate(0L);
      assertThat(result).isNotNull();
      assertThat(result).isEqualTo(1);
   }

   @Test
   @DisplayName("calculate factorial negative, value is default 1")
   void calculateNegative() {
      final Long result = numberService.calculate(-3L);
      assertThat(result).isNotNull();
      assertThat(result).isEqualTo(1);
   }

}