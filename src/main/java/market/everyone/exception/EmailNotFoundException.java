package market.everyone.exception;


import market.everyone.response.Message;
import market.everyone.response.StatusEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "error.bad")
public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException() {
        super("해당 이메일이 존재하지 않습니다.");
    }
}
