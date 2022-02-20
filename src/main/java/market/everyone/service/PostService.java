package market.everyone.service;


import lombok.RequiredArgsConstructor;
import market.everyone.domain.Post;
import market.everyone.dto.PostRequestDto;
import market.everyone.dto.PostResponseDto;
import market.everyone.exception.PostNotFoundException;
import market.everyone.repository.PostJpaRepository;
import market.everyone.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final PostJpaRepository postJpaRepository;


    public Post findByOne(Long id) {
        return postRepository.findById(id).get();
    }

    @Transactional(readOnly = false)
    public Long save(PostRequestDto request) {

        Post save = postRepository.save(Post.CreatePost(request));

        return save.getId();
    }


    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }


    public List<PostResponseDto> getPosts() {
        List<Post> posts = postRepository.getPosts();
        List<PostResponseDto> result = posts.stream().map(n -> PostResponseDto.CreateDto(n))
                .collect(Collectors.toList());

        return result;
    }
    @Transactional(readOnly = false)
    public PostResponseDto updatePost(PostRequestDto requestDto) {

        boolean existed = postRepository.existsById(requestDto.getId());
        if (!existed) {
            throw new PostNotFoundException();
        }

        return PostResponseDto.CreateDto(postJpaRepository.updatePost(requestDto));


    }
}
