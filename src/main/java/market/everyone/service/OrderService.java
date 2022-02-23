package market.everyone.service;


import lombok.RequiredArgsConstructor;
import market.everyone.dto.OrderRequestDto;
import market.everyone.dto.OrderResponseDto;
import market.everyone.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public OrderResponseDto createOrder(OrderRequestDto request) {


    }
}
