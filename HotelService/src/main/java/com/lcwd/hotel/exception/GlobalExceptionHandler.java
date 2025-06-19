package com.lcwd.hotel.exception;

import com.lcwd.hotel.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ApiResponse apiResponse = new ApiResponse().builder().message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .success(false)
                .build();
        return ResponseEntity.status(404).body(apiResponse);
    }

}


