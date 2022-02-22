package market.everyone.dto;

import lombok.Getter;
import lombok.Setter;
import market.everyone.domain.Post;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Getter
@Setter
public class PostResponseDto {

    private Long member_id;
    private String nickname;
    private Long post_id;
    private String title;
    private String context;
    private Long price;

    public static PostResponseDto CreateDto(Post post, Long member_id, String nickname) {
        PostResponseDto response = new PostResponseDto();
        response.setNickname(nickname);
        response.setMember_id(member_id);
        response.setPost_id(post.getId());
        response.setContext(post.getContext());
        response.setPrice(post.getPrice());
        response.setTitle(post.getTitle());

        return response;
    }

    public static PostResponseDto CreateDto(Post post) {
        PostResponseDto response = new PostResponseDto();
        response.setPost_id(post.getId());
        response.setContext(post.getContext());
        response.setPrice(post.getPrice());
        response.setTitle(post.getTitle());

        return response;
    }
}
