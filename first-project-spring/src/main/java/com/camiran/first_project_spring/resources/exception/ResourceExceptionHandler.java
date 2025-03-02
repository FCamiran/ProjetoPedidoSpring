package com.camiran.first_project_spring.resources.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.camiran.first_project_spring.services.exceptions.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> ObjectNotFoundException(ObjectNotFoundException e, HttpServletRequest request){
        StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    
}
