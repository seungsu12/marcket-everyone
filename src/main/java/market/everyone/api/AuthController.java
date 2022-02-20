package market.everyone.api;

import lombok.RequiredArgsConstructor;
import market.everyone.service.AuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;



//    @PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String login(@RequestBody JwtRequestDto request) {
//        try {
//            return authService.login(request);
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }
}
