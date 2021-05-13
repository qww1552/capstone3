package kr.ac.jejunu.capstone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {UserNotExistException.class})
    public ResponseEntity handleUserNotExistException(UserNotExistException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiException apiException = ApiException.builder()
                .status(httpStatus.value())
                .message(e.getMessage())
                .timestamp(ZonedDateTime.now())
                .build();

        return new ResponseEntity(apiException, httpStatus);
    }

    @ExceptionHandler(value = {UserDuplicatedException.class})
    public ResponseEntity handleUserDuplicatedException(UserDuplicatedException e) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        ApiException apiException = ApiException.builder()
                .status(httpStatus.value())
                .message(e.getMessage())
                .timestamp(ZonedDateTime.now())
                .build();

        return new ResponseEntity(apiException, httpStatus);
    }
}