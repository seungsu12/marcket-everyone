package market.everyone.jwt;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.logging.Logger;

@Component
public class TokenProvider implements InitializingBean {

    private final Logger logger = (Logger) LoggerFactory.getLogger(TokenProvider.class);

    private static final String AUTHORITIES_KEY ="auth";



    private Key key;



    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
