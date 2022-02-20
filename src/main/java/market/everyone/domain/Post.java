package market.everyone.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import market.everyone.dto.PostRequestDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String title;

    private String context;

    private Long price;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Comment> comment;

    public static Post CreatePost(PostRequestDto dto) {
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContext(dto.getContext());
        post.setPrice(dto.getPrice());

        return post;
    }
}
