package market.everyone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignupRequestDto {

    private String email;
    private String password;
    private String username;
    private String nickname;
}
