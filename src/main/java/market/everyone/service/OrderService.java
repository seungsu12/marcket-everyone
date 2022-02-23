package market.everyone.service;


import lombok.RequiredArgsConstructor;
import market.everyone.domain.Member;
import market.everyone.domain.Order;
import market.everyone.domain.Post;
import market.everyone.dto.OrderRequestDto;
import market.everyone.dto.OrderResponseDto;
import market.everyone.repository.MemberRepository;
import market.everyone.repository.OrderRepository;
import market.everyone.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public OrderResponseDto createOrder(OrderRequestDto request) {

        Member member = memberRepository.getById(request.getMember_id());
        Post post = postRepository.getById(request.getPost_id());
        Order order = Order.createOrder(request,member,post);
        Order saveOrder = orderRepository.save(order);

        return OrderResponseDto.createDto(saveOrder,post,member);

    }
}
