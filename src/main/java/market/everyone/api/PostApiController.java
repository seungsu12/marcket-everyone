package market.everyone.api;


import lombok.RequiredArgsConstructor;
import market.everyone.domain.Post;
import market.everyone.dto.PostRequestDto;
import market.everyone.response.Message;
import market.everyone.response.StatusEnum;
import market.everyone.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;


    @GetMapping("/api/post/{id}")
    public PostRequestDto findByOne(@PathVariable("id") Long id) {

        Post post = postService.findByOne(id);
        PostRequestDto dto = new PostRequestDto();
        return dto;
    }

    @PostMapping("/api/post")
    public ResponseEntity savePost(@RequestBody PostRequestDto request) {

        Long id =postService.save(request);
        Message msg = Message.createMessage(StatusEnum.OK,"게시물 저장완료",id);

        return new ResponseEntity(msg,HttpStatus.OK);
    }
}
