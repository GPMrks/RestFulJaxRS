package dio.innovation.one.SoldierAPI.rest;

import dio.innovation.one.SoldierAPI.exception.SoldierNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ResourceAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SoldierNotFoundException.class)
    public String notFound(String errorMessage){
        return errorMessage;
    }

}
