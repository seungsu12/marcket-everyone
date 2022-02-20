package market.everyone.api;


import lombok.RequiredArgsConstructor;
import market.everyone.domain.Post;
import market.everyone.dto.PostRequestDto;
import market.everyone.dto.PostResponseDto;
import market.everyone.response.Message;
import market.everyone.response.StatusEnum;
import market.everyone.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;


    @GetMapping("/api/post/{id}")
    public PostResponseDto findByOne(@PathVariable("id") Long id) {

        Post post = postService.findByOne(id);
        PostResponseDto dto = new PostResponseDto();
        return dto;
    }

    @PostMapping("/api/post")
    public ResponseEntity savePost(@RequestBody PostRequestDto request) {

        Long id = postService.save(request);
        Message msg = Message.createMessage(StatusEnum.OK, "게시물 저장완료", id);

        return new ResponseEntity(msg, HttpStatus.OK);
    }

    @DeleteMapping("/api/post/{id}")
    public ResponseEntity deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/api/posts")
    public List<PostResponseDto> getPosts() {

        return postService.getPosts();
    }

    @PutMapping("/api/posts/{id}")
    public ResponseEntity updatePost(@PathVariable("id") Long id, @RequestBody PostRequestDto requestDto) {
        requestDto.setId(id);
        PostResponseDto response =postService.updatePost(requestDto);

        Message msg = Message.createMessage(StatusEnum.OK,"게시물 변경 완료",response);
        return new ResponseEntity(msg,HttpStatus.OK);
    }

}
