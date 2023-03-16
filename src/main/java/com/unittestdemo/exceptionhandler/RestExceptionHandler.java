package com.unittestdemo.exceptionhandler;

import com.unittestdemo.dto.ResponseMsgDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleFailureResponse(CustomException e){
        ResponseMsgDTO responseMsgDTO = new ResponseMsgDTO();
        responseMsgDTO.setSuccess(false);
        responseMsgDTO.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMsgDTO);
    }
    @ExceptionHandler
    public ResponseEntity<?>handleInternalServerErrorResponse(Exception e){
        ResponseMsgDTO responseMsgDTO = new ResponseMsgDTO();
        responseMsgDTO.setSuccess(false);
        responseMsgDTO.setMessage("Internal Server Error, Check Log for more information about the Error");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMsgDTO);
    }
}
