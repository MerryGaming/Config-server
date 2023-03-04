package org.aibles.animal.controller.advice;


import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.aibles.animal.exception.ExceptionRequest;
import org.aibles.animal.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandle {

  @ExceptionHandler(value = {ExceptionRequest.class})
  public ResponseEntity<ExceptionResponse> exceptionHandle(ExceptionRequest error) {
    log.info("(Exception)exception: {}", error);
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setError("Exception");
    exceptionResponse.setMessage(error.getMessage());
    exceptionResponse.setTimestamp(Instant.now());
    return ResponseEntity.status(HttpStatus.valueOf(error.getStatus())).body(exceptionResponse);
  }

  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse validationExceptionHandle() {
    log.info("(Validation)");
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setError("Exception");
    exceptionResponse.setMessage("Error input");
    exceptionResponse.setTimestamp(Instant.now());
    return exceptionResponse;
  }
}
