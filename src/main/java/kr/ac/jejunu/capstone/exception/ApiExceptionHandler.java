package kr.ac.jejunu.capstone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {
            UserNotExistException.class,
            CameraNotFoundException.class,
            StationNotFoundException.class})
    public ResponseEntity handleNotExistException(Exception e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return getResponseEntity(httpStatus, e.getMessage());
    }

    @ExceptionHandler(value = {UserDuplicatedException.class})
    public ResponseEntity handleUserDuplicatedException(UserDuplicatedException e) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        return getResponseEntity(httpStatus, e.getMessage());
    }

    @ExceptionHandler(value = {HttpClientErrorException.Forbidden.class})
    public ResponseEntity handleForbiddenException(HttpClientErrorException.Forbidden e) {
        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        return getResponseEntity(httpStatus, e.getMessage());
    }

    private ResponseEntity getResponseEntity(HttpStatus httpStatus, String message) {
        ApiException apiException = ApiException.builder()
                .statusCode(httpStatus.value())
                .message(message)
                .data(ZonedDateTime.now())
                .build();
        return new ResponseEntity(apiException, httpStatus);
    }

}
