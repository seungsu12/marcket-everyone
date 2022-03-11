package market.everyone.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import market.everyone.domain.Member;
import market.everyone.domain.Post;
import market.everyone.dto.PostRequestDto;
import market.everyone.dto.PostResponseDto;
import market.everyone.exception.PostNotFoundException;
import market.everyone.repository.MemberRepository;
import market.everyone.repository.PostJpaRepository;
import market.everyone.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final PostJpaRepository postJpaRepository;
    private final MemberRepository memberRepository;


    public PostResponseDto findById(Long id) {

        Post findPost =postRepository.findByIdAndName(id).orElseThrow( () ->new PostNotFoundException());

        Long member_id = findPost.getMember().getId();
        String nickname = findPost.getMember().getNickname();
        return PostResponseDto.CreateDto(findPost,member_id,nickname);


    }

    @Transactional(readOnly = false)
    public Long save(PostRequestDto request) {

        Optional<Member> member = memberRepository.findById(request.getMember_id());
        log.info("save member {}",member.get());

        Post save = postRepository.save(Post.CreatePost(request,
                member.orElseThrow(() ->new IllegalArgumentException("멤버가 없습니다."))));

        return save.getId();
    }


    public void deletePost(Long id) {
        boolean existPost = postRepository.existsById(id);
        if (existPost) {
            throw new PostNotFoundException();
        }

        postRepository.deleteById(id);
    }


    public List<PostResponseDto> getPosts() {
        List<Post> posts = postRepository.getPosts();
        List<PostResponseDto> result = posts.stream().map(n -> PostResponseDto.CreateDto(n,n.getMember().getId(),n.getMember().getNickname()))
                .collect(Collectors.toList());

        return result;
    }
    @Transactional
    public PostResponseDto updatePost(PostRequestDto requestDto) {

        boolean existed = postRepository.existsById(requestDto.getId());

        if (!existed) {
            throw new PostNotFoundException();
        }

        return PostResponseDto.CreateDto(postJpaRepository.updatePost(requestDto));


    }


}
