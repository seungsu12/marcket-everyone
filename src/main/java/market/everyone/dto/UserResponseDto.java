package market.everyone.dto;

import lombok.Getter;
import lombok.Setter;
import market.everyone.domain.User;

@Getter
@Setter
public class UserResponseDto {

    private String username;

    private String nickname;

    private String email;

    public static UserResponseDto createDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setUsername(user.getUsername());
        dto.setNickname(user.getNickname());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
