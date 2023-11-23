package com.challenge.talycap.api.exception;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RecordNotFoundException extends RuntimeException implements Serializable {

   @Builder.Default
   private final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

   @Builder.Default
   private String message = "the [%s] not found";

   public RecordNotFoundException(Object... values) {
      this.message = String.format(this.message, Arrays.stream(values).map(Object::toString).collect(Collectors.joining(",")));
   }

}
