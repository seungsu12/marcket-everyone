package market.everyone.service;

import lombok.RequiredArgsConstructor;
import market.everyone.domain.Member;
import market.everyone.dto.MemberSignupRequestDto;
import market.everyone.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public String signup(MemberSignupRequestDto request) {
        boolean existMember = memberRepository.existsByEmail(request.getEmail());

        if(existMember) return null;
        Member member = Member.createMember(request);
        member.encryptPassword(passwordEncoder);

        memberRepository.save(member);
        return member.getEmail();
    }
}
