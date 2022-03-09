package market.everyone.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PostApiController {

    private final PostService postService;


    @GetMapping("/api/post/{id}")
    public PostResponseDto findById(@PathVariable("id") Long id) {

        return postService.findById(id);

    }

    @PostMapping("/api/post")
    public ResponseEntity savePost(@RequestBody PostRequestDto request) {
        log.info("post 저장 메서드");
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

    @PutMapping("/api/post/{id}")
    public ResponseEntity updatePost(@PathVariable("id") Long id, @RequestBody PostRequestDto requestDto) {
        requestDto.setId(id);
        PostResponseDto response =postService.updatePost(requestDto);

        Message msg = Message.createMessage(StatusEnum.OK,"게시물 변경 완료",response);
        return new ResponseEntity(msg,HttpStatus.OK);
    }

}
