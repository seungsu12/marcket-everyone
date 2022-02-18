package market.everyone.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "error.bad")
public class EmailNotFoundException extends RuntimeException {

}
