package market.everyone.api;


import lombok.RequiredArgsConstructor;
import market.everyone.domain.Member;
import market.everyone.dto.MemberSignupRequestDto;
import market.everyone.dto.MemberResponseDto;
import market.everyone.response.Message;
import market.everyone.response.StatusEnum;
import market.everyone.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping(value = "/api/member/signup",produces = MediaType.APPLICATION_JSON_VALUE)
    public String signup(@RequestBody MemberSignupRequestDto request) {

        return "signup";

    }

    @GetMapping(value = "/api/member/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findMemberById(@PathVariable("id") Long id) {

        Member member = memberService.findById(id);
        MemberResponseDto dto = MemberResponseDto.createDto(member);
        Message msg = Message.createMessage(StatusEnum.OK,"아이디 반환",dto);
        return new ResponseEntity(msg, HttpStatus.OK);
    }





}
