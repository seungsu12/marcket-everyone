package market.everyone.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OrderRequestDto {

    private Long post_id;
    private Long member_id;
    private LocalDate startDate;
    private LocalDate endDate;
}
