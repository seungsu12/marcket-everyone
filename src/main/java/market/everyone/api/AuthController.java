package market.everyone.api;

import lombok.RequiredArgsConstructor;
import market.everyone.dto.MemberSignupRequestDto;
import market.everyone.service.AuthService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value="signup",produces = MediaType.APPLICATION_JSON_VALUE)
    public String signup(@RequestBody MemberSignupRequestDto request) {
        return authService.signup(request);
    }
}
