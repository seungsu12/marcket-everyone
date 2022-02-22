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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    public void setMember(Member member) {
        this.member =member;
        member.getPosts().add(this);
    }

    public static Post CreatePost(PostRequestDto dto,Member member) {
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContext(dto.getContext());
        post.setPrice(dto.getPrice());
        post.setMember(member);

        return post;
    }


    public void updatePost(PostRequestDto dto) {
        this.title =dto.getTitle();
        this.context= dto.getContext();
        this.price = dto.getPrice();
    }
}
