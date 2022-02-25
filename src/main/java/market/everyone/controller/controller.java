package market.everyone.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class controller {


    @GetMapping("/main")
    public String main() {
        return "main";
    }


    @ResponseBody
    @GetMapping("/no-auth")
    public String test() {
        return "test";
    }
}
