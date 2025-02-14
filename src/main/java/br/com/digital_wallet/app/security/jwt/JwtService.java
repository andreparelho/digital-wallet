package br.com.digital_wallet.app.security.jwt;

import br.com.digital_wallet.app.user.model.dto.User;
import br.com.digital_wallet.app.user.model.entity.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;


@Service
public class JwtService {
    private final JwtEncoder jwtEncoder;
    private final BCryptPasswordEncoder passwordEncoder;

    public JwtService(JwtEncoder jwtEncoder, BCryptPasswordEncoder passwordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.passwordEncoder = passwordEncoder;
    }

    public JwtClaimsSet getClaims(User user) {
        Instant now = Instant.now();
        long expiresIn = 300l;

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("jwtService.digitalWallet")
                .subject(user.id())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();

        return claims;
    }

    public String getUserToken(JwtClaimsSet claims) {
        try {
            var token = this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

            return token;
        } catch (RuntimeException exception) {

            throw new RuntimeException();
        }
    }

    public String encodePassword(String password) {
        return this.passwordEncoder.encode(password);
    }
}
