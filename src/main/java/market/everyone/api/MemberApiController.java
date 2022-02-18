package market.everyone.api;


import market.everyone.domain.Member;
import market.everyone.dto.JwtRequestDto;
import market.everyone.dto.MemberSignupRequestDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {


    @PostMapping(value = "/api/user/signup",produces = MediaType.APPLICATION_JSON_VALUE)
    public String signup(@RequestBody MemberSignupRequestDto request) {
        return "signup";
    }

    @PostMapping(value = "/api/user/signup",produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody JwtRequestDto request) {
        return "login";
    }
}
