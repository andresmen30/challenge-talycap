package com.challenge.talycap.business.service.impl;

import org.springframework.stereotype.Service;

import com.challenge.talycap.business.service.NumberService;

@Service
public class NumberServiceImpl implements NumberService {

   @Override
   public Long calculate(final Long number) {
      long factorial = 1;
      for (int i = 1; i <= number; ++i) {
         factorial *= i;
      }
      return factorial;
   }

}
