package market.everyone.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test")
@Controller
public class controller {


    @RequestMapping("/")
    public String main() {
        return "main";
    }


    @ResponseBody
    @GetMapping("/no-auth")
    public String test() {
        return "test";
    }
}
