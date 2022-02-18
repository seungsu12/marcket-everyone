package market.everyone.api;

import lombok.RequiredArgsConstructor;
import market.everyone.domain.Member;
import market.everyone.dto.MemberSignupRequestDto;
import market.everyone.dto.MemberResponseDto;
import market.everyone.response.Message;
import market.everyone.response.StatusEnum;
import market.everyone.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value="/signup",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity signup(@RequestBody MemberSignupRequestDto request) {

        Member member =authService.signup(request);
        MemberResponseDto response = MemberResponseDto.createDto(member);
        Message msg =Message.createMessage(StatusEnum.OK,"정상적으로 등록됐습니다.",response);
         return new ResponseEntity(msg,HttpStatus.OK);
    }

//    @PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String login(@RequestBody JwtRequestDto request) {
//        try {
//            return authService.login(request);
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }
}
