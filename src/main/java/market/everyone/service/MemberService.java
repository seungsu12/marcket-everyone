package market.everyone.service;

import lombok.RequiredArgsConstructor;
import market.everyone.domain.Member;
import market.everyone.dto.MemberRequestDto;
import market.everyone.dto.MemberResponseDto;
import market.everyone.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Member signup(MemberRequestDto requestDto) {
        Boolean existed = memberRepository.existsByEmail(requestDto.getEmail());
        if (existed) {
            throw new IllegalArgumentException();
        }
        Member member = Member.createMember(requestDto);
        member.encryptPassword(passwordEncoder);
        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Member findById(Long id) {
      return memberRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteMember(Long id) {
        Boolean existed = memberRepository.existsById(id);
        if(!existed) throw new IllegalArgumentException();
        memberRepository.deleteById(id);
    }


}
