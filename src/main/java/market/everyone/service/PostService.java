package market.everyone.service;


import lombok.RequiredArgsConstructor;
import market.everyone.domain.Post;
import market.everyone.dto.PostRequestDto;
import market.everyone.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post findByOne(Long id) {
        return postRepository.findById(id).get();
    }

    public Long save(PostRequestDto request) {

        Post save = postRepository.save(Post.CreatePost(request));

        return save.getId();
    }
}
