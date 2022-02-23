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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
