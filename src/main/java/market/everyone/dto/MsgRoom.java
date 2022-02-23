package market.everyone.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class MsgRoom {

    private String roomId;
    private Set<WebSocketSession> sessions = new HashSet<>();

    @Builder
    public MsgRoom(String roomId) {
        this.roomId = roomId;
    }

    public void handleAcations()
}

