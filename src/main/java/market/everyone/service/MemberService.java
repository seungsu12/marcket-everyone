package market.everyone.service;

import lombok.RequiredArgsConstructor;
import market.everyone.domain.Member;
import market.everyone.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public Member join(Member member) {

        return memberRepository.save(member);
    }

    public Member findById(Long id) {
      return memberRepository.findById(id).orElseThrow();
    }

}
