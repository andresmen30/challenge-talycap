package com.challenge.talycap.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.talycap.business.dto.ResponseDto;
import com.challenge.talycap.business.service.ClientService;
import com.challenge.talycap.util.ConstantUtil;
import com.challenge.talycap.util.ResponseUtil;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;

@Tag(name = "Client", description = "exercise client")
@RequestMapping(ConstantUtil.CONTEXT_CLIENT)
@RestController
@RequiredArgsConstructor
@Validated
public class ClientController {

   private final ClientService clientService;

   @GetMapping()
   @ResponseStatus(HttpStatus.OK)
   @Operation(summary = "get by document number and document type", description = "get by document number and document type")
   public ResponseDto getByIdentAndTypeDoc(final @RequestParam(name = "identification") @NotBlank(message = "No debe ser nulo") String ident,
         final @RequestParam(name = "type_doc") @NotBlank(message = "No debe ser nulo") @Pattern(regexp = "(?i)[CP]", message = "type_doc debe ser "
               + "'C' o 'P'") String typeDoc) {
      return ResponseUtil.ok(HttpStatus.OK.name(), clientService.getByIdentAndTypeDoc(ident, typeDoc));
   }

}
