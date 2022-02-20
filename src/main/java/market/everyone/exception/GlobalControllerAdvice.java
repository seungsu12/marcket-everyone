package market.everyone.exception;

import market.everyone.domain.Post;
import market.everyone.response.Message;
import market.everyone.response.StatusEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = PostNotFoundException.class)
    public ResponseEntity postException(PostNotFoundException e) {


        Message msg = Message.createMessage(StatusEnum.NOT_FOUND,e.getMessage(),"");

        return new ResponseEntity(msg,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmailNotFoundException.class)
    public ResponseEntity emailException(EmailNotFoundException e) {


        Message msg = Message.createMessage(StatusEnum.NOT_FOUND,e.getMessage(),"");

        return new ResponseEntity(msg,HttpStatus.NOT_FOUND);
    }
}
