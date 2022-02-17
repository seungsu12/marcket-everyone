package market.everyone.api;


import market.everyone.domain.Member;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {


    @PostMapping("/api/user/join")
    public void join(@ModelAttribute Member member) {

    }
}
