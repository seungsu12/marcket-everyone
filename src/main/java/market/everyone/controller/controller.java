package market.everyone.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import market.everyone.dto.PostResponseDto;
import market.everyone.repository.PostRepository;
import market.everyone.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j
public class controller {

    private final PostService postService;

    @GetMapping("/chat")
    public String chatGET() {
        log.info("@ChatController , chat GET()");
        return "chat";
    }


    @GetMapping("/")
    public String main(Model model) {
        List<PostResponseDto> posts =postService.getPosts();
        model.addAttribute("posts",posts);
//        log.info("id {}",posts.get(0).getPost_id());
        return "main";
    }

    @GetMapping("/view/post/{id}")
    public String post(@PathVariable("id") Long id, Model model) {
        PostResponseDto req = postService.findById(id);
        log.info("post id {}",req.getPost_id());

        model.addAttribute("post",req);
        return "post";
    }
    @GetMapping("/join")
    public String join() {

        return "join";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/post/{id}")
    public String post(@PathVariable("id") Long id) {
        return "post";
    }
}
