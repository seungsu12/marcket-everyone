package market.everyone.domain;


import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
public class Order {

    @GeneratedValue
    @Id
    @Column(name = "order_id")
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long totalPrice;

    @OneToOne(fetch=FetchType.LAZY)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
}
