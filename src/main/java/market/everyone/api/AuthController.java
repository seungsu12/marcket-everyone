package market.everyone.api;

import lombok.RequiredArgsConstructor;
import market.everyone.domain.User;
import market.everyone.jwt.JwtTokenProvider;
import market.everyone.repository.UserrRepository;
import market.everyone.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserrRepository userRepository;

    @PostMapping("/join")
    public Long join(@RequestBody Map<String,String> user) {
        return userRepository.save(User.builder()
                .email(user.get("email"))
                .password(passwordEncoder.encode(user.get("password")))
                .roles(Collections.singletonList("ROLE_USER"))
                .build()).getId();
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        User member = userRepository.findByEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("가입 되지 않은 E-MAIL 입니다."));
        if(!passwordEncoder.matches(user.get("password"), member.getPassword())){
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(),member.getRoles());
    }



}
