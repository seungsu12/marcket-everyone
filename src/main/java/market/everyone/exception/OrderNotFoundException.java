package market.everyone.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "해당 order 가 없습니다.")
public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException() {
        super("order not found");
    }
}
