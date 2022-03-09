package market.everyone.api;

import lombok.RequiredArgsConstructor;
import market.everyone.dto.MsgRoom;
import market.everyone.service.MsgService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequiredArgsConstructor
public class MsgController {

//    private final MsgService msgService;
//
//    @PostMapping("/chat")
//    public MsgRoom createRoom(@RequestParam(defaultValue = "roomName") String name ) {
//        return msgService.createRoom(name);
//    }
//
//    @GetMapping("/chat")
//    public List<MsgRoom> findAllRoom() {
//        return msgService.findAllRoom();
//    }
}
