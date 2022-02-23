package market.everyone.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import market.everyone.domain.ItemType;
import market.everyone.domain.Post;

@Getter
@Setter
@NoArgsConstructor
public class PostRequestDto {

    private Long id;
    private String title;
    private String context;
    private String username;
    private String item_name;
    private ItemType type;
    private Long price;
    private Long member_id;


}
