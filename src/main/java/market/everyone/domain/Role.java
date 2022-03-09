package market.everyone.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("ROLE_USER"),ADMIM("ROLE_ADMIN");

    private final String key;
}
