package market.everyone.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class controller {


    @GetMapping("/")
    public String main() {
        return "main";
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
