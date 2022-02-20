package market.everyone.repository;

import market.everyone.domain.Post;
import market.everyone.dto.PostRequestDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;

@Repository
public class PostJpaRepository {

    @PersistenceContext
    EntityManager em;


    public Post updatePost(PostRequestDto requestDto) {
        em.find(Post.class,requestDto.getId());
        Post result = Post.CreatePost(requestDto);
        em.persist(result);
        em.flush();
        return result;
    }
}
