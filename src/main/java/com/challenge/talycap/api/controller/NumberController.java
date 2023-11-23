package com.challenge.talycap.api.controller;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.talycap.business.dto.ResponseDto;
import com.challenge.talycap.business.service.NumberService;
import com.challenge.talycap.util.ConstantUtil;
import com.challenge.talycap.util.ResponseUtil;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Tag(name = "Number Factorial", description = "exercise number")
@RequestMapping(ConstantUtil.CONTEXT_FACTORIAL)
@RestController
@RequiredArgsConstructor
@Validated
public class NumberController {

   private final NumberService numberService;

   @GetMapping("/{numero}")
   @ResponseStatus(HttpStatus.OK)
   @Operation(summary = "calculate factorial", description = "calculate factorial")
   public ResponseDto calculateFactorial(
         final @PathVariable(name = "numero")  @Min(value = 1, message = "El número debe ser igual o mayor que 0")  @NotNull(message = "No debe ser nulo") Long number) {
      return ResponseUtil.ok(HttpStatus.OK.name(), numberService.calculate(number));
   }

}
