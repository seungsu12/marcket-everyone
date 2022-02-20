package market.everyone.dto;

import lombok.Getter;
import lombok.Setter;
import market.everyone.domain.Post;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class PostResponseDto {

    private Long member_id;
    private Long post_id;
    private String title;
    private String context;
    private Long price;

    public static PostResponseDto CreateDto(Post post) {
        PostResponseDto response = new PostResponseDto();
        response.setPost_id(post.getId());
        response.setContext(post.getContext());
        response.setPrice(post.getPrice());
        response.setTitle(post.getTitle());

        return response;
    }

}
