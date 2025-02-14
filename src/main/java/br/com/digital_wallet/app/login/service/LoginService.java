package br.com.digital_wallet.app.login.service;

import br.com.digital_wallet.app.security.jwt.JwtService;
import br.com.digital_wallet.app.login.handler.exception.PasswordNotValidException;
import br.com.digital_wallet.app.login.model.response.LoginResponse;
import br.com.digital_wallet.app.login.model.request.LoginRequest;
import br.com.digital_wallet.app.user.handler.exception.UserNotFoundException;
import br.com.digital_wallet.app.user.model.dto.User;
import br.com.digital_wallet.app.user.service.UserService;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UserService userService;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;

    public LoginService(UserService userService, JwtService jwtService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(LoginRequest request) {
        String username = request.username();
        User user = this.userService.getLoggedUser(username);

        if (ObjectUtils.isEmpty(user)) {
            throw new UserNotFoundException("User not found");
        }

        String password = request.password();
        var isValid = isMatchUserPassword(password, user.password());

        if (BooleanUtils.isFalse(isValid)){
            throw new PasswordNotValidException("Invalid password");
        }

        var claims = this.jwtService.getClaims(user);
        var token = this.jwtService.getUserToken(claims);

        return new LoginResponse(token, claims.getExpiresAt());
    }

    private boolean isMatchUserPassword(String requestPassword, String userPassword) {
       return this.passwordEncoder.matches(requestPassword, userPassword);
    }
}
