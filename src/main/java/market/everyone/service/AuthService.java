package market.everyone.service;

import lombok.RequiredArgsConstructor;
import market.everyone.domain.Member;
import market.everyone.dto.JwtRequestDto;
import market.everyone.dto.MemberSignupRequestDto;
import market.everyone.exception.EmailNotFoundException;
import market.everyone.repository.MemberRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member signup(MemberSignupRequestDto request) {
//        boolean existMember = memberRepository.existsByEmail(request.getEmail());

//        if(existMember) throw new EmailNotFoundException();
        Member member = Member.createMember(request);
        member.encryptPassword(passwordEncoder);

        memberRepository.save(member);
        return member;
    }


//    public String login(JwtRequestDto request) throws Exception {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//
//    }
}
