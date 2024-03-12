package TrainingjavaSpring.boot.cabinet.controller;

import TrainingjavaSpring.boot.cabinet.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvance {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException exception){
        String message = "id : " + exception.getId() + exception.getObjectName();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

}
