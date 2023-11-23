package com.challenge.talycap.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Client {

   @Id
   @GeneratedValue
   private Long id;

   private String firstName;

   private String secondName;

   private String surname;

   private String secondSurname;

   private String typeDoc;

   private String ident;

   private String phone;

   private String address;

   private String city;

}
