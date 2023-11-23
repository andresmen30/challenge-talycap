package com.challenge.talycap.business.service.impl;

import org.springframework.stereotype.Service;

import com.challenge.talycap.business.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

   public String getHello() {
      return "Hello Dohko!";
   }

}
