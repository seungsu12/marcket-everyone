package market.everyone.service;

import lombok.RequiredArgsConstructor;
import market.everyone.domain.User;
import market.everyone.dto.UserRequestDto;
import market.everyone.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public User signup(UserRequestDto request) {
//        boolean existMember = memberRepository.existsByEmail(request.getEmail());

//        if(existMember) throw new EmailNotFoundException();
        User user = User.createMember(request);
        user.encryptPassword(passwordEncoder);

        memberRepository.save(user);
        return user;
    }


}
