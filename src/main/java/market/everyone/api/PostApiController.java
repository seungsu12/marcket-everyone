package market.everyone.api;


import lombok.RequiredArgsConstructor;
import market.everyone.domain.Post;
import market.everyone.dto.PostDto;
import market.everyone.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/post/{id}")
    public PostDto findByOne(@PathVariable("id") Long id) {

        Post post = postService.findByOne(id);
        PostDto dto = new PostDto();
        return dto;
    }



}
