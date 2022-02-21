package market.everyone.service;

import lombok.RequiredArgsConstructor;
import market.everyone.domain.Member;
import market.everyone.dto.MemberRequestDto;
import market.everyone.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Member signup(MemberRequestDto requestDto) {
        Boolean existed = userRepository.existsByEmail(requestDto.getEmail());
        if (existed) {
            throw new IllegalArgumentException();
        }
        Member member = Member.createMember(requestDto);
        member.encryptPassword(passwordEncoder);
        return userRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Member findById(Long id) {
      return userRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteMember(Long id) {
        Boolean existed = userRepository.existsById(id);
        if(!existed) throw new IllegalArgumentException();
        userRepository.deleteById(id);
    }


}
