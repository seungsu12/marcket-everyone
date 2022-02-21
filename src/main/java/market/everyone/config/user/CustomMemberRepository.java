package market.everyone.config.user;

import lombok.RequiredArgsConstructor;
import market.everyone.repository.UserrRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomMemberRepository implements UserDetailsService {

    private final UserrRepository userrRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userrRepository.findByEmail(username)
                .orElseThrow( () -> new UsernameNotFoundException("사용자를 찾을수 없습니다."));
    }
}
