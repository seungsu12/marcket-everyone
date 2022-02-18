package market.everyone.dto;

import lombok.Getter;
import lombok.Setter;
import market.everyone.domain.Member;

@Getter
@Setter
public class MemberResponseDto {

    private String username;

    private String nickname;

    private String email;

    public static MemberResponseDto createDto(Member member) {
        MemberResponseDto dto = new MemberResponseDto();
        dto.setUsername(member.getUsername());
        dto.setNickname(member.getNickname());
        dto.setEmail(member.getEmail());
        return dto;
    }
}
