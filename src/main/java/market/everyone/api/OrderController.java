package market.everyone.api;


import lombok.RequiredArgsConstructor;
import market.everyone.dto.OrderRequestDto;
import market.everyone.dto.OrderResponseDto;
import market.everyone.repository.OrderRepository;
import market.everyone.response.Message;
import market.everyone.response.StatusEnum;
import market.everyone.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/api/order")
    public ResponseEntity createOrder(@RequestBody OrderRequestDto request) {

        OrderResponseDto response = orderService.createOrder(request);
        Message msg = Message.createMessage(StatusEnum.OK,"주문 완료",response);

        return new ResponseEntity(msg,HttpStatus.OK);

    }

    @DeleteMapping("/api/order/{id}")
    public ResponseEntity cancelOrder(@PathVariable("id")Long id) {

        orderService.cancelOrder(id);

        Message msg = Message.createMessage(StatusEnum.OK,"삭제 완료",id);
        return new ResponseEntity(msg,HttpStatus.OK);
    }
}
