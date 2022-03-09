package market.everyone.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import market.everyone.dto.OrderRequestDto;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Getter
@Setter
@Table(name = "orders")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long totalPrice;

    @Embedded()
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public static Order createOrder(OrderRequestDto dto,Member member,Post post) {
            Order order = new Order();
            order.setStartDate(dto.getStartDate());
            order.setEndDate(dto.getEndDate());
            order.setMember(member);
            order.setPost(post);
            order.setItem(post.getItem());
            long subDate = ChronoUnit.DAYS.between(dto.getStartDate(), dto.getEndDate());
            order.setTotalPrice(subDate * post.getPrice());

            return order;
    }



    public void setMember(Member member) {
        this.member =member;
        member.getOrders().add(this);
    }

    public void setPost(Post post) {
        this.post = post;
        post.getOrders().add(this);
    }
}
