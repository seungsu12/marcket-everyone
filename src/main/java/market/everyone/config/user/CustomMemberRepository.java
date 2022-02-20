package market.everyone.config.user;

import lombok.RequiredArgsConstructor;
import market.everyone.exception.EmailNotFoundException;
import market.everyone.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomMemberRepository implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findByEmail(username)
                .orElseThrow( () -> new UsernameNotFoundException("사용자를 찾을수 없습니다."));
    }
}
