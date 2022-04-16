package dio.innovation.one.SoldierAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SoldierNotFoundException extends RuntimeException {
    public SoldierNotFoundException(Long id) {
        super("Soldier not found with ID " + id);
    }
}
