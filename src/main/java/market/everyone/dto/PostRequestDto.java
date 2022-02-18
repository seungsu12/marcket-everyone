package market.everyone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {

    private Long id;
    private String title;
    private String context;
    private String username;
    private Integer price;
}
