package market.everyone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "해당 포스트를 찾을수 없습니다.")
public class PostNotFoundException extends RuntimeException{

    public PostNotFoundException() {
        super("post not found");
    }
}
