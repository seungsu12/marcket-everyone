package market.everyone.dto;

import lombok.Getter;
import lombok.Setter;
import market.everyone.domain.Post;

@Getter
@Setter
public class PostRequestDto {

    private Long id;
    private String title;
    private String context;
    private String username;
    private Long price;
    private Long member_id;


}
