package market.everyone.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    private StatusEnum status;
    private String message;
    private Object data;

    public static Message createMessage(StatusEnum status, String message, Object data) {

        Message msg = new Message();
        msg.setStatus(status);
        msg.setMessage(message);
        msg.setData(data);
        return msg;
    }
}
