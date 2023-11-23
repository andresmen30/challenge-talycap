package com.challenge.talycap.business.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Schema(description = "Dto model Client")
public class ClientDto {

   @Schema(description = "First name")
   private String firstName;

   @Schema(description = "Second name")
   private String secondName;

   @Schema(description = "Surname")
   private String surname;

   @Schema(description = "Second surname")
   private String secondSurname;

   @Schema(description = "Phone")
   private String phone;

   @Schema(description = "Address")
   private String address;

   @Schema(description = "City")
   private String city;

}
