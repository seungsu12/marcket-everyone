package market.everyone.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import market.everyone.dto.MemberSignupRequestDto;
import org.springframework.security.authorization.AuthorityAuthorizationDecision;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    private String username;

    @JsonIgnore
    private String password;


    private String nickname;


    private String email;

    public static Member createMember(MemberSignupRequestDto dto) {
        Member member = new Member();
        member.setEmail(dto.getEmail());
        member.setNickname(dto.getUsername());
        member.setPassword(dto.getPassword());
        member.setNickname(dto.getNickname());
        return member;
    }

    public void encryptPassword(PasswordEncoder passwordEncoder) {
        password = passwordEncoder.encode(password);
    }

}
