package market.everyone.dto;

import lombok.Getter;
import lombok.Setter;
import market.everyone.domain.Member;
import market.everyone.domain.Order;
import market.everyone.domain.Post;

import java.time.LocalDate;

@Getter
@Setter
public class OrderResponseDto {

    private Long id;
    private Long post_id;
    private Long seller_id;
    private Long buyer_id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long totalPrice;

    public static OrderResponseDto createDto(Order order, Post post, Member member) {
        OrderResponseDto response = new OrderResponseDto();
        response.setId(order.getId());
        response.setPost_id(post.getId());
        response.setBuyer_id(order.getMember().getId());
        response.setSeller_id(post.getMember().getId());
        response.setStartDate(order.getStartDate());
        response.setEndDate(order.getEndDate());
        response.setTotalPrice(order.getTotalPrice());

        return response;
    }
}
