package com.loganhere.usercard.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionsResponse> handleIllegalArgument(IllegalArgumentException e) {
        log.warn("Illegal Argument error: {}", e.getMessage());
        ExceptionsResponse exception = new ExceptionsResponse(
                "Bad Request",
                "ILLEGAL_ARGUMENT",
                e.getMessage()
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionsResponse> nullPointerException(NullPointerException e) {
        log.warn("Null Exception error: {}",e.getMessage());
        ExceptionsResponse exception = new ExceptionsResponse(
                "Null request",
                "NULL_EXCEPTION",
                e.getMessage()
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionsResponse> userNotFoundException(UserNotFoundException e) {
        log.warn("User Not Found error: {}", e.getMessage());
        ExceptionsResponse exception = new ExceptionsResponse(
                "User not found",
                "USER_NOT_FOUND",
                e.getMessage()

        );
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception);
    }
}