package market.everyone;

import market.everyone.domain.Member;
import market.everyone.domain.Post;
import market.everyone.dto.PostRequestDto;
import market.everyone.repository.MemberRepository;
import market.everyone.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class itemTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PostRepository postRepository;

    @Test
    public void check() {
        PostRequestDto dto = new PostRequestDto();
        dto.setId(1L);
        dto.setPrice(100L);
        dto.setMember_id(1L);



    }



}
