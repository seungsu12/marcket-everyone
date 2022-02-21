package market.everyone.service;

import lombok.RequiredArgsConstructor;
import market.everyone.domain.User;
import market.everyone.dto.UserRequestDto;
import market.everyone.repository.UserrRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final UserrRepository userrRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User signup(UserRequestDto requestDto) {
        Boolean existed = userrRepository.existsByEmail(requestDto.getEmail());
        if (existed) {
            throw new IllegalArgumentException();
        }
        User user = User.createMember(requestDto);
        user.encryptPassword(passwordEncoder);
        return userrRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
      return userrRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteMember(Long id) {
        Boolean existed = userrRepository.existsById(id);
        if(!existed) throw new IllegalArgumentException();
        userrRepository.deleteById(id);
    }


}
