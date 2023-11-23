package com.challenge.talycap.util;

import java.time.LocalDateTime;

import com.challenge.talycap.business.dto.ResponseDto;

public class ResponseUtil {


   public static ResponseDto error(final String message){
      return getResponse(message, null);
   }

   public static ResponseDto ok(final String message, final Object data){
      return getResponse(message, data);
   }

   private static ResponseDto getResponse(final String message, final Object data) {
      return ResponseDto.builder().time(LocalDateTime.now()).message(message).data(data).build();
   }

}
