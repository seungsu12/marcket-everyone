package market.everyone.api;


import lombok.RequiredArgsConstructor;
import market.everyone.domain.Post;
import market.everyone.dto.PostDto;
import market.everyone.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @GetMapping("/api/post/{id}")
    public PostDto findByOne(@PathVariable("id") Long id) {
       Post post= postService.findByOne(id);
       PostDto dto =
       return dto;
    }



}
