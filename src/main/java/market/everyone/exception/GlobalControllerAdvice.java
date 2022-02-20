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

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(PostNotFoundException e) {

        String text ="해당 게시글이 없습니다.";
        Message msg = Message.createMessage(StatusEnum.NOT_FOUND,text,"");

        return new ResponseEntity(msg,HttpStatus.NOT_FOUND);
    }
}
