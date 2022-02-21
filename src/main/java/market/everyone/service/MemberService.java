package market.everyone.service;

import lombok.RequiredArgsConstructor;
import market.everyone.domain.User;
import market.everyone.dto.UserRequestDto;
import market.everyone.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User signup(UserRequestDto requestDto) {
        Boolean existed = userRepository.existsByEmail(requestDto.getEmail());
        if (existed) {
            throw new IllegalArgumentException();
        }
        User user = User.createMember(requestDto);
        user.encryptPassword(passwordEncoder);
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
      return userRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteMember(Long id) {
        Boolean existed = userRepository.existsById(id);
        if(!existed) throw new IllegalArgumentException();
        userRepository.deleteById(id);
    }


}
