package com.challenge.talycap.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.talycap.business.dto.ResponseDto;
import com.challenge.talycap.business.service.HelloService;
import com.challenge.talycap.util.ConstantUtil;
import com.challenge.talycap.util.ResponseUtil;

import lombok.RequiredArgsConstructor;

@Tag(name = "Hello", description = "exercise hello")
@RequestMapping(ConstantUtil.CONTEXT_HELLO_WORLD)
@RestController
@RequiredArgsConstructor
@Validated
public class HelloController {

   private final HelloService helloWorldService;

   @GetMapping()
   @ResponseStatus(HttpStatus.OK)
   @Operation(summary = "get hello", description = "get hello")
   public ResponseDto calculateFactorial() {
      return ResponseUtil.ok(HttpStatus.OK.name(), helloWorldService.getHello());
   }

}
