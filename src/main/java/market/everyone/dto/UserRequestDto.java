package market.everyone.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRequestDto {

    @NotBlank(message = "메일은 필수입니다.")
    private String email;
    private String password;
    private String name;
    private String nickname;
}
